package db;

import db.TestDBTable.TestDBScheme;

public class TestDBCreator implements IDBCreator {

	@Override
	public String[] getCreateTableStmt() {
	
		/* DDL statement */
		final String TEST_TABLE_CREATE_STMT = "CREATE TABLE "
				+ TestDBScheme.TABLE_NAME + " ("
				+ TestDBScheme.COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
				+ TestDBScheme.COLUMN_TEST + " TEXT, " + ");";

		return new String[]{ TEST_TABLE_CREATE_STMT };
	}

	@Override
	public String[] getInitDataStmt() {
		return new String[0];
	}
}
