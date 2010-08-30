package fr.uha.ensisa.synchroModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import param.Param;
import param.ParamPackage;

import database.Column;
import database.DataBase;
import database.DatabaseFactory;
import database.Index;
import database.PrimaryKey;
import database.Table;
import database.Unique;

/**
 * 
 * @author MESSARA Aghilas & WITTMANN Brice
 * 
 */

public class SynchroStructure {
	
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, IOException, InterruptedException {
		String hostModel, hostCible, DatabaseModel, DatabaseCible, UserModel, UserCible, passwordModel, passwordCible, rulesModelURI;
		boolean check = false, force = false, help = false;
		
		if(args.length<8){
			displayHelpMenu();
			System.exit(0);
		}
		
		hostModel = args[0];
		DatabaseModel = args[1];
		UserModel = args[2];
		passwordModel = args[3];
		
		hostCible = args[4];
		DatabaseCible =  args[5];
		UserCible = args[6];
		passwordCible = args[7];

		rulesModelURI = null;
			
		for(int i=8;i<args.length;i++){
			if(args[i].equals("-check")){
				check = true;
			}
			else if(args[i].equals("-force")){
				force = true;
			}
			else if(args[i].equals("-rules"))
				rulesModelURI = args[++i];
			else if(args[i].equals("-help"))
				help = true;
			else
				System.out.println("Unknow option: "+args[i]);
		}
		
		if((force && check) || help){
			displayHelpMenu();
			System.exit(0);
		}
		
		Param p = null;
		if(rulesModelURI!=null)
			p = (Param)Utils.loadModel(URI.createFileURI(new File(rulesModelURI).getAbsolutePath()), ParamPackage.eINSTANCE)[0];
		Class.forName("com.mysql.jdbc.Driver");

		System.out.println("Connecting to databases...");
		Connection connCible = DriverManager.getConnection("jdbc:mysql://" + hostCible + "/" + DatabaseCible, UserCible, passwordCible);
		DBStructure dbstructure2 = new DBStructure(connCible);
		DataBase DBcible = dbstructure2.retrieveStructure(p);
		
		Connection connModel = DriverManager.getConnection("jdbc:mysql://" + hostModel + "/" + DatabaseModel, UserModel, passwordModel);
		DBStructure dbstructure = new DBStructure(connModel);
		DataBase DBmodel = dbstructure.retrieveStructure(p);
		
		System.out.println("Structure Comparaison");
		if(Utils.compareDataBases(DBmodel, DBcible))
			System.out.println("Databases structures are the same");
		else{
			
			List<String> queries = new ArrayList<String>();
			Statement st = connCible.createStatement();
		
			System.out.println("Synchronizing structure...");
	
			for (Table table : DBmodel.getTables()) {
				Table tableCible = DBcible.getTable(table.getName());
				if (tableCible == null) {
					String cmd = "CREATE TABLE `" + table.getName() + "` ( `" + table.getColumns().get(0).getName() + "` " + table.getColumns().get(0).getType() + ((table.getColumns().get(0).getLength()==0)? " " : "(" + table.getColumns().get(0).getLength() + ") ");
					if(table.getColumns().get(0).getDefault() != null && !table.getColumns().get(0).getDefault().equals("null") && !table.getColumns().get(0).getDefault().equals(""))
						cmd += "DEFAULT '" + table.getColumns().get(0).getDefault() + "' ";
					if(table.getColumns().get(0).isNullable())
						cmd += "NULL)";
					else
						cmd += "NOT NULL)";
					cmd += " ENGINE = " + table.getStorageEngine();
					cmd += " CHARACTER SET utf8 COLLATE utf8_bin";
					queries.add(cmd);
//					System.out.println(cmd);
//					st.execute(cmd);
					tableCible = DatabaseFactory.eINSTANCE.createTable();
					tableCible.setName(table.getName());
					Column column = DatabaseFactory.eINSTANCE.createColumn();
					column.setName(table.getColumns().get(0).getName());
					column.setType(table.getColumns().get(0).getType());
					column.setNullable(table.getColumns().get(0).isNullable());
					column.setDefault(table.getColumns().get(0).getDefault());
					tableCible.getColumns().add(column);
					DBcible.getTables().add(tableCible);
				}
	
				//Columns
				Column previousCol = null;
				for (Column column : table.getColumns()) {
					
					Column columnCible = tableCible.getColumn(column.getName());
					if (columnCible == null ) {
						String cmd = "ALTER TABLE `" + tableCible.getName() + "` ADD `" + column.getName() + "` " + column.getType() + ((column.getLength()==0)? " " : "(" + column.getLength() + ") ");
						if( column.isNullable())
							cmd += "NULL";
						else
							cmd += "NOT NULL";
						if(!(column.getDefault()==null))
							cmd += " DEFAULT '"+column.getDefault()+"'";
						cmd += " AFTER `"+previousCol.getName()+"`;";
						queries.add(cmd);
//						System.out.println(cmd);
//						st.execute(cmd);
						columnCible = DatabaseFactory.eINSTANCE.createColumn();
						columnCible.setName(column.getName());
						columnCible.setType(column.getType());
						columnCible.setLength(column.getLength());
						columnCible.setNullable(column.isNullable());
						columnCible.setDefault(column.getDefault());
						columnCible.setCollation(column.getCollation());
						tableCible.getColumns().add(columnCible);
	
					}
					else{
						if(!Utils.compareColumns(column, columnCible)){
							if(columnCible.getDefault() == null || !columnCible.getDefault().equals(column.getDefault()) || !columnCible.getType().equals(column.getType()) || columnCible.isNullable() != column.isNullable() || columnCible.getLength() != column.getLength()){
								String cmd = "ALTER TABLE `" + tableCible.getName() + "` CHANGE `" + column.getName() + "` " + "`" + column.getName() + "` " + column.getType() + ((column.getLength()==0)? " " : "(" + column.getLength() + ") ");
								if( column.isNullable())
									cmd += "NULL";
								else
									cmd += "NOT NULL";
								if(!(column.getDefault()==null))
									cmd += " DEFAULT '"+column.getDefault()+"'";
								else
									cmd += ";";
								queries.add(cmd);
//								System.out.println(cmd);
//								st.execute(cmd);
								columnCible.setName(column.getName());
								columnCible.setType(column.getType());
								columnCible.setLength(column.getLength());
								columnCible.setNullable(column.isNullable());
								columnCible.setDefault(column.getDefault());
								columnCible.setCollation(column.getCollation());
							}
						}
					}
					previousCol = column;
				}
				
				//Indexes
				for(Index index : table.getIndexes()){
					Index indexCible = tableCible.getIndex(index.getName());
					if(!(indexCible!=null && Utils.compareIndex(index, indexCible))){
						String cmd = "";
						if(index instanceof PrimaryKey){
							cmd = "ALTER TABLE `" + tableCible.getName() + "`";
							if(indexCible!=null){
								cmd += " DROP PRIMARY KEY,";
							}
							cmd += " ADD PRIMARY KEY (`";
							indexCible = DatabaseFactory.eINSTANCE.createPrimaryKey();
						}else if(index instanceof Unique){
							cmd = "ALTER TABLE `" + tableCible.getName() + "`";
							if(indexCible!=null){
								cmd += " DROP INDEX `" + index.getName() + "`,";
							}
							cmd += " ADD UNIQUE `" + index.getName() + "` (`";
							indexCible = DatabaseFactory.eINSTANCE.createUnique();
						}else{
							cmd = "ALTER TABLE `" + tableCible.getName() + "`";
							if(indexCible!=null){
								cmd += " DROP INDEX `" + index.getName() + "`,";
							}
							cmd += " ADD INDEX `" + index.getName() + "` (`";
							indexCible = DatabaseFactory.eINSTANCE.createIndex();
						}
						indexCible.setName(index.getName());
						Iterator<Column> it = index.getColumns().iterator();
						while(it.hasNext()){
							String name = it.next().getName();
							cmd += name;
							if(it.hasNext())
								cmd += "`, `";
							indexCible.getColumns().add(tableCible.getColumn(name));
						}
						cmd += "`)";
						queries.add(cmd);
//						System.out.println(cmd);
//						st.execute(cmd);
						tableCible.getIndexes().add(indexCible);
					}
				}
				
				//Remove indexes
				List<Index> toRemove = new ArrayList<Index>();
				for(Index index: tableCible.getIndexes()){
					if(table.getIndex(index.getName())==null){
						String cmd = "";
						if(index instanceof PrimaryKey){
							cmd = "ALTER TABLE `" + tableCible.getName() + "` DROP PRIMARY KEY";
						}else{
							cmd = "ALTER TABLE `" + tableCible.getName() + "` DROP INDEX `" + index.getName() +"`";
						}
						queries.add(cmd);
//						System.out.println(cmd);
//						st.execute(cmd);
						toRemove.add(index);
					}
				}
				tableCible.getIndexes().removeAll(toRemove);
	
			}
			if(check){
				System.out.println("Queries:");
				for(String query: queries)
					System.out.println(query);
			}
			else if(force){
				for(String query: queries)
					st.execute(query);
				System.out.println("DONE");
			}
			else
				executeQueries(queries, st);
		}
		
		connCible.close();
		connModel.close();
	}
	
