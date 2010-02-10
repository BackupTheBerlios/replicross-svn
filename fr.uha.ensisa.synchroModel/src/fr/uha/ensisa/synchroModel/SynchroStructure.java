package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import database.Column;
import database.DataBase;
import database.DatabaseFactory;
import database.Index;
import database.PKey;
import database.Table;

/**
 * 
 * @author MESSARA Aghilas
 * 
 */

public class SynchroStructure {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, IOException {
		String hostModel, hostCible, DatabaseModel, DatabaseCible, UserModel, UserCible, passwordModel, passwordCible;
		
		hostModel = args[0];
		DatabaseModel = args[1];
		UserModel = args[2];
		passwordModel = args[3];
		
		hostCible = args[4];
		DatabaseCible =  args[5];
		UserCible = args[6];
		passwordCible = args[7];
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection connCible = DriverManager.getConnection("jdbc:mysql://" + hostCible + "/" + DatabaseCible, UserCible, passwordCible);
		DBStructure dbstructure2 = new DBStructure(connCible);
		DataBase DBcible = dbstructure2.retrieveStructure();
		
		Connection connModel = DriverManager.getConnection("jdbc:mysql://" + hostModel + "/" + DatabaseModel, UserModel, passwordModel);
		DBStructure dbstructure = new DBStructure(connModel);
		DataBase DBmodel = dbstructure.retrieveStructure();
		
		System.out.println("Synchronizing structure...");

		for (Table table : DBmodel.getTables()) {
			Table tableCible = DBcible.getTable(table.getNom());
			Statement st = connCible.createStatement();
			if (tableCible == null) {
				String cmd = "CREATE TABLE `" + table.getNom() + "` ( `" + table.getColumns().get(0).getNom() + "` " + table.getColumns().get(0).getType() + " ";
				if(table.getColumns().get(0).getDefault() != null && !table.getColumns().get(0).getDefault().equals("null") && !table.getColumns().get(0).getDefault().equals(""))
					cmd += "DEFAULT '" + table.getColumns().get(0).getDefault() + "' ";
				if( table.getColumns().get(0).isNullable())
					cmd += "NULL);";
				else
					cmd += "NOT NULL);";
				st.execute(cmd);
				tableCible = DatabaseFactory.eINSTANCE.createTable();
				tableCible.setNom(table.getNom());
				Column column = DatabaseFactory.eINSTANCE.createColumn();
				column.setNom(table.getColumns().get(0).getNom());
				column.setType(table.getColumns().get(0).getType());
				column.setNullable(table.getColumns().get(0).isNullable());
				column.setDefault(table.getColumns().get(0).getDefault());
				tableCible.getColumns().add(column);
				DBcible.getTables().add(tableCible);
				System.out.println("Add table " + table.getNom());
			}

			//Columns
			for (Column column : table.getColumns()) {
				
				Column columnCible = tableCible.getColumn(column.getNom());
				if (columnCible == null ) {
					String cmd = "ALTER TABLE `" + tableCible.getNom() + "` ADD `" + column.getNom() + "` " + column.getType() + " ";
					if(column.getDefault() != null && !column.getDefault().equals("null") && !column.getDefault().equals(""))
						cmd += "DEFAULT '" + column.getDefault() + "' ";
					if( column.isNullable())
						cmd += "NULL;";
					else
						cmd += "NOT NULL;";
					st.execute(cmd);
					columnCible = DatabaseFactory.eINSTANCE.createColumn();
					columnCible.setNom(column.getNom());
					columnCible.setType(column.getType());
					columnCible.setNullable(column.isNullable());
					columnCible.setDefault(column.getDefault());
					tableCible.getColumns().add(columnCible);

				}
				else{
					if(columnCible.getDefault() == null || !columnCible.getDefault().equals(column.getDefault()) || !columnCible.getType().equals(column.getType()) || columnCible.isNullable() != column.isNullable()){
						String cmd = "ALTER TABLE `" + tableCible.getNom() + "` CHANGE `" + column.getNom() + "` " + "`" + column.getNom() + "` " + column.getType() + " ";
						if(column.getDefault() != null && !column.getDefault().equals("null") && !column.getDefault().equals(""))
							cmd += "DEFAULT '" + column.getDefault() + "' ";
						if( column.isNullable())
							cmd += "NULL;";
						else
							cmd += "NOT NULL;";
						st.execute(cmd);
						columnCible = DatabaseFactory.eINSTANCE.createColumn();
						columnCible.setNom(column.getNom());
						columnCible.setType(column.getType());
						columnCible.setNullable(column.isNullable());
						columnCible.setDefault(column.getDefault());
					}
				}
				
			}
			
			//Indexes
			for(Index index : table.getIndexes()){
				Index indexCible = tableCible.getIndex(index.getNom());
				if(indexCible == null){
					String cmd = "CREATE INDEX `" + index.getNom() + "` ON `" + table.getNom() + "` (";
					Iterator<Column> it = index.getColumns().iterator();
					while(it.hasNext()){
						cmd += it.next().getNom();
						if(it.hasNext())
							cmd += ", ";
					}
					cmd += ")";
					st.execute(cmd);
				}
			}
			
			//PKeys
			if(table.getPKeys().size() != 0){
				PKey pkeyCible = null;
				if(tableCible.getPKeys().size() != 0)
					pkeyCible = tableCible.getPKeys().get(0);
				if(pkeyCible == null){
					String cmd = "ALTER TABLE `" + tableCible.getNom() + "` ADD PRIMARY KEY `" + "` (";
					Iterator<Column> it = table.getPKeys().get(0).getColumns().iterator();
					while(it.hasNext()){
						cmd += it.next().getNom();
						if(it.hasNext())
							cmd += ", ";
					}
					cmd += ")";
					st.execute(cmd);
				}
			}

		}
	}
	
}
