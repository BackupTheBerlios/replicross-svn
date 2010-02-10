package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SynchroStructureTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connModel = DriverManager.getConnection("jdbc:mysql://localhost/replicrossa", "root", "");
		DBStructure synchro = new DBStructure(connModel);
		synchro.retrieveStructure();
	}
}
