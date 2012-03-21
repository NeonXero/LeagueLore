package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.flurry.android.FlurryAgent;

public class AppInfo extends PreferenceActivity {
	private static final String TAG = "LeagueLore";

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);

		//Flurry
		FlurryAgent.onStartSession(this, " ");



	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}
}