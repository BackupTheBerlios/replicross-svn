package fr.uha.ensisa.synchroModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Table extends DBElement {
	private final String name;
	private final Database database;
	private Set<Column> columns = null;
	private Set<Column> pkeys = null;
	
	public Table(Connection conn, Database db, String name) throws SQLException {
		super(conn);
		this.database = db;
		this.name = name;
		Set<String> con = this.getColumnNames();
		this.columns = new HashSet<Column>();
		for (String colName : con) {
			this.columns.add(new Column(conn, this, colName));
		}
		con = this.getPKeyNames();
		this.pkeys = new HashSet<Column>();
		for (String colName : con) {
			this.pkeys.add(this.getColumn(colName));
		}
	}

	private Set<String> getColumnNames() throws SQLException {
		ResultSet tablesRS = conn.getMetaData().getColumns(null, null, this.getName(), null);
		Set<String> ret = new HashSet<String>();
		while (tablesRS.next()) {
			ret.add(tablesRS.getString("COLUMN_NAME"));
		}
		return ret;
	}
	
	private Set<String> getPKeyNames() throws SQLException {
		ResultSet tablesRS = conn.getMetaData().getPrimaryKeys(null, null, this.getName());
		Set<String> ret = new HashSet<String>();
		while (tablesRS.next()) {
			ret.add(tablesRS.getString("COLUMN_NAME"));
		}
		return ret;
	}
	
	public Database getDatabase() {
		return this.database;
	}

	public String getName() {
		return name;
	}
	
	public Set<Column> getColumns() {
		return columns;
	}
	
	public Set<Column> getPrimaryKeys() {
		return this.pkeys;
	}
	
	public Column getColumn(String name) {
		for (Column c : this.getColumns()) {
			if (c.getName().equals(name))
				return c;
		}
		return null;
	}
	
	public long getSize() throws SQLException {
		Statement st = conn.createStatement();
		try {
			ResultSet rs = st.executeQuery("SHOW TABLE STATUS LIKE '" + this.getName() + '\'');
			try {
				rs.next();
				return rs.getLong("Rows");
			} finally {
				rs.close();
			}
		} finally {
			st.close();
		}
	}
	
	public void truncate() throws SQLException {
		Statement st = conn.createStatement();
		try {
			st.execute("TRUNCATE TABLE `" + this.getName() + '`');
		} finally {
			st.close();	
		}
	}
}
