package fr.uha.ensisa.synchroModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.DatabaseMetaData;

import database.Column;
import database.DataBase;
import database.DatabaseFactory;
import database.Index;
import database.PKey;
import database.Table;

public class DBStructure {

	public static final long COPY_BLOCK = 10000;
	private final Connection targetConn;

	public DBStructure(Connection conn) throws SQLException,
			ClassNotFoundException {
		targetConn = conn;
	}

	public DataBase retrieveStructure() throws SQLException, IOException {

		DataBase database = DatabaseFactory.eINSTANCE.createDataBase();
		
		System.out.println("Retrieving database structure...");

		// tableNames
		ResultSet tablesRS = targetConn.getMetaData().getTables(null, null,
				null, null);
		while (tablesRS.next()) {
			String tableName = tablesRS.getString("TABLE_NAME");

			// table
			Table table = DatabaseFactory.eINSTANCE.createTable();
			table.setDataBase(database);
			table.setNom(tableName);

			// Columns
			ResultSet columnsRS = targetConn.getMetaData().getColumns(null,
					null, tableName, null);
			while (columnsRS.next()) {
				Column column = DatabaseFactory.eINSTANCE.createColumn();
				column.setNom(columnsRS.getString("COLUMN_NAME"));
				String type = columnsRS.getString("TYPE_NAME");
				if (columnsRS.getString("COLUMN_SIZE") != null
						&& !columnsRS.getString("COLUMN_SIZE").equals("0"))
					type += "(" + columnsRS.getString("COLUMN_SIZE") + ")";
				column.setType(type);
				column.setDefault(columnsRS.getString("COLUMN_DEF"));
				if (columnsRS.getInt("NULLABLE") == DatabaseMetaData.columnNullable)
					column.setNullable(true);
				else
					column.setNullable(false);
				table.getColumns().add(column);
			}

			// indexes
			ResultSet indexesRs = targetConn.getMetaData().getIndexInfo(null,
					null, tableName, false, false);
			String lastIndexName = "";
			String indexName = "";
			Index index = DatabaseFactory.eINSTANCE.createIndex();
			while (indexesRs.next()) {
				indexName = indexesRs.getString("INDEX_NAME");
				// index.setNom(indexName);
				if (!indexName.equals("PRIMARY")) {
					if (indexName.equals(lastIndexName))
						index.getColumns().add(
								table.getColumn(indexesRs
										.getString("COLUMN_NAME")));
					else {
						if (index.getColumns().size() != 0) {
							index.setNom(lastIndexName);
							table.getIndexes().add(index);
						}
						index = DatabaseFactory.eINSTANCE.createIndex();
						index.setNom(indexName);
						index.getColumns().add(
								table.getColumn(indexesRs
										.getString("COLUMN_NAME")));
					}
					lastIndexName = indexName;
				}
			}
			if(index.getNom() != null)
				table.getIndexes().add(index);

			// PKeysNames
			ResultSet pKeysRS = targetConn.getMetaData().getPrimaryKeys(null,
					null, tableName);
			PKey pkey = DatabaseFactory.eINSTANCE.createPKey();
			while (pKeysRS.next()) {
				pkey.getColumns().add(
						table.getColumn(pKeysRS.getString("COLUMN_NAME")));
				pkey.setNom(pKeysRS.getString("PK_NAME"));
			}
			if (pkey.getColumns().size() != 0)
				table.getPKeys().add(pkey);

			// foreignKeys
			/*
			 * ResultSet foreignKeys =
			 * targetConn.getMetaData().getExportedKeys(null, null, tableName);
			 * while(foreignKeys.next()){ System.out.println(tableName +
			 * " ForeignKey : " + foreignKeys.getString("FK_NAME") + " " +
			 * foreignKeys.getString("UPDATE_RULE")); }
			 */

			database.getTables().add(table);
		}

		System.out.println("Structure retieved");
		return database;
	}
}