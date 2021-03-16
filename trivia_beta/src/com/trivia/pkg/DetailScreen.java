package com.trivia.pkg;

import java.util.ArrayList;

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;
import com.trivia.pkg.db.DatabaseManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailScreen extends Activity {
	DatabaseManager db;
	String CurrentMovieID = null;
	String QUOTE_ID	= null;
	String QUOTE_TEXT = null;
	String QUOTE_FAV = null;
	public static final String PREFS_NAME = "trivia_profile";

	public void onBackPressed()
	{
		int count = CheckStackScreen();
		if ( count < 6)
    	{
			this.finishFromChild(getParent());
		}
		else 
			{
			this.finish();
//			this.moveTaskToBack(true);
			// Reset the Counter value to 0
			/*SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			int counts = 0;
	 		// for writing the value
			SharedPreferences.Editor editor = settings.edit();
		    editor.putInt("screen_open", counts);
			// Commit the edits!
		    editor.commit();
		    */////////////////////////////////////////////////////////////////////////////

		//    Intent next = new Intent(this,com.trivia.pkg.MasterScreen.class);
	    //	this.startActivity(next);
	        }
		
		//this.moveTaskToBack(false);
		//Toast.makeText(getApplicationContext(), "Back Not allowed", 1).show();
	}

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	try
    	{
    	super.onCreate(savedInstanceState);
		
    	
     // create the database manager object
        db = new DatabaseManager(this);

        
        setContentView(R.layout.detail_screen);
	       String uid = Settings.System.getString(getContentResolver(),
	                Settings.System.ANDROID_ID);

	        AdManager.setTestDevices( new String[] {
	        		AdManager.TEST_EMULATOR, // Android emulator  TEST_EMULATOR
	        		uid, // My T-Mobile G1 Test Phone
	        		} );
	        AdView adv =  (AdView)findViewById(R.id.ad);
	        adv.requestFreshAd();

        
      /* final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        finish();
                   }
               })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();
        alert.show();
        
        */
        Intent nt = getIntent();
        CurrentMovieID = nt.getCharSequenceExtra("selected_choice").toString();
    
        QUOTE_ID = nt.getCharSequenceExtra("QUOTE_ID").toString();
        QUOTE_TEXT = nt.getCharSequenceExtra("QUOTE_STRING").toString();
        QUOTE_FAV = nt.getCharSequenceExtra("QUOTE_FAV").toString();
       // Toast.makeText(getApplicationContext(), nt.getCharSequenceExtra("QUOTE_FAV").toString(),1).show();
        //Toast.makeText(getApplicationContext(),CurrentMovieID ,1).show();
        retrieveRowMovie(CurrentMovieID);
        update_Readbool();
    	}
    	catch (Exception e)
    	{
    		Log.e("ERROR", e.toString());
    		e.printStackTrace();
    	}

    }
    private void update_Readbool()
    {
    	try
    	{
    		// ask the database manager to update the row based on the information
    		// found in the corresponding user entry fields
    		//Toast.makeText(getApplicationContext(), QUOTE_ID, 1).show();
    		//db.updateRow_Fvaourite_Quote(Long.parseLong(QUOTE_ID),true);
    		db.updateRow_Quote(Long.parseLong(QUOTE_ID), Long.parseLong(CurrentMovieID), QUOTE_TEXT, 1,Integer.parseInt(QUOTE_FAV));
    	}
    	catch (Exception e)
    	{
    		//Toast.makeText(getBaseContext(), e.toString(), 1).show();
    		Log.e("Update Error", e.toString());
    		e.printStackTrace();
    	}

    }
    
    private int CheckStackScreen()
    {
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		int count = settings.getInt("screen_open", 0);
		count--;
		//Toast.makeText(getApplicationContext(), String.valueOf(count),1).show();
 		// for writing the value
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("screen_open", count);
		// Commit the edits!
	    editor.commit();
	    return count;
    }

    public void favouriteHanlder(View v)
    {
    	int fav_bool = Integer.parseInt(QUOTE_FAV);
		if ( fav_bool == 1)
		{	
	    	update_Favourite_Quote(0);
	    	QUOTE_FAV = "0";
		} else 
		{
    	update_Favourite_Quote(1);
    	QUOTE_FAV = "1";
		}
    }
    
    private void update_Favourite_Quote(int fav_bol)
    {
		Button fav = (Button)findViewById(R.id.favourite_img);
		Drawable test = getResources().getDrawable(android.R.drawable.btn_star_big_on);
		Drawable test1 = getResources().getDrawable(android.R.drawable.btn_star_big_off);
		
    	Drawable drawable_on = getResources().getDrawable(R.drawable.addtofavicon);
    	Drawable drawable_off = getResources().getDrawable(R.drawable.addtofaviconoff);

		if ( fav_bol == 1)
		{	
		//	Toast.makeText(getApplicationContext(), "Favourite Set",1).show();
			fav.setBackgroundDrawable(drawable_off);
		} else 
		{
			fav.setBackgroundDrawable(drawable_on);
		}
    	//Toast.makeText(getApplicationContext(), "QID="+QUOTE_ID, 1).show();
    	try
    	{
    		// ask the database manager to update the row based on the information
    		// found in the corresponding user entry fields
    		//Toast.makeText(getApplicationContext(), QUOTE_ID, 1).show();
    		//db.updateRow_Fvaourite_Quote(Long.parseLong(QUOTE_ID),true);
    		db.updateRow_Quote(Long.parseLong(QUOTE_ID), Long.parseLong(CurrentMovieID), QUOTE_TEXT, 1, fav_bol );
    	}
    	catch (Exception e)
    	{
    		//Toast.makeText(getBaseContext(), e.toString(), 1).show();
    		Log.e("Update Error", e.toString());
    		e.printStackTrace();
    	}
    }

    
    /**
     * retrieves a row from the database with the id number in the corresponding
     * user entry field
     */
    public void retrieveRowMovie(String id_movie)
    {
    	try
    	{
    		Button fav = (Button)findViewById(R.id.favourite_img);
        	Drawable drawable_on = getResources().getDrawable(R.drawable.addtofavicon);
        	Drawable drawable_off = getResources().getDrawable(R.drawable.addtofaviconoff);
    		int fav_bool = Integer.parseInt(QUOTE_FAV);
    		if ( fav_bool == 1)
    		{	
    			fav.setBackgroundDrawable(drawable_off);
    		} else 
    		{
    			fav.setBackgroundDrawable(drawable_on);
    		}
    			

    		TextView title = (TextView)findViewById(R.id.detail_title);
    		TextView description = (TextView)findViewById(R.id.detail_description);
        	TextView score = (TextView)findViewById(R.id.score_line);
    		Button link1 = (Button)findViewById(R.id.link1);
    		Button link2 = (Button)findViewById(R.id.link2);
    		
    		ArrayList<Object> row2;
    		// ask the database manager to retrieve the row with the given rowID
     		
    		row2 = db.getRowAsArray_Movie(Long.parseLong(id_movie));
    		title.setText(row2.get(1).toString());
    		description.setText(row2.get(2).toString());
    		score.setText(row2.get(3).toString() + "/10");
    		link1.setText(row2.get(4).toString());
    		link2.setText(row2.get(5).toString());
    		//link3.setText(row2.get(6).toString());
    		//link1.setTag(1, "test");
    		
    		//choice3.setText(row2.get(1).toString());
    		
        }
    	catch (Exception e)
    	{
    		Log.e("Retrieve Error", e.toString());
    		e.printStackTrace();
    	}
    	
    }

    
    public void linkHandler(View target)
    {
    	Button bt = (Button)target;
    	switch ( bt.getId())
    	{
	    	case R.id.link1 : 
	    	{
	    		Toast.makeText(getApplicationContext(), bt.getTag(1).toString(),1).show();

	    		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.pk"));
		        startActivity(i);    	
	    	}; break;
	    	case R.id.link2 : 
	    	{
		    	Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
		        startActivity(i);    	
	    	}; break;
    	}
    }
    
    public void nextQuestionHandler(View target)
    {
    	Intent next = new Intent(this,com.trivia.pkg.MasterScreen.class);
    	this.startActivity(next);
    	this.finish();
    }
    //////// Menu Creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:             
            				{
            					Intent intent = new Intent(this,com.trivia.pkg.Myfavourite.class);
            					startActivity(intent);
            				}	break;
            case R.id.logout: {
				this.moveTaskToBack(true);
			            	} break;
        }
        return true;
    }

}
