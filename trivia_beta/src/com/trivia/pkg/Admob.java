package com.trivia.pkg;

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;

public class Admob extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        setContentView(R.layout.admob);

    String uid = Settings.System.getString(getContentResolver(),
            Settings.System.ANDROID_ID);

    AdManager.setTestDevices( new String[] {
    		AdManager.TEST_EMULATOR, // Android emulator  TEST_EMULATOR
    		uid, // My T-Mobile G1 Test Phone
    		} );
    AdView adv =  (AdView)findViewById(R.id.ad);
    adv.requestFreshAd();

    }
}
