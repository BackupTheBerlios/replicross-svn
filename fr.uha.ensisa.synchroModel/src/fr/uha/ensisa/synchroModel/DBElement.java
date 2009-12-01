package fr.uha.ensisa.synchroModel;

import java.sql.Connection;

public abstract class DBElement {
	protected final Connection conn;
	
	public DBElement(Connection con) {
		this.conn = con;
	}
}
