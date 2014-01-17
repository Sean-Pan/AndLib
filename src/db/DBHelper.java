package db;

import util.MyApp;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dev on 13. 8. 3.
 */

public class DBHelper extends SQLiteOpenHelper implements IDbCRUD {

	protected static final String KEY_COLUMN = "_id";
	private static final String DB_NAME = "Enter your DB Name"; 
	private static DBHelper mInstance;

	private static SQLiteDatabase mDb;
	
	private DBHelper() {
		super(MyApp.getContext(), DB_NAME, null, 1);
		mDb = mInstance.getWritableDatabase();
	}

	public static DBHelper getInstance() {
		if (mInstance == null) {
			mInstance = new DBHelper();
		}
		return mInstance;
	}

	public void close() {
		if (mInstance != null) {
			mDb.close();
			mInstance = null;
		}
	}


	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		
		/* create a table with interface 
		 * will be implemented reflection form
		 */
		createDB(new TestDBCreator(), sqLiteDatabase);
	}
	
	
	/**
	 * @author se
	 * @version 2014. 1. 17.   
	 * @param dbCreator
	 * @param db 
	 * create a table with DDL
	 */
	private void createDB(IDBCreator dbCreator, SQLiteDatabase db) {
		String[] tableCreateStmt = dbCreator.getCreateTableStmt();

		if (tableCreateStmt != null && tableCreateStmt.length > 0) {
			for (String stmt : tableCreateStmt) {
				db.execSQL(stmt);
			}
		}
	}
	

	@Override
	public Cursor getAllItem(String table, String[] columns) {
		return mDb.query(table, columns, null, null, null, null, null);
	}

	@Override
	public Cursor get(String table, String[] columns, long id) {
		Cursor cursor = mDb.query(true, table, columns, KEY_COLUMN + "=" + id, null, null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();

		return cursor;
	}

	public int getDBVersion() {
		return mDb.getVersion();
	}
	
	@Override
	public Cursor get(String sql) {
		return mDb.rawQuery(sql, null);
	}

	@Override
	public long insert(String table, ContentValues values) {
		return mDb.insert(table, null, values);	
	}

	public long replace(String table, String nullColumnHack, ContentValues values) {
		return mDb.replace(table, nullColumnHack, values);
	}
	
	@Override
	public int update(String table, ContentValues values, long id) {
		return mDb.update(table, values, KEY_COLUMN + "=" + id, null);
	}
	

	@Override
	public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
		return mDb.update(table, values, whereClause, whereArgs);
	}

	@Override
	public int delete(String table, String whereCaluse) {
		return mDb.delete(table, whereCaluse, null);
	}

	@Override
	public int delete(String table, long id) {
		return mDb.delete(table, KEY_COLUMN + "=?" , new String[] {String.valueOf(id)});
	}


	@Override
	public void exec(String sql) {
		mDb.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
