package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import logmodel.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import param.Rule;

public class DBCopy {
	public static final long COPY_BLOCK = 10000;
	private final Connection sourceConn, targetConn;
	private transient Database source = null, target = null;
	
	/**
	 * 
	 * @param sourceDb JDBC url to the database to be saved of the form <code>jdbc:mysql://DBServer:DBServerPort/DatabaseName?user=UserName&password=UserPassword</code>
	 * @param targetDb JDBC url to the destination database of the form <code>jdbc:mysql://DBServer:DBServerPort/DatabaseName?user=UserName&password=UserPassword</code>
	 * @throws ClassNotFoundException in case the MySQL driver is not found
	 * @throws SQLException
	 */
	public DBCopy(Rule rule) throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    sourceConn = DriverManager.getConnection(rule.getSource().getUrl(), rule.getSource().getUsers().get(0).getUserName(), rule.getSource().getUsers().get(0).getPass());
	    targetConn = DriverManager.getConnection(rule.getTarget().getUrl(), rule.getTarget().getUsers().get(0).getUserName(), rule.getTarget().getUsers().get(0).getPass());
	}

	public void close() throws SQLException {
		try {
			sourceConn.close();
		} finally {
		}
		try {
			targetConn.close();
		} finally {
		}
	}

	public Database getSource() throws SQLException {
		if (this.source == null) {
			this.source = new Database(this.sourceConn);
		}
		return this.source;
	}

	public Database getTarget() throws SQLException {
		if (this.target == null) {
			this.target = new Database(this.targetConn);
		}
		return this.target;
	}
	
	public CopyResult override(Rule rule, Log log) {
		return this.override(false, null, true, rule, log);
	}
	
	public boolean differInSize(Table t1, Table t2) throws SQLException {
		long s1 = t1.getSize();
		return ((double)(s1-t2.getSize())/((double)s1) > 0.2);
	}
	
	public CopyResult override(boolean ifDiffer, Set<Table> tables, boolean flushBefore, Rule rule, Log log) {
		CopyResult ret = new CopyResult();
		try {
			Database src = this.getSource(), tgt = this.getTarget();
			
			for (Table srcTable : src.getTables()) {
				Table dstTable = tgt.getTable(srcTable.getName());
				if (dstTable == null) {
					ret.addError("Unknown target table " + srcTable.getName());
					TableNotFound tnf = LogmodelFactory.eINSTANCE.createTableNotFound();
					tnf.setTableName(srcTable.getName());
					tnf.setRule(rule);
					log.getErrors().add(tnf);
				} else {
					long size = srcTable.getSize();
					if ((tables == null || tables.contains(dstTable)) && (!ifDiffer || this.differInSize(srcTable, dstTable))) { //InnoDB is APPROXIMATE in counting rows. Assuming a 20% difference.
						ret.addMessage("Processing table " + srcTable.getName() + " with " + size + " records.");
						if (flushBefore) {
							dstTable.truncate();
							if (dstTable.getSize() != 0){
								ret.addError("Could not truncate " + dstTable.getName());
								CouldNotTruncate cnt = LogmodelFactory.eINSTANCE.createCouldNotTruncate();
								cnt.setTableName(dstTable.getName());
								cnt.setRule(rule);
								log.getErrors().add(cnt);
								}
						}
						boolean shouldStop = false;
						for (int i = 0; !shouldStop; i += COPY_BLOCK) {
							Statement st = sourceConn.createStatement();
							try {
								String order = "";
								boolean fst = true;
								for (Column pkcol : srcTable.getPrimaryKeys()) {
									if (fst) {
										fst = false;
										order = " ORDER BY ";
									} else
										order += ", ";
									order += '`' + pkcol.getName() + '`';
								}
								String cmd = "SELECT * FROM `" + srcTable.getName() + "`" + order + " LIMIT " + Long.toString(i) + ", " + Long.toString(COPY_BLOCK);
								ResultSet rs = st.executeQuery(cmd);
								//ret.printProgress("Got answer from source.");
								SQLWarning w = st.getWarnings();
								while (w != null) {
									ret.addError(w.getMessage());
									w = w.getNextWarning();
								}
								shouldStop = true;
								while (rs.next()) {
									shouldStop = false;
									String vals = "";
									fst = true;
									for (Column col : srcTable.getColumns()) {
										String val = rs.getString(col.getName()); //@ TODO use lastWasNull to handle null value (result here is either the "null" string or just null) 
										if (val != null) {
											if (fst)
												fst = false;
											else
												vals += ',';
											val = val.replace("'", "\'");
											vals += '`' + col.getName() + '`' + " = " + '\'' + val + '\'';
										}
									}
									Statement ups = targetConn.createStatement();
									String upsql = "INSERT INTO " + dstTable.getName() + " SET " + vals;
									try {
										ups.execute(upsql);
									} catch (SQLException x) {
										if (flushBefore || !x.getMessage().contains("Duplicate")) {
											ret.addError("Error running update " + upsql + ":"+x.getMessage());
											SQLError sqle = LogmodelFactory.eINSTANCE.createSQLError();
											sqle.setError("Error running update " + upsql + ":"+x.getMessage());
											sqle.setRule(rule);
											log.getErrors().add(sqle);
										}
									} finally {
										ups.close();
									}
								}
								rs.close();
								ret.printProgress("    Processed from record " + i + " to record " + (i+COPY_BLOCK) + ".");
							} finally {
								st.close();
							}
						}
						long tgSize = dstTable.getSize();
						if (!this.differInSize(srcTable, dstTable))
							ret.addMessage("    Source and target " + srcTable.getName() + " have same size.");
						else{
							ret.addError("    Source and target " + srcTable.getName() + " differ in size (target is " + tgSize + ").");
						}
					}	
				}
				
			}
		} catch (SQLException x) {
			ret.addError(x.getMessage());
			SQLError sqle = LogmodelFactory.eINSTANCE.createSQLError();
			sqle.setError(x.getMessage());
			sqle.setRule(rule);
			log.getErrors().add(sqle);
		}
		
		return ret;
	}
	
	public Set<Table> checkSourceAndTargetSize() throws SQLException {
		Set<Table> ret = new HashSet<Table>();
		for (Table srcTable : this.getSource().getTables()) {
			Table desTable = this.getTarget().getTable(srcTable.getName());
			if (desTable == null || this.differInSize(srcTable, desTable))
				ret.add(desTable);
		}
		return ret;
	}
	
	private static void printHelp() {
		System.out.println("Usage: java " + DBCopy.class.getCanonicalName() + " [-all | -check | -repair | -table <table_name>]");
		System.out.println("-all overrides the complete target database with the source database");
		System.out.println("-check checks the difference between bases (in number of records)");
		System.out.println("-repair overrides only tables with different number of records");
		System.out.println("-table <table_name1 table_name2 ...> overrides only the given tables with prior erasing of target tables");
		System.out.println("-update-table <table_name1 table_name2 ...> copy only the given tables with no prior erasing of target tables");
	}
	
	/**@param sourceXMI File location of the model serialization *
	 * @param pack Singleton object of the main package instance (e.g. UMLPackage.eINSTANCE) *
	 * @return The set of roots found in the serialized model 
	 * @throws IOException */
	
	
	public static void main(String [] args) throws IOException {
		
		EObject[] parametres =  ModelLoader.loadModel(args[0], param.ParamPackage.eINSTANCE);
		EList<Rule> rules = ((param.impl.ParamImpl) parametres[0]).getRules();
		Log log = LogmodelFactory.eINSTANCE.createLog();
		 
		DBCopy cop;
		try {
			for (Rule rule : rules) {
				if (parametres.equals(null)) {
					System.out.println("No parametres found!!");
				} else {
					cop = new DBCopy(rule);
					CopyResult res = null;
					if (rule.isAll()) {
						res = cop.override(rule, log);
					} else if (rule.isCheck()) {
						Set<Table> diff = cop.checkSourceAndTargetSize();
						if (diff.isEmpty())
							System.out.println("No difference found.");
						else {
							for (Table table : diff) {
								System.out.println("Table " + table.getName() + " is outdated." );
							}
						}
					} else if (rule.isRepair()) {
						res = cop.override(true, null, false, rule, log);
					} else if (!rule.getTables().isEmpty()) {
						Database target = cop.getTarget();
						Set<Table> tbd = new HashSet<Table>();
						for (param.Table table : rule.getTables()) {
							String tbName = table.getName();
							Table t = target.getTable(tbName);
							if (t == null) {
								System.err.println(tbName + " not found.");
							} else {
								tbd.add(t);
							}
						}
						res = cop.override(false, tbd, !rule.getTables().isEmpty(), rule, log);
					} else {
						printHelp();
					}
					if (res != null)
						System.out.println("Process ended with " + res.getErrorNumber() + " errors.");
				}
			}
			ModelSaver.saveModel("log.xmi", new EObject[]{log});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
