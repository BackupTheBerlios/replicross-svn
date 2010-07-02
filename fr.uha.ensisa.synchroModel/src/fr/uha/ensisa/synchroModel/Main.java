package fr.uha.ensisa.synchroModel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import param.DataBase;
import param.Param;
import param.ParamFactory;
import param.StructureRule;
import param.Table;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] tablesToKeep = {"visit","cookieid","pole"};
		Param p = ParamFactory.eINSTANCE.createParam();
		StructureRule rule = ParamFactory.eINSTANCE.createStructureRule();
		rule.setPositive(false);
		p.getRules().add(rule);
		DataBase dbSrc = ParamFactory.eINSTANCE.createDataBase();
		dbSrc.setName("waterair");
		dbSrc.setUrl("jdbc:mysql://localhost:3306/waterair");
		DataBase dbTgt = ParamFactory.eINSTANCE.createDataBase();
		dbTgt.setName("wrana");
		dbTgt.setUrl("jdbc:mysql://localhost:3306/wrana");
		p.getDatabases().add(dbSrc);
		p.getDatabases().add(dbTgt);
		for(int i=0;i<tablesToKeep.length;i++){
			Table t = ParamFactory.eINSTANCE.createTable();
			t.setName(tablesToKeep[i]);
			rule.getTables().add(t);
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wrana","wrana","wanar");
			DBStructure dbs = new DBStructure(cn);
			database.DataBase structure = dbs.retrieveStructure(p);
			
			Utils.saveModel(URI.createFileURI(new File("model/structure.xmi").getAbsolutePath()), new EObject[]{structure});
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
