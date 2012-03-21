package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;

public class AppInfo extends Activity {
	private static final String TAG = "LeagueLore";

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");

		setContentView(R.layout.information);


	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}
}