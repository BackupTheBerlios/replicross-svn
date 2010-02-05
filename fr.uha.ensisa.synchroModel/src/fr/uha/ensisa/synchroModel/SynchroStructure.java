package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.mysql.jdbc.DatabaseMetaData;

import database.Column;
import database.DataBase;
import database.DatabaseFactory;
import database.Index;
import database.PKey;
import database.Table;


public class SynchroStructure {
	
	public static final long COPY_BLOCK = 10000;
	private final Connection targetConn;
	
	public SynchroStructure() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	    targetConn = DriverManager.getConnection("jdbc:mysql://localhost/replicrossa", "root", "");
	}
	
	public void synchro() throws SQLException, IOException{
		
		DataBase database = DatabaseFactory.eINSTANCE.createDataBase();
		
		//tableNames
		ResultSet tablesRS = targetConn.getMetaData().getTables(null, null, null, null);
		System.out.println("Je suis connecté");
		while (tablesRS.next()) {
			String tableName = tablesRS.getString("TABLE_NAME");
			
			//table
			Table table = DatabaseFactory.eINSTANCE.createTable();
			table.setDataBase(database);
			table.setNom(tableName);
			System.out.println("------------------------------------------");
			
			//Columns
			ResultSet columnsRS = targetConn.getMetaData().getColumns(null, null, tableName, null);
			while (columnsRS.next()) {
				Column column = DatabaseFactory.eINSTANCE.createColumn();
				column.setNom(columnsRS.getString("COLUMN_NAME"));
				column.setType(columnsRS.getString("TYPE_NAME"));
				column.setDefault(columnsRS.getString("COLUMN_DEF"));
				if( columnsRS.getInt("NULLABLE") == DatabaseMetaData.columnNullable)
					column.setNullable(true);
				else
					column.setNullable(false);
				table.getColumns().add(column);			
			}
			
			//indexes
			ResultSet indexesRs = targetConn.getMetaData().getIndexInfo(null, null, tableName, false, false);
			String lastIndexName = "";
			String indexName = "";
			Index index = DatabaseFactory.eINSTANCE.createIndex();
			while(indexesRs.next()){
				System.out.println("index : " + indexesRs.getString("INDEX_NAME"));
				indexName = indexesRs.getString("INDEX_NAME");
				index.setNom(indexName);
				if(indexName.equals(lastIndexName)){
					index.getColumns().add(table.getColumn(indexesRs.getString("COLUMN_NAME")));
					System.out.println("l'index est le même");
				}
				else{
					System.out.println("je trouve un nouvel indexe");
					if(index.getColumns().size() != 0)
						table.getIndexes().add(index);
					index = DatabaseFactory.eINSTANCE.createIndex();
					index.setNom(indexName);
					index.getColumns().add(table.getColumn(indexesRs.getString("COLUMN_NAME")));
				}
				lastIndexName = indexName;
			}
			
			//PKeysNames
			ResultSet pKeysRS = targetConn.getMetaData().getPrimaryKeys(null, null, tableName);
			PKey pkey = DatabaseFactory.eINSTANCE.createPKey();
			while (pKeysRS.next()) {
				pkey.getColumns().add(table.getColumn(pKeysRS.getString("COLUMN_NAME")));
				pkey.setNom(pKeysRS.getString("PK_NAME"));
			}
			if(pkey.getColumns().size() != 0)
				table.getPKeys().add(pkey);
			
			/*//foreignKeys
			ResultSet foreignKeys = targetConn.getMetaData().getExportedKeys(null, null, tbName);
			while(foreignKeys.next()){
				System.out.println("ForeignKey : " + foreignKeys.getString("FK_NAME") + " " + foreignKeys.getString("UPDATE_RULE"));
			}
			
			
			*/

			database.getTables().add(table);
		}

		System.out.println("Nombre de tables: " + database.getTables().size());
		
		EObject[] eobject = new EObject[]{database};
		ModelSaver.saveModel("modelDatabase.xmi", eobject);

	
	}
}