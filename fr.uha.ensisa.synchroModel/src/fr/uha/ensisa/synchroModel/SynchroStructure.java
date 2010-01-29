package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import database.Column;
import database.DataBase;
import database.DatabaseFactory;
import database.PKey;
import database.Table;


public class SynchroStructure {
	
	public static final long COPY_BLOCK = 10000;
	private final Connection targetConn;
	
	public SynchroStructure() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	    targetConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/replicrossa", "root", "");
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
		System.out.println(tbn.size());
		for (String tbName : tbn) {
			Table table = DatabaseFactory.eINSTANCE.createTable();
			table.setDataBase(database);
			table.setNom(tbName);
			
			//ColumnNames
			ResultSet columnsRS = targetConn.getMetaData().getColumns(null, null, tbName, null);
			Set<String> cln = new HashSet<String>();
			while (columnsRS.next()) {
				cln.add(columnsRS.getString("COLUMN_NAME"));
				System.out.println("J'ai trouver une colonne: " + columnsRS.getString("COLUMN_NAME"));
			}
			for (String colName : cln) {
				Column column = DatabaseFactory.eINSTANCE.createColumn();
				column.setNom(colName);
				table.getColumns().add(column);
			}
			
			//PKeysNames
			ResultSet pKeysRS = targetConn.getMetaData().getPrimaryKeys(null, null, tbName);
			Set<String> pkn = new HashSet<String>();
			while (pKeysRS.next()) {
				pkn.add(pKeysRS.getString("COLUMN_NAME"));
				System.out.println("J'ai trouver une clé primaire: " + pKeysRS.getString("COLUMN_NAME"));
			}
			for (String pkeyName : pkn) {
				Column column = DatabaseFactory.eINSTANCE.createColumn();
				column.setNom(pkeyName);
				table.getPKeys().add((PKey) column);
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
