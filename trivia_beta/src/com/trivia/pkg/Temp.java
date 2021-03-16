package com.trivia.pkg;

import com.trivia.pkg.db.DatabaseManager;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Temp extends Activity {
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);

        
    }


}
