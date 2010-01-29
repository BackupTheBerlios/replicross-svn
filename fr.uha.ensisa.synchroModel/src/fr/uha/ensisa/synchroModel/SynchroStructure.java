package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.mysql.jdbc.DatabaseMetaData;

import database.Column;
import database.DataBase;
import database.PKey;
import database.DatabaseFactory;
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
		Set<String> tbn = new HashSet<String>();
		while (tablesRS.next()) {
			System.out.println("J'ai trouvé une table: " + tablesRS.getString("TABLE_NAME"));
			tbn.add(tablesRS.getString("TABLE_NAME"));
		}
		
		for (String tbName : tbn) {
			Table table = DatabaseFactory.eINSTANCE.createTable();
			table.setDataBase(database);
			table.setNom(tbName);
			
			//indexes
			ResultSet indexesRs = targetConn.getMetaData().getIndexInfo(null, null, tbName, false, false);
			while(indexesRs.next()){
				System.out.println("Index : " + indexesRs.getString("INDEX_NAME"));
			}
			
			//foreignKeys
			ResultSet foreignKeys = targetConn.getMetaData().getExportedKeys(null, null, tbName);
			while(foreignKeys.next()){
				System.out.println("ForeignKey : " + foreignKeys.getString("FK_NAME") + " " + foreignKeys.getString("UPDATE_RULE"));
			}
			
			//ColumnNames
			ResultSet columnsRS = targetConn.getMetaData().getColumns(null, null, tbName, null);
			while (columnsRS.next()) {
				System.out.println("Colonne: " + columnsRS.getString("COLUMN_NAME") + " " + columnsRS.getString("TYPE_NAME") + " " + columnsRS.getString("COLUMN_DEF"));
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
			
			//PKeysNames
			ResultSet pKeysRS = targetConn.getMetaData().getPrimaryKeys(null, null, tbName);
			Set<String> pkn = new HashSet<String>();
			while (pKeysRS.next()) {
				pkn.add(pKeysRS.getString("COLUMN_NAME"));
				System.out.println("Clé primaire: " + pKeysRS.getString("COLUMN_NAME"));
				PKey pkey = DatabaseFactory.eINSTANCE.createPKey();
				pkey.setNom(pKeysRS.getString("COLUMN_NAME"));
				//@TODO setProperties properties
				table.getPKeys().add(pkey);
			}

			database.getTables().add(table);			
		}
		

		System.out.println("Nombre de tables: " + database.getTables().size());
		System.out.println("Nombre de colonnes: " + database.getTables().get(0).getColumns().size());
		System.out.println("Nombre de clés primaires: " + database.getTables().get(0).getPKeys().size());
		
		EObject[] eobject = new EObject[]{database};
		ModelSaver.saveModel("modelDatabase.xmi", eobject);
			
	}

}
