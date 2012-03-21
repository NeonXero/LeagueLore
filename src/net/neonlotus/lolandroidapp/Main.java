package net.neonlotus.lolandroidapp;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import com.flurry.android.FlurryAgent;

public class Main extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");

		setContentView(R.layout.main);

		TabHost tabHost = getTabHost();  // The activity TabHost
		Resources res = getResources(); // Resource object to get Drawables

		// Tab for Photos
		TabHost.TabSpec loreSpec = tabHost.newTabSpec("Lore");
		// setting Title and Icon for the Tab
		loreSpec.setIndicator("Lore", getResources().getDrawable(R.drawable.ken_tab));
		Intent loreIntent = new Intent(this, Lore.class);
		loreSpec.setContent(loreIntent);

		// Tab for Songs
		TabHost.TabSpec champSpec = tabHost.newTabSpec("Champions");
		champSpec.setIndicator("Champions", getResources().getDrawable(R.drawable.pop_tab));
		Intent champIntent = new Intent(this, Info.class);
		champSpec.setContent(champIntent);

		// Tab for Videos
		TabHost.TabSpec moreSpec = tabHost.newTabSpec("More");
		moreSpec.setIndicator("More", getResources().getDrawable(R.drawable.teemo_tab));
		Intent moreIntent = new Intent(this, AppInfo.class);
		moreSpec.setContent(moreIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(loreSpec); // Adding photos tab
		tabHost.addTab(champSpec); // Adding songs tab
		tabHost.addTab(moreSpec); // Adding videos tab
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}
}