package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.SQLException;


public class SynchroStructureTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		SynchroStructure synchro = new SynchroStructure();
			synchro.synchro();
		}
}
