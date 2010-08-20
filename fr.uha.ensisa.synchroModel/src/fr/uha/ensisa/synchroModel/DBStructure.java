package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import param.Param;
import param.Rule;

import com.mysql.jdbc.DatabaseMetaData;

import database.Column;
import database.DataBase;
import database.DatabaseFactory;
import database.Index;
import database.PrimaryKey;
import database.Table;

public class DBStructure {

	public static final long COPY_BLOCK = 10000;
	private final Connection targetConn;

	public DBStructure(Connection conn) throws SQLException,
			ClassNotFoundException {
		targetConn = conn;
	}

	public DataBase retrieveStructure() throws SQLException, IOException {
		return this.retrieveStructure(null);
	}
	
	public DataBase retrieveStructure(Param p) throws SQLException, IOException {

		boolean constrained = p!=null, positive = true;
		List<String> names = new ArrayList<String>();
		
		if(constrained){
			for(Rule rule: p.getRules()){
				positive = rule.isPositive();
				for(param.Table t: rule.getTables())
					names.add(t.getName());
			}
		}
		
		DataBase database = DatabaseFactory.eINSTANCE.createDataBase();
		
		System.out.println("Retrieving '" + targetConn.getCatalog() + "' database structure...");

		// tableNames
		ResultSet tablesRS = targetConn.getMetaData().getTables(null, null,
				null, null);
		while (tablesRS.next()) {
			String tableName = tablesRS.getString("TABLE_NAME");
			
			Statement st = targetConn.createStatement();
			ResultSet rsTest = st.executeQuery("SELECT * FROM `"+tableName+"` LIMIT 1");
			ResultSetMetaData rsmd = rsTest.getMetaData();
			
			if(!constrained || !(positive^names.contains(tableName))){
				// table
				Table table = DatabaseFactory.eINSTANCE.createTable();
				table.setDataBase(database);
				table.setName(tableName);
				
				// Columns
				ResultSet columnsRS = targetConn.getMetaData().getColumns(null,
						null, tableName, null);
				int i=1;
				while (columnsRS.next()) {
					Column column = DatabaseFactory.eINSTANCE.createColumn();
					column.setName(columnsRS.getString("COLUMN_NAME"));
					column.setType(rsmd.getColumnTypeName(i));
					column.setDefault(columnsRS.getString("COLUMN_DEF"));
					switch(columnsRS.getInt("DATA_TYPE")){
						case -4: // LONGBLOB
						case 8: // DOUBLE
						case 91: // DATE
						case 92: // TIME
							column.setLength(0);
							break;
						default: // OTHER TYPES
							column.setLength(rsmd.getColumnDisplaySize(i));
							break;
					}
					if (columnsRS.getInt("NULLABLE") == DatabaseMetaData.columnNullable)
						column.setNullable(true);
					else
						column.setNullable(false);
					table.getColumns().add(column);
					i++;
				}
	
				// indexes
				ResultSet indexesRs = targetConn.getMetaData().getIndexInfo(null,
						null, tableName, false, false);
				while (indexesRs.next()) {
					String indexName = indexesRs.getString("INDEX_NAME");
					Index index;
					if (!indexName.equals("PRIMARY")){
						if(table.getIndex(indexName)!=null)
							table.getIndex(indexName).getColumns().add(
									table.getColumn(indexesRs.getString("COLUMN_NAME")));
						else{
							if(indexesRs.getBoolean("NON_UNIQUE"))
								index = DatabaseFactory.eINSTANCE.createIndex();
							else
								index = DatabaseFactory.eINSTANCE.createUnique();
							index.setName(indexName);
							index.getColumns().add(table.getColumn(indexesRs.getString("COLUMN_NAME")));
							table.getIndexes().add(index);
						}
					}
					
				}
	
				// PKeysNames
				ResultSet pKeysRS = targetConn.getMetaData().getPrimaryKeys(null,
						null, tableName);
				PrimaryKey pkey = DatabaseFactory.eINSTANCE.createPrimaryKey();
				while (pKeysRS.next()) {
					pkey.getColumns().add(
							table.getColumn(pKeysRS.getString("COLUMN_NAME")));
					pkey.setName(pKeysRS.getString("PK_NAME"));
				}
				if (pkey.getColumns().size() != 0)
					table.getIndexes().add(pkey);
	
				database.getTables().add(table);
			}
		}

		System.out.println("Structure retieved");
		return database;
	}
}