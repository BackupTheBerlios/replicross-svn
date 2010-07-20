package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyleContext.SmallAttributeSet;

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
		
		System.out.println("Retrieving database structure...");

		// tableNames
		ResultSet tablesRS = targetConn.getMetaData().getTables(null, null,
				null, null);
		while (tablesRS.next()) {
			String tableName = tablesRS.getString("TABLE_NAME");

			if(!constrained || !(positive^names.contains(tableName))){
				// table
				Table table = DatabaseFactory.eINSTANCE.createTable();
				table.setDataBase(database);
				table.setName(tableName);
				
				// Columns
				ResultSet columnsRS = targetConn.getMetaData().getColumns(null,
						null, tableName, null);
				while (columnsRS.next()) {
					Column column = DatabaseFactory.eINSTANCE.createColumn();
					column.setName(columnsRS.getString("COLUMN_NAME"));
					column.setType(columnsRS.getString("TYPE_NAME"));
					switch(columnsRS.getInt("DATA_TYPE")){
						case -7: // BIT
							if(columnsRS.getString("COLUMN_DEF")!=null){
								column.setType("TINYINT");
								column.setDefault(columnsRS.getString("COLUMN_DEF"));
							}
							column.setLength(columnsRS.getInt("COLUMN_SIZE")+1);
							break;
						case -6: // TINYINT
							column.setLength(columnsRS.getInt("COLUMN_SIZE"));
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case -5: // BIGINT
							column.setLength(columnsRS.getInt("COLUMN_SIZE")+1);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case -4: // LONGBLOB
							column.setLength(0);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case 4: // INT
							column.setLength(columnsRS.getInt("COLUMN_SIZE")+1);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case 5: // SMALLINT
							column.setLength(columnsRS.getInt("COLUMN_SIZE")+1);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case 8: // DOUBLE
							column.setLength(0);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case 91: // DATE
							column.setLength(0);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						case 92: // TIME
							column.setLength(0);
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
						default: // OTHER TYPES
							column.setLength(columnsRS.getInt("COLUMN_SIZE"));
							column.setDefault(columnsRS.getString("COLUMN_DEF"));
							break;
					}
					if (columnsRS.getInt("NULLABLE") == DatabaseMetaData.columnNullable)
						column.setNullable(true);
					else
						column.setNullable(false);
					table.getColumns().add(column);
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
	
				// foreignKeys
				/*
				 * ResultSet foreignKeys =
				 * targetConn.getMetaData().getExportedKeys(null, null, tableName);
				 * while(foreignKeys.next()){ System.out.println(tableName +
				 * " ForeignKey : " + foreignKeys.getString("FK_NAME") + " " +
				 * foreignKeys.getString("UPDATE_RULE")); }
				 */
	
				database.getTables().add(table);
			}
		}

		System.out.println("Structure retieved");
		return database;
	}
}