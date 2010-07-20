package fr.uha.ensisa.synchroModel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.sql.SQLException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import param.Rule;

public class DBCopyTest {
	
	DBCopy copy = null;
	
	@Before
	public void connect(){
		EObject[] parametres =  Utils.loadModel(URI.createFileURI(new File("model/My.xmi").getAbsolutePath()), param.ParamPackage.eINSTANCE);
		EList<Rule> rules = ((param.impl.ParamImpl) parametres[0]).getRules();
		try{
			copy = new DBCopy(rules.get(0));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Error!");
		}
	}
	
	@Test
	public void testEmpty(){}
	
	@Test
	public void testFindTable(){
		try {
			Database db = copy.getSource();
			assertNotNull(db.getTable("visit"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNoTable(){
		try {
			Database db = copy.getSource();
			assertNull(db.getTable("aaaaaaaaaaaaaaa"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCopyTable(){
		try {
			Database db = copy.getSource();
			assertNull(db.getTable("aaaaaaaaaaaaaaa"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void closeConn() {
		try {
			copy.close();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		copy = null;
	}
	
}