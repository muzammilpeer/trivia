package com.trivia.pkg;


import com.trivia.pkg.db.DatabaseManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class loading extends Activity {

	public static final String PREFS_NAME = "trivia_profile";
	private static final String NULL = null;
	DatabaseManager db;

	/** Called when the activity is first created. */
    @SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	try
    	{
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        db = new DatabaseManager(this);

/*	        String uid = Settings.System.getString(getContentResolver(),
	                Settings.System.ANDROID_ID);
	*/        
	        CheckAppsOpenTimes();

		    }    
			catch (Exception e)
			{
				Log.e("ERROR", e.toString());
				e.printStackTrace();
			}

    }
    @Override
    public void onBackPressed()
	{
		this.finish();
    	this.moveTaskToBack(true);
	}
    public void aboutmeHandler(View target)
    {
    	//Intent ns = new Intent(this,com.trivia.pkg.Aboutme.class);
    	//this.startActivity(ns);
    	
		/** Display Custom Dialog */
		CustomizeDialog customizeDialog = new CustomizeDialog(this);
		customizeDialog.show();

    	
    /*	final CharSequence[] items = {"This application Trivia Question \n base app. Play with it and enjoy. Have Fun!","Designed by, Peer"};

    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("About Me");
    	builder.setItems(items, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	        // Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
    	    }
    	});
    	AlertDialog alert = builder.create();
    	alert.show();
    	*/
/*        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This application Trivia Question base app. Play with it and enjoy. Have Fun!")
               .setCancelable(false)
              
               /*
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        finish();
                   }
               }*/
              /* )
           setNeutralButton    */
    	
/*    	.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();
        alert.show();*/
    }
    public void favouriteClickHandler(View target)
    {
       // Intent ns = new Intent(this,com.trivia.pkg.ChangePassword.class);
        //this.startActivity(ns);

    	
		// Create new intent object and tell it to call the ColorPicker class
		Intent question = new Intent(this, com.trivia.pkg.Myfavourite.class);
		// Start ColorPicker as a new activity and wait for the result 
		this.startActivity(question);
    	    	
    }
    public void startClickHandler(View target)
    {
		// Create new intent object and tell it to call the ColorPicker class
		Intent question = new Intent(this, com.trivia.pkg.MasterScreen.class);
		// Start ColorPicker as a new activity and wait for the result 
		this.startActivity(question);
    	
    }
    public void initdbHandler(View target)
    {
		// Create new intent object and tell it to call the ColorPicker class
		Intent question = new Intent(this, com.trivia.pkg.SetupDatabase.class);
		// Start ColorPicker as a new activity and wait for the result 
		this.startActivity(question);
    	
    }
    
    private void CheckAppsOpenTimes()
    {
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		int count = settings.getInt("app_open", 0);
		count++;
		//Toast.makeText(getApplicationContext(), String.valueOf(count),1).show();
		if (count == 4)
	    {
	    	ShowLikeBox();
	    }
 		// for writing the value
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("app_open", count);
		// Commit the edits!
	    editor.commit();
	 }
 
    private void ShowLikeBox()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you like this app?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   ShowRateBox(); 
                   }
               }
               )
    	.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();
        alert.show();
  
    }
    
    private void ShowRateBox()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to rate this app? ")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   // Go to Android Market for app like.
                	   Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.pk"));
                	    startActivity(i);    	
                   }
               }
               )
    	.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                   }
               });
        AlertDialog alert = builder.create();
        alert.show();
    }

}