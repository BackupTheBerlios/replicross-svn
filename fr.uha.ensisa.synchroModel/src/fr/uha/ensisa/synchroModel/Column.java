package fr.uha.ensisa.synchroModel;

import java.sql.Connection;

public class Column extends DBElement {
	private final Table table;
	private final String name;

	public Column(Connection con, Table table, String name) {
		super(con);
		this.table = table;
		this.name = name;
	}

	public Table getTable() {
		return this.table;
	}

	public String getName() {
		return name;
	}
}
