package com.trivia.pkg;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;
import com.trivia.pkg.db.DatabaseManager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MasterScreen extends Activity {
	
	Integer TotalCount = 100;
	String MOVIE_ID_CORRECT = null;
	String QUOTE_ID_QUESTION = null;
	String QUOTE_TEXT = null;
	String QUOTE_FAV = null;
	public static TreeSet<String> ts;

	// the table that displays the data
	TableLayout dataTable;
	// corrent answoer ( score) is consider as correct one choice in db it is float
	String correctAnswer ;
	
	// Text View for question
	TextView question;
	
	// Multiple choice Radio Buttons
	RadioGroup choicegroup;
	RadioButton rchoice1,rchoice2,rchoice3,rchoice4;
	public static final String PREFS_NAME = "trivia_profile";

	OnClickListener radioclickListner;
	
	// the class that opens or creates the database and makes sql calls to it
	DatabaseManager db;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// this try catch block returns better error reporting to the log
    	try
    	{
	        // Android specific calls
    		super.onCreate(savedInstanceState);
	        setContentView(R.layout.master_screen);
 //
	        Resources res = getResources();
	        Configuration cfg = res.getConfiguration();
	        boolean hor = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE;

	       String uid = Settings.System.getString(getContentResolver(),
	                Settings.System.ANDROID_ID);

	        AdManager.setTestDevices( new String[] {
	        		AdManager.TEST_EMULATOR, // Android emulator  TEST_EMULATOR
	        		uid, // My T-Mobile G1 Test Phone
	        		} );
	        AdView adv =  (AdView)findViewById(R.id.ad);
	        adv.requestFreshAd();
	       //
	        // make the radio buttons clicks perform actions
	        //addButtonListeners();
	        
	        // create the database manager object
	        db = new DatabaseManager(this);
 	        
	        // create references and listeners for the GUI interface
	        setupViews();
	        
	        
	        Intent nt = getIntent();
	        Integer quote_id = nt.getIntExtra("fav_q_id", -1);
	        if (retrieveRow(quote_id))
	        {
	        }
	        CheckStackScreen();
//	        
	        // load the data table
	    	//updateTable();
    	}
    	catch (Exception e)
    	{
    		Log.e("ERROR", e.toString());
    		e.printStackTrace();
    	}

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    private int CheckDecrementStackScreen()
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

    private void CheckStackScreen()
    {
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		int count = settings.getInt("screen_open", 0);
		count++;
		//Toast.makeText(getApplicationContext(), String.valueOf(count),1).show();
 		// for writing the value
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("screen_open", count);
		// Commit the edits!
	    editor.commit();
	    //Toast.makeText(getApplicationContext(), String.valueOf(count), 1).show();

    }
    public void choiceClickHandler(View v)
    {
		RadioButton rb = (RadioButton) v;
		RadioButton rb1 = (RadioButton) findViewById(R.id.choice1);
		RadioButton rb2 = (RadioButton) findViewById(R.id.choice2);
		RadioButton rb3 = (RadioButton) findViewById(R.id.choice3);
		RadioButton rb4 = (RadioButton) findViewById(R.id.choice4);
		TextView exp = (TextView)findViewById(R.id.exception_text);

    	Drawable right_icon = getResources().getDrawable(R.drawable.iconright);
    	Drawable wrong_icon = getResources().getDrawable(R.drawable.iconwrong);
		
		switch (rb.getId())
		{
    		case R.id.choice1 : {if (correctAnswer.equals(rb1.getText())) {callNextActivity(MOVIE_ID_CORRECT,QUOTE_ID_QUESTION);exp.setCompoundDrawablesWithIntrinsicBounds(right_icon, null, null, null); } else {  v.setBackgroundColor(Color.parseColor("#FF0000")); rb2.setBackgroundColor(Color.TRANSPARENT); rb3.setBackgroundColor(Color.TRANSPARENT); rb4.setBackgroundColor(Color.TRANSPARENT); exp.setText("Wrong Choice Selected"); exp.setVisibility(View.VISIBLE); exp.setCompoundDrawablesWithIntrinsicBounds(wrong_icon, null, null, null); }    }; break;
			case R.id.choice2 : {if (correctAnswer.equals(rb2.getText())) {callNextActivity(MOVIE_ID_CORRECT,QUOTE_ID_QUESTION);exp.setCompoundDrawablesWithIntrinsicBounds(right_icon, null, null, null); } else { v.setBackgroundColor(Color.parseColor("#FF0000")); rb1.setBackgroundColor(Color.TRANSPARENT); rb3.setBackgroundColor(Color.TRANSPARENT); rb4.setBackgroundColor(Color.TRANSPARENT); exp.setText("Wrong Choice Selected"); exp.setVisibility(View.VISIBLE);exp.setCompoundDrawablesWithIntrinsicBounds(wrong_icon, null, null, null);  }    }; break;
			case R.id.choice3 : {if (correctAnswer.equals(rb3.getText())) {callNextActivity(MOVIE_ID_CORRECT,QUOTE_ID_QUESTION);exp.setCompoundDrawablesWithIntrinsicBounds(right_icon, null, null, null); } else {  v.setBackgroundColor(Color.parseColor("#FF0000")); rb1.setBackgroundColor(Color.TRANSPARENT); rb2.setBackgroundColor(Color.TRANSPARENT); rb4.setBackgroundColor(Color.TRANSPARENT); exp.setText("Wrong Choice Selected"); exp.setVisibility(View.VISIBLE);exp.setCompoundDrawablesWithIntrinsicBounds(wrong_icon, null, null, null); }    }; break;
			case R.id.choice4 : {if (correctAnswer.equals(rb4.getText())) {callNextActivity(MOVIE_ID_CORRECT,QUOTE_ID_QUESTION);exp.setCompoundDrawablesWithIntrinsicBounds(right_icon, null, null, null); } else {  v.setBackgroundColor(Color.parseColor("#FF0000")); rb1.setBackgroundColor(Color.TRANSPARENT); rb2.setBackgroundColor(Color.TRANSPARENT); rb3.setBackgroundColor(Color.TRANSPARENT);exp.setText("Wrong Choice Selected"); exp.setVisibility(View.VISIBLE);exp.setCompoundDrawablesWithIntrinsicBounds(wrong_icon, null, null, null); }    }; break;
		}
    }
    
    
    /**
     * creates references and listeners for the GUI interface
     */
    private void setupViews()
    {
        // THE Question (TextView) FORM FIELDS
    	question	=	(TextView)findViewById(R.id.question_id);
    	
    	choicegroup = (RadioGroup)findViewById(R.id.mcq_question);
    	rchoice1 = (RadioButton)findViewById(R.id.choice1);
    	rchoice2 = (RadioButton)findViewById(R.id.choice2);
    	rchoice3 = (RadioButton)findViewById(R.id.choice3);
    	rchoice4 = (RadioButton)findViewById(R.id.choice4);
    }

    /**
     * adds listeners to each of the buttons and sets them to call relevant methods
     */
    public void callNextActivity(String choice,String QuoteID)
    {
		Intent next = new Intent(this,com.trivia.pkg.DetailScreen.class);
		next.putExtra("selected_choice", choice);
		next.putExtra("QUOTE_ID", QuoteID);
		next.putExtra("QUOTE_STRING", QUOTE_TEXT);
		//Toast.makeText(getApplicationContext(), "Sending"+ QUOTE_FAV, 1).show();
		next.putExtra("QUOTE_FAV", QUOTE_FAV);
		this.startActivity(next);
		this.finish();

    }
    /**
     * retrieves a row from the database with the id number in the corresponding
     * user entry field
     * @return 
     */
    public boolean retrieveRow(Integer quote_id)
    {
		ts =new TreeSet<String>();
    	try
    	{

    		// The ArrayList that holds the row data
    		ArrayList<ArrayList<Object>> row;
    		ArrayList<ArrayList<Object>> row1;
    		ArrayList<Object> row2;
    		// ask the database manager to retrieve the row with the given rowID
    		row = db.getAllRowsAsArrays_MovieRandom();
    		
    		if ( quote_id == -1 )
        		row1 = db.getAllRowsAsArray_QuoteRandom();
    		else 
    			row1 = db.getAllRowsAsArray_QuoteByID(quote_id);
    		//String sizes = String.valueOf(row.size());
    		
    		
//    		String sizes = String.valueOf(row1.size());
    		//Toast.makeText(getApplicationContext(),sizes , 1).show();
    		
    		
    		//Toast.makeText(getApplicationContext(), "Updated", 1).show();
    		// Set the Question from the Quotes Table
    		question.setText(row1.get(0).get(2).toString());
	        
    		row2 = db.getRowAsArray_Movie(Integer.parseInt(row1.get(0).get(1).toString()));
    		for ( int i=0; i <= 4;i++)
    		{
				ts.add(row.get(i).get(1).toString());
				
				//Toast.makeText(getApplicationContext(),row.get(i).get(1).toString(), 1).show();
    		}


    		MOVIE_ID_CORRECT = String.valueOf(row2.get(0).toString());
    		QUOTE_ID_QUESTION = row1.get(0).get(0).toString();
    		QUOTE_TEXT = row1.get(0).get(2).toString();
    		correctAnswer = row2.get(1).toString();
    		QUOTE_FAV = row1.get(0).get(3).toString();

    		Processing();
    		return true;
        }
    	catch (Exception e)
    	{
    		Log.e("Retrieve Error", e.toString());
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    private void Processing()
    {

    	Random diceRoller = new Random();
		int roll = diceRoller.nextInt(4);
		
    	java.util.Iterator<String> it = ts.iterator();
		int i = 0;
      while(it.hasNext())
      {
       String value=(String)it.next();

       if ( i == 0 )
        {
      	  if ( roll == i)
	          rchoice1.setText(correctAnswer);
            else 
            {
            	ChoiceOneShow(value);
//            	Toast.makeText(getApplicationContext(),value , 1).show();
            }
        } else
	      if ( i == 1 )
	      {
      	  if ( roll == i)
		          rchoice2.setText(correctAnswer);
	              else 
		          rchoice2.setText(value);
	      } else
	      if ( i == 2 )
	      {
      	  if ( roll == i)
		          rchoice3.setText(correctAnswer);
	              else 
		          rchoice3.setText(value);
	      } else
	      if ( i == 3 )
	      {
      	  if ( roll == i)
		          rchoice4.setText(correctAnswer);
	              else 
		          rchoice4.setText(value);
	      }

	      i++;
      }		
      	it.remove();
      	it.remove();
      	it.remove();
    	
    }
    private void ChoiceOneShow(String txt)
    {
    	rchoice1.setText(txt);
    	//Toast.makeText(getApplicationContext(), txt, 1).show();
    }
    public void onBackPressed()
	{
		int count = CheckDecrementStackScreen();
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

//		    Intent next = new Intent(this,com.trivia.pkg.MasterScreen.class);
	//    	this.startActivity(next);
	        }
		
		//this.moveTaskToBack(false);
		//Toast.makeText(getApplicationContext(), "Back Not allowed", 1).show();
	}


    private void updateRow()
    {
    	try
    	{
    		// ask the database manager to update the row based on the information
    		// found in the corresponding user entry fields
    		/*db.updateRow
    		(
    		//	Long.parseLong(updateIDField.getText().toString()),
    		//	updateTextFieldOne.getText().toString(),
    		//	updateTextFieldTwo.getText().toString()
    		);
 */
    		// request the table be updated
			updateTable();
 
			// remove all user input from the Activity
    		//emptyFormFields();
    	}
    	catch (Exception e)
    	{
    		Log.e("Update Error", e.toString());
    		e.printStackTrace();
    	}
    }


    /* Updating The Master Screen with Content Loading.		*/
    private void updateTable()
    {
    }

    private ArrayList<Integer>  GenerateRandomNumber(int rowId)
	{
    	ArrayList<Integer> ls = null;
		Random rand = new Random();

		// No. 1 Random integers
		int randnum = rand.nextInt()%TotalCount;
		
		return ls;
	}
    ////////// Menu Bar creation.
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

