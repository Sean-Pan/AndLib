package db;

public class TestDBTable {

	public static final class TestDBScheme {

		public static final String TABLE_NAME = "TEST_TABLE ";

		public static final String COLUMN_ID = DBHelper.KEY_COLUMN;
		public static final String COLUMN_TEST = " TEST_COL ";

		/**
		 * @author se
		 * @version 2014. 1. 17.   
		 * @return 
		 * return a column names String array form
		 * will be replaced by reflection
		 */
		public static String[] getColumnNames() {
			return new String[]{ COLUMN_ID,  COLUMN_TEST };
		}

	
	}
}
