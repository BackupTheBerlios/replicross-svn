package fr.uha.ensisa.synchroModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Database extends DBElement {
	private final Set<Table> tables;

	public Database(Connection con) throws SQLException {
		super(con);
		Set<String> tbn = getTableNames();
		this.tables = new HashSet<Table>();
		for (String tbName : tbn) {
			this.tables.add(new Table(con, this, tbName));
		}
	}
	
	private Set<String> getTableNames() throws SQLException {
		ResultSet tablesRS = conn.getMetaData().getTables(null, null, null, null);
		Set<String> ret = new HashSet<String>();
		while (tablesRS.next()) {
			ret.add(tablesRS.getString("TABLE_NAME"));
		}
		return ret;
	}

	public Set<Table> getTables() {
		return tables;
	}
	
	public Table getTable(String name) {
		for (Table t : this.getTables()) {
			if (t.getName().equals(name))
				return t;
		}
		return null;
	}
	
	public long getSize() throws SQLException {
		long ret = 0;
		for (Table t : this.getTables()) {
			ret += t.getSize();
		}
		return ret;
	}
	
}