	private static void executeQueries(List<String> queries, Statement st) throws IOException, SQLException{
		boolean loop = true;
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		while (loop == true) {
			System.out.println("You are about to execute the following queries:");
			for(String query: queries)
				System.out.println(query);
			System.out.print("Are you sure ? y / n");
			String line = input.readLine();
			if (line == null || line.length() == 0) continue;
			char command = line.charAt(0);
			switch (command) {
			case 'Y' : case 'y' : 
				for(String query: queries){
					st.execute(query);
				}
				loop = false;
				break;
			case 'N' : case 'n' : loop = false; break;
			default  : System.out.println("Unknown command"); break;
			}
		}
		input.close();
		System.out.println("DONE");
	}
	
	private static void displayHelpMenu(){
		System.out.println("Usage: java replicross.jar sourceHost sourceDatabase sourceUser sourcePassword targetHost targetDatabase targetUser targetPassword [-force | -check | -rules rulesModel.xmi]");
		System.out.println("sourceHost, targetHost: host of the database (i.g. localhost)");
		System.out.println("sourceDatabase, targetDatabase: names of the databases to compare");
		System.out.println("sourceUser, targetUser: login of users of each database");
		System.out.println("sourcePassword, targetPassword: passwords of users of each database");
		System.out.println("force: run the synchronization of the databases without asking if changes should be applied or not");
		System.out.println("check: display only the differences between the 2 databases, without applying any changes");
		System.out.println("rules rulesModel.xmi: it is also possible to take account of only some tables of the source database in the comparison. A rules model can be established in order to determine which tables will be used in the database synchronisation. This model must conform to Param.ecore metalodel (available in the SVN of the Replicross project)");
		System.out.println();
		System.out.println("If nor force option, neither check option are mentioned, the program displays the queries to execute and asks the user if these queries can be executed or not");
		System.out.println("On the other hand, if both force and check options are mentioned, the program does nothing");
	}
	
}
