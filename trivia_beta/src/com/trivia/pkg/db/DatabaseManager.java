package com.trivia.pkg.db;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseManager {
	// the Activity or Application that is creating an object from this class.
	Context context;
 
	// a reference to the database used by this application/object
	private SQLiteDatabase db;
 
	// These constants are specific to the database.  They should be 
	// changed to suit your needs.
	private final String DB_NAME = "trivia";
	private final int DB_VERSION = 1;
 
	// These constants are specific to the database table.  They should be
	// changed to suit your needs.
	private final String TABLE_NAME = "table_name";

	private final String TABLE_ROW_ID = "id";
	private final String TABLE_ROW_ONE = "table_row_one";
	private final String TABLE_ROW_TWO = "table_row_two";

	private final String TABLE_MOVIES = "movies";
	private final String TABLE_QUOTES = "quotes";
	
	private final String TABLE_MOVIES_ROW_ID = "id_movie";
	private final String TABLE_MOVIES_ROW_TITLE = "title";
	private final String TABLE_MOVIES_ROW_REVIEW = "review";
	private final String TABLE_MOVIES_ROW_SCORE = "score";
	private final String TABLE_MOVIES_ROW_LINK1 = "link1";
	private final String TABLE_MOVIES_ROW_LINK2 = "link2";
	private final String TABLE_MOVIES_ROW_LINK3 = "link3";
 
	private final String TABLE_QUOTES_ROW_ID = "id_quote";
	private final String TABLE_QUOTES_ROW_MOVIE_ID = "id_movie";
	private final String TABLE_QUOTES_ROW_TEXT = "text";
	private final String TABLE_QUOTES_ROW_READ = "read";
	private final String TABLE_QUOTES_ROW_FAVOURITE = "favorite";
	
 
	public DatabaseManager(Context context)
	{
		this.context = context;
 
		// create or open the database
		CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
	
		//SQLiteDatabase.openDatabase(DB_NAME, null,  SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		//this.db = helper.onOpen(db.openDatabase(DB_NAME, null, db.NO_LOCALIZED_COLLATORS));
		
		this.db = helper.getWritableDatabase();
	}
 
 
 
 
	/**********************************************************************
	 * ADDING A ROW TO THE DATABASE TABLE
	 * 
	 * This is an example of how to add a row to a database table
	 * using this class.  You should edit this method to suit your
	 * needs.
	 * 
	 * the key is automatically assigned by the database
	 * @param rowStringOne the value for the row's first column
	 * @param rowStringTwo the value for the row's second column 
	 */
	public void addRow(String rowStringOne, String rowStringTwo)
	{
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		values.put(TABLE_ROW_ONE, rowStringOne);
		values.put(TABLE_ROW_TWO, rowStringTwo);
 
		// ask the database object to insert the new data 
		try{db.insert(TABLE_NAME, null, values);}
		catch(Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}

	public void addRow_Movie(int id_movie, String title, String review,Double score,String link1, String link2,String link3)
	{
		
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		values.put(TABLE_MOVIES_ROW_ID, id_movie);
		values.put(TABLE_MOVIES_ROW_TITLE, title);
		values.put(TABLE_MOVIES_ROW_REVIEW, review);
		values.put(TABLE_MOVIES_ROW_SCORE, score);
		values.put(TABLE_MOVIES_ROW_LINK1, link1);
		values.put(TABLE_MOVIES_ROW_LINK2, link2);
		values.put(TABLE_MOVIES_ROW_LINK3, link3);

		// ask the database object to insert the new data 
		try{db.insert(TABLE_MOVIES, null, values);}
		catch(Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}
	public String descquote()
	{
		 db.execSQL("describe quotes");
		return TABLE_QUOTES ;
	}
	public void addRow_Quote(int id_quote,int movie_id,String text,int i,int j)
	{
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		values.put(TABLE_QUOTES_ROW_ID, id_quote);
		values.put(TABLE_QUOTES_ROW_MOVIE_ID, movie_id);
		values.put(TABLE_QUOTES_ROW_TEXT, text);
		values.put(TABLE_QUOTES_ROW_READ, i);
		values.put(TABLE_QUOTES_ROW_FAVOURITE, j);

		// ask the database object to insert the new data 
		try{db.insert(TABLE_QUOTES, null, values); }
		catch(Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}
 
	/**********************************************************************
	 * DELETING A ROW FROM THE DATABASE TABLE
	 * 
	 * This is an example of how to delete a row from a database table
	 * using this class. In most cases, this method probably does
	 * not need to be rewritten.
	 * 
	 * @param rowID the SQLite database identifier for the row to delete.
	 */
	public void deleteRow(long rowID)
	{
		// ask the database manager to delete the row of given id
		try {db.delete(TABLE_NAME, TABLE_ROW_ID + "=" + rowID, null);}
		catch (Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}

	public void deleteRow_Movie(long rowID)
	{
		// ask the database manager to delete the row of given id
		try {db.delete(TABLE_MOVIES, TABLE_MOVIES_ROW_ID + "=" + rowID, null);}
		catch (Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}

	public void deleteRow_Quote(long rowID)
	{
		// ask the database manager to delete the row of given id
		try {db.delete(TABLE_QUOTES, TABLE_QUOTES_ROW_ID + "=" + rowID, null);}
		catch (Exception e)
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
	}
	
	/**********************************************************************
	 * UPDATING A ROW IN THE DATABASE TABLE
	 * 
	 * This is an example of how to update a row in the database table
	 * using this class.  You should edit this method to suit your needs.
	 * 
	 * @param rowID the SQLite database identifier for the row to update.
	 * @param rowStringOne the new value for the row's first column
	 * @param rowStringTwo the new value for the row's second column 
	 */ 
	public void updateRow(long rowID, String rowStringOne, String rowStringTwo)
	{
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		values.put(TABLE_ROW_ONE, rowStringOne);
		values.put(TABLE_ROW_TWO, rowStringTwo);
 
		try {db.update(TABLE_NAME, values, TABLE_ROW_ID + "=" + rowID, null);}
		catch (Exception e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
	}

	public void updateRow_Movie(long rowID, String title, String review,float score,String link1,String link2,String link3)
	{
		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		values.put(TABLE_MOVIES_ROW_TITLE, title);
		values.put(TABLE_MOVIES_ROW_REVIEW, review);
		values.put(TABLE_MOVIES_ROW_SCORE, score);
		values.put(TABLE_MOVIES_ROW_LINK1, link1);
		values.put(TABLE_MOVIES_ROW_LINK2, link2);
		values.put(TABLE_MOVIES_ROW_LINK3, link3);
 
		// ask the database object to update the database row of given rowID
		try {db.update(TABLE_MOVIES, values, TABLE_MOVIES_ROW_ID + "=" + rowID, null);}
		catch (Exception e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
	}
	public void updateRow_Quote(long rowID, long movie_id, String text, int i, int j )
	{

		// this is a key value pair holder used by android's SQLite functions
		ContentValues values = new ContentValues();
		values.put(TABLE_QUOTES_ROW_MOVIE_ID, movie_id);
		values.put(TABLE_QUOTES_ROW_TEXT, text);
		values.put(TABLE_QUOTES_ROW_READ, i);
		values.put(TABLE_QUOTES_ROW_FAVOURITE, j);
		//Toast.makeText(context, "Added to Favourite"  , 1).show();
		// ask the database object to update the database row of given rowID
		try {db.update(TABLE_QUOTES, values, TABLE_QUOTES_ROW_ID +"="  + rowID, null); /*db.close();*/}
		catch (Exception e)
		{
			Toast.makeText(context,  e.toString() , 1).show();
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
	}
	public void updateRow_Fvaourite_Quote(long rowID, boolean favourite )
	{
		//rowID = 2;
		// this is a key value pair holder used by android's SQLite functions
		//ContentValues values = new ContentValues();
		//values.put(TABLE_QUOTES_ROW_FAVOURITE, true);
 
		// ask the database object to update the database row of given rowID
		try {
			db.rawQuery("update quotes set favorite=1 where id_quote="+ String.valueOf(rowID)+ ";", null);
		}
		//try {db.update(TABLE_QUOTES, values, TABLE_QUOTES_ROW_ID +"="  + rowID, null); db.close();}
		catch (Exception e)
		{
			Toast.makeText(context, e.toString(), 1);
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
	}


	/**********************************************************************
	 * RETRIEVING A ROW FROM THE DATABASE TABLE
	 * 
	 * This is an example of how to retrieve a row from a database table
	 * using this class.  You should edit this method to suit your needs.
	 * 
	 * @param rowID the id of the row to retrieve
	 * @return an array containing the data from the row
	 */
	public ArrayList<Object> getRowAsArray(long rowID)
	{
		// create an array list to store data from the database row.
		// I would recommend creating a JavaBean compliant object 
		// to store this data instead.  That way you can ensure
		// data types are correct.
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;
 
		try
		{
			// this is a database call that creates a "cursor" object.
			// the cursor object store the information collected from the
			// database and is used to iterate through the data.
			cursor = db.query
			(
					TABLE_NAME,
					new String[] { TABLE_ROW_ID, TABLE_ROW_ONE, TABLE_ROW_TWO },
					TABLE_ROW_ID + "=" + rowID,
					null, null, null, null, null
			);
 
			// move the pointer to position zero in the cursor.
			cursor.moveToFirst();
 
			// if there is data available after the cursor's pointer, add
			// it to the ArrayList that will be returned by the method.
			if (!cursor.isAfterLast())
			{
				do
				{
					rowArray.add(cursor.getLong(0));
					rowArray.add(cursor.getString(1));
					rowArray.add(cursor.getString(2));
				}
				while (cursor.moveToNext());
			}
 
			// let java know that you are through with the cursor.
			cursor.close();
		}
		catch (SQLException e) 
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList containing the given row from the database.
		return rowArray;
	}
	public Integer getMovieTotalCount()
	{
		int counter = 0;
		Cursor cursor;
 
		try
		{
			// this is a database call that creates a "cursor" object.
			// the cursor object store the information collected from the
			// database and is used to iterate through the data.
			cursor = db.rawQuery("SELECT Count(*) FROM movies;", null);
 
			// move the pointer to position zero in the cursor.
			cursor.moveToFirst();

			counter = cursor.getInt(0);
			cursor.close();
		}
		catch (SQLException e) 
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
		//Toast.makeText(context, "Counter"+ String.valueOf(counter), 1).show();
		return counter;
	}
 	
	public ArrayList<Object> getRowAsArray_Movie(long rowID)
	{
		// create an array list to store data from the database row.
		// I would recommend creating a JavaBean compliant object 
		// to store this data instead.  That way you can ensure
		// data types are correct.
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;
 
		try
		{
			// this is a database call that creates a "cursor" object.
			// the cursor object store the information collected from the
			// database and is used to iterate through the data.
			cursor = db.query
			(
					TABLE_MOVIES,
					new String[] { TABLE_MOVIES_ROW_ID, TABLE_MOVIES_ROW_TITLE, TABLE_MOVIES_ROW_REVIEW, TABLE_MOVIES_ROW_SCORE, TABLE_MOVIES_ROW_LINK1, TABLE_MOVIES_ROW_LINK2, TABLE_MOVIES_ROW_LINK3 },
					TABLE_MOVIES_ROW_ID + "=" + rowID,
					null, null, null, null, null
			);
 
			// move the pointer to position zero in the cursor.
			cursor.moveToFirst();
 
			// if there is data available after the cursor's pointer, add
			// it to the ArrayList that will be returned by the method.
			if (!cursor.isAfterLast())
			{
				do
				{
					rowArray.add(cursor.getLong(0));
					rowArray.add(cursor.getString(1));
					rowArray.add(cursor.getString(2));
					rowArray.add(cursor.getFloat(3));
				//	rowArray.add(cursor.getInt(4));//nextDo
					rowArray.add(cursor.getString(4));
					rowArray.add(cursor.getString(5));
					rowArray.add(cursor.getString(6));
				}
				while (cursor.moveToNext());
			}
 
			// let java know that you are through with the cursor.
			cursor.close();
		}
		catch (SQLException e) 
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList containing the given row from the database.
		return rowArray;
	}
 
	public ArrayList<Object> getRowAsArray_Quote(long rowID)
	{
		// create an array list to store data from the database row.
		// I would recommend creating a JavaBean compliant object 
		// to store this data instead.  That way you can ensure
		// data types are correct.
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;
 
		try
		{
			// this is a database call that creates a "cursor" object.
			// the cursor object store the information collected from the
			// database and is used to iterate through the data.
			cursor = db.query
			(
					TABLE_QUOTES,
					new String[] { TABLE_QUOTES_ROW_ID, TABLE_QUOTES_ROW_MOVIE_ID, TABLE_QUOTES_ROW_TEXT, TABLE_QUOTES_ROW_READ, TABLE_QUOTES_ROW_FAVOURITE },
					TABLE_QUOTES_ROW_ID + "=" + rowID,
					null, null, null, null, null
			);
 
			// move the pointer to position zero in the cursor.
			cursor.moveToFirst();
 
			// if there is data available after the cursor's pointer, add
			// it to the ArrayList that will be returned by the method.
			if (!cursor.isAfterLast())
			{
				do
				{
					rowArray.add(cursor.getInt(0));
					rowArray.add(cursor.getInt(1));
					rowArray.add(cursor.getString(2));
					rowArray.add(cursor.getString(3));
					rowArray.add(cursor.getString(4));
				}
				while (cursor.moveToNext());
			}
 
			// let java know that you are through with the cursor.
			cursor.close();
		}
		catch (SQLException e) 
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList containing the given row from the database.
		return rowArray;
	}
	public ArrayList<Object> getRowAsArray_QuoteUnRead(long rowID)
	{
		// create an array list to store data from the database row.
		// I would recommend creating a JavaBean compliant object 
		// to store this data instead.  That way you can ensure
		// data types are correct.
		ArrayList<Object> rowArray = new ArrayList<Object>();
		Cursor cursor;
 
		try
		{
			//SELECT * FROM table ORDER BY RANDOM() LIMIT 3 where reads='true';
			// this is a database call that creates a "cursor" object.
			// the cursor object store the information collected from the
			// database and is used to iterate through the data.
			cursor = db.query
			(
					TABLE_QUOTES,
					new String[] { TABLE_QUOTES_ROW_ID, TABLE_QUOTES_ROW_MOVIE_ID, TABLE_QUOTES_ROW_TEXT, TABLE_QUOTES_ROW_READ, TABLE_QUOTES_ROW_FAVOURITE },
					TABLE_QUOTES_ROW_ID + "=" + rowID + " AND " + TABLE_QUOTES_ROW_READ+ "="+ 0,
					null, null, null, null, null
			);
 
			// move the pointer to position zero in the cursor.
			cursor.moveToFirst();
 
			// if there is data available after the cursor's pointer, add
			// it to the ArrayList that will be returned by the method.
			if (!cursor.isAfterLast())
			{
				do
				{
					rowArray.add(cursor.getLong(0));
					rowArray.add(cursor.getLong(1));
					rowArray.add(cursor.getString(2));
					rowArray.add(cursor.getShort(3));
					rowArray.add(cursor.getShort(4));
				}
				while (cursor.moveToNext());
			}
 
			// let java know that you are through with the cursor.
			cursor.close();
		}
		catch (SQLException e) 
		{
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList containing the given row from the database.
		return rowArray;
	}

	
	/**********************************************************************
	 * RETRIEVING ALL ROWS FROM THE DATABASE TABLE
	 * 
	 * This is an example of how to retrieve all data from a database
	 * table using this class.  You should edit this method to suit your
	 * needs.
	 * 
	 * the key is automatically assigned by the database
	 */
 
	public ArrayList<ArrayList<Object>> getAllRowsAsArrays()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.query(
					TABLE_NAME,
					new String[]{TABLE_ROW_ID, TABLE_ROW_ONE, TABLE_ROW_TWO},
					null, null, null, null, null
			);
 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 
					dataList.add(cursor.getLong(0));
					dataList.add(cursor.getString(1));
					dataList.add(cursor.getString(2));
 
					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}
 
	public ArrayList<ArrayList<Object>> getAllRowsAsArrays_Movie()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.query(
					TABLE_MOVIES,
					new String[] { TABLE_MOVIES_ROW_ID, TABLE_MOVIES_ROW_TITLE, TABLE_MOVIES_ROW_REVIEW, TABLE_MOVIES_ROW_SCORE, TABLE_MOVIES_ROW_LINK1, TABLE_MOVIES_ROW_LINK2, TABLE_MOVIES_ROW_LINK3 },
					null, null, null, null, null
			);
 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 			
					dataList.add(cursor.getLong(0));
					dataList.add(cursor.getString(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getFloat(3));
					//dataList.add(cursor.getInt(4));//nextDo
					dataList.add(cursor.getString(4));
					dataList.add(cursor.getString(5));
					dataList.add(cursor.getString(6));

					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}

	public ArrayList<ArrayList<Object>> getAllRowsAsArrays_MovieRandom()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.rawQuery("SELECT * FROM movies ORDER BY RANDOM() LIMIT 5;", null);
				/* db.query(
					TABLE_MOVIES,
					new String[] { TABLE_MOVIES_ROW_ID, TABLE_MOVIES_ROW_TITLE, TABLE_MOVIES_ROW_REVIEW, TABLE_MOVIES_ROW_SCORE, TABLE_MOVIES_ROW_LINK1, TABLE_MOVIES_ROW_LINK2, TABLE_MOVIES_ROW_LINK3 },
					null, null, null, null, null
			);*/
 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 			
					dataList.add(cursor.getLong(0));
					dataList.add(cursor.getString(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getFloat(3));
					dataList.add(cursor.getString(4));
					dataList.add(cursor.getString(5));
					dataList.add(cursor.getString(6));

					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}

	
	
	public ArrayList<ArrayList<Object>> getAllRowsAsArrays_Quote()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.query(
					TABLE_QUOTES,
					new String[] { TABLE_QUOTES_ROW_ID, TABLE_QUOTES_ROW_MOVIE_ID, TABLE_QUOTES_ROW_TEXT, TABLE_QUOTES_ROW_READ, TABLE_QUOTES_ROW_FAVOURITE },
					null, null, null, null, null
			);
 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 			
					dataList.add(cursor.getLong(0));
					dataList.add(cursor.getLong(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getString(3));
					dataList.add(cursor.getString(4));
                   
					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}

	
	public ArrayList<ArrayList<Object>> getAllRowsAsArray_QuoteRandom()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.rawQuery("SELECT * FROM quotes where read=0 ORDER BY RANDOM() LIMIT 1",null);			/*= db.query(
					TABLE_QUOTES,
					new String[] { TABLE_QUOTES_ROW_ID, TABLE_QUOTES_ROW_MOVIE_ID, TABLE_QUOTES_ROW_TEXT, TABLE_QUOTES_ROW_READ, TABLE_QUOTES_ROW_FAVOURITE },
					null, null, null, null, null
			);*/
 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 			

					
					dataList.add(cursor.getInt(0));
					dataList.add(cursor.getInt(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getInt(3));
					dataList.add(cursor.getInt(4));
                   
					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}
	public ArrayList<ArrayList<Object>> getAllRowsAsArray_QuoteByID(Integer quote_id)
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
			cursor = db.rawQuery("SELECT * FROM quotes where id_quote="+quote_id,null);			/*= db.query(
					TABLE_QUOTES,
					new String[] { TABLE_QUOTES_ROW_ID, TABLE_QUOTES_ROW_MOVIE_ID, TABLE_QUOTES_ROW_TEXT, TABLE_QUOTES_ROW_READ, TABLE_QUOTES_ROW_FAVOURITE },
					null, null, null, null, null
			);*/
 
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 			

					
					dataList.add(cursor.getInt(0));
					dataList.add(cursor.getInt(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getInt(3));
					dataList.add(cursor.getInt(4));
                   
					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}

	
	
	public ArrayList<ArrayList<Object>> getAllRowsAsArrays_QuoteFavourite()
	{
		// create an ArrayList that will hold all of the data collected from
		// the database.
		ArrayList<ArrayList<Object>> dataArrays = new ArrayList<ArrayList<Object>>();
 
		// this is a database call that creates a "cursor" object.
		// the cursor object store the information collected from the
		// database and is used to iterate through the data.
		Cursor cursor;
 
		try
		{
			// ask the database object to create the cursor.
		/*	cursor = db.query(
					TABLE_QUOTES,
					new String[] { TABLE_QUOTES_ROW_ID, TABLE_QUOTES_ROW_MOVIE_ID, TABLE_QUOTES_ROW_TEXT, TABLE_QUOTES_ROW_READ, TABLE_QUOTES_ROW_FAVOURITE },
					null, null, null, null, null
			);*/
			cursor = db.rawQuery("SELECT * FROM quotes where favorite=1;",null);			
			
			// move the cursor's pointer to position zero.
			cursor.moveToFirst();
 
			// if there is data after the current cursor position, add it
			// to the ArrayList.
			if (!cursor.isAfterLast())
			{
				do
				{
					ArrayList<Object> dataList = new ArrayList<Object>();
 			
					dataList.add(cursor.getLong(0));
					dataList.add(cursor.getLong(1));
					dataList.add(cursor.getString(2));
					dataList.add(cursor.getString(3));
					dataList.add(cursor.getString(4));
                   
					dataArrays.add(dataList);
				}
				// move the cursor's pointer up one position.
				while (cursor.moveToNext());
			}
		}
		catch (SQLException e)
		{
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
 
		// return the ArrayList that holds the data collected from
		// the database.
		return dataArrays;
	}

	
 
 
	/**********************************************************************
	 * THIS IS THE BEGINNING OF THE INTERNAL SQLiteOpenHelper SUBCLASS.
	 * 
	 * I MADE THIS CLASS INTERNAL SO I CAN COPY A SINGLE FILE TO NEW APPS 
	 * AND MODIFYING IT - ACHIEVING DATABASE FUNCTIONALITY.  ALSO, THIS WAY 
	 * I DO NOT HAVE TO SHARE CONSTANTS BETWEEN TWO FILES AND CAN
	 * INSTEAD MAKE THEM PRIVATE AND/OR NON-STATIC.  HOWEVER, I THINK THE
	 * INDUSTRY STANDARD IS TO KEEP THIS CLASS IN A SEPARATE FILE.
	 *********************************************************************/
 
	/**
	 * This class is designed to check if there is a database that currently
	 * exists for the given program.  If the database does not exist, it creates
	 * one.  After the class ensures that the database exists, this class
	 * will open the database for use.  Most of this functionality will be
	 * handled by the SQLiteOpenHelper parent class.  The purpose of extending
	 * this class is to tell the class how to create (or update) the database.
	 * 
	 * @author Randall Mitchell
	 *
	 */
	private class CustomSQLiteOpenHelper extends SQLiteOpenHelper
	{
		public CustomSQLiteOpenHelper(Context context)
		{
			super(context, DB_NAME, null, DB_VERSION);
		}
 
		@Override
		public void onCreate(SQLiteDatabase db)
		{
			
			// This string is used to create the database.  It should
			// be changed to suit your needs.

			
			//String newTableMovieQueryString = "CREATE  TABLE \"movies\" (\"id_movie\" INTEGER PRIMARY KEY autoincrement NOT NULL  UNIQUE , \"title\" TEXT NOT NULL  check(typeof(\"title\") = 'text') , \"review\" TEXT check(typeof(\"review\") = 'text') , \"score\" FLOAT DEFAULT 0.0, \"link1\" TEXT check(typeof(\"link1\") = 'text') , \"link2\" TEXT   check(typeof(\"link2\") = 'text') , \"link3\" TEXT  check(typeof(\"link3\") = 'text') );";
			String newTableMovieQueryString = "CREATE TABLE "+ TABLE_MOVIES +" ("+ TABLE_MOVIES_ROW_ID +" INTEGER PRIMARY KEY  NOT NULL , "+ TABLE_MOVIES_ROW_TITLE +" TEXT, "+ TABLE_MOVIES_ROW_REVIEW + " TEXT, "+ TABLE_MOVIES_ROW_SCORE +" FLOAT, "+ TABLE_MOVIES_ROW_LINK1 +" TEXT, "+ TABLE_MOVIES_ROW_LINK2 +" TEXT, "+ TABLE_MOVIES_ROW_LINK3 +" TEXT);";
			String newTableQuotesQueryString = "CREATE TABLE "+TABLE_QUOTES+" ("+TABLE_QUOTES_ROW_ID+" INTEGER PRIMARY KEY  NOT NULL  UNIQUE , "+TABLE_QUOTES_ROW_MOVIE_ID+" INTEGER NOT NULL , "+TABLE_QUOTES_ROW_TEXT+" TEXT NOT NULL  check(typeof("+TABLE_QUOTES_ROW_TEXT+") = 'text') , "+TABLE_QUOTES_ROW_READ+" INTEGER NOT NULL  DEFAULT 0, "+TABLE_QUOTES_ROW_FAVOURITE+" INTEGER NOT NULL  DEFAULT 0);";

			//			String newTableQuotesQueryString = "CREATE  TABLE "+TABLE_QUOTES+" ("+ TABLE_QUOTES_ROW_ID+" INTEGER PRIMARY KEY autoincrement NOT NULL  UNIQUE , "+TABLE_QUOTES_ROW_MOVIE_ID+" INTEGER NOT NULL DEFAULT 0 , "+TABLE_QUOTES_ROW_TEXT+" TEXT NOT NULL  check(typeof("+TABLE_QUOTES_ROW_TEXT+") = 'text') , "+TABLE_QUOTES_ROW_READ+" TEXT NOT NULL  check(typeof("+TABLE_QUOTES_ROW_READ+") = 'text'),"+TABLE_QUOTES_ROW_FAVOURITE+" TEXT NOT NULL  check(typeof("+TABLE_QUOTES_ROW_FAVOURITE+") = 'text'));";
			System.out.println(newTableQuotesQueryString);
			String newTableQueryString = "create table " +
										TABLE_NAME +
										" (" +
										TABLE_ROW_ID + " integer primary key autoincrement not null," +
										TABLE_ROW_ONE + " text," +
										TABLE_ROW_TWO + " text" +
										");";
			// execute the query string to the database.
			db.execSQL(newTableMovieQueryString);
			db.execSQL(newTableQuotesQueryString);
		
			db.execSQL(newTableQueryString);
		}
 
 
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			// NOTHING TO DO HERE. THIS IS THE ORIGINAL DATABASE VERSION.
			// OTHERWISE, YOU WOULD SPECIFIY HOW TO UPGRADE THE DATABASE.
		}
	}
}
