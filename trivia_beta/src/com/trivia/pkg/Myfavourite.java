package com.trivia.pkg;

import java.util.ArrayList;

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;
import com.trivia.pkg.db.DatabaseManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Myfavourite extends Activity {
	DatabaseManager db;
	ArrayList<Integer> list_quotes_id;
	private ListView lv1;
	private String lv_arr[]={"Android","iPhone","BlackBerry","AndroidPeople"};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	try
    	{
	    
    	super.onCreate(savedInstanceState);
     // create the database manager object
        db = new DatabaseManager(this);
     // By using setAdpater method in listview we an add string array in list.
    
        setContentView(R.layout.myfavourite);
        
	       String uid = Settings.System.getString(getContentResolver(),
	                Settings.System.ANDROID_ID);

	        AdManager.setTestDevices( new String[] {
	        		AdManager.TEST_EMULATOR, // Android emulator  TEST_EMULATOR
	        		uid, // My T-Mobile G1 Test Phone
	        		} );
	        AdView adv =  (AdView)findViewById(R.id.ad);
	        adv.requestFreshAd();

        lv1=(ListView)findViewById(R.id.android_favourite_list);
        //lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
        
        retrieveFavouriteRow();
     
        lv1.setOnItemClickListener(new OnItemClickListener() {

        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
        	long arg3) {
        		String quotes_id = String.valueOf(list_quotes_id.get(arg2));
        		callNextMasterScreen(Integer.parseInt(quotes_id));
        		//Toast.makeText(getBaseContext(), String.valueOf(arg2), Toast.LENGTH_LONG).show();
        	}
        });   
        
    	}
    	catch (Exception e)
    	{
    		Log.e("ERROR", e.toString());
    		e.printStackTrace();
    	}
    	
    }

    private void callNextMasterScreen(Integer quotes_id)
    {
		Intent nextIntent = new Intent(this,com.trivia.pkg.MasterScreen.class);
		nextIntent.putExtra("fav_q_id", quotes_id);
		this.startActivity(nextIntent);
    	
    }
//    @SuppressWarnings("null")
	private void retrieveFavouriteRow()
    {
		
    	//getAllRowsAsArrays_QuoteFavourite
    try
	{
    		list_quotes_id = new ArrayList<Integer>();
    		// The ArrayList that holds the row data
    		ArrayList<ArrayList<Object>> row;
    		
    		// ask the database manager to retrieve the row with the given rowID
    		row = db.getAllRowsAsArrays_QuoteFavourite();
    		//Toast.makeText(getApplicationContext(), row.get(0).get(0).toString(),1).show();
        	//lv_arr[1] = row.get(0).get(0).toString();
        	ArrayList<String> str = new ArrayList<String>();
        	int sizeofrow = row.size();//sizeofrow
        	for ( int i = 0; i < sizeofrow;i++)
        	{
        		String test = row.get(i).get(2).toString();
        		String subTest = test.substring(0,25 );//test.length() - 5
        		//Toast.makeText(getApplicationContext(), subTest, 1).show();
        		str.add(subTest);
        		// adding the quotes_id to arraylist
        		list_quotes_id.add(Integer.parseInt(row.get(i).get(0).toString()));
        	}
    		lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 ,str ));
    		
     		    		
    }
	catch (Exception e)
	{
		
		Log.e("Retrieve Error", e.toString());
		e.printStackTrace();
	}

    	
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
							Intent intent = new Intent(this,com.trivia.pkg.loading.class);
							startActivity(intent);
			            	} break;
        }
        return true;
    }

}
