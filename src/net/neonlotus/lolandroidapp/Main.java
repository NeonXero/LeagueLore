package net.neonlotus.lolandroidapp;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import com.flurry.android.FlurryAgent;

public class Main extends TabActivity {

	private ChampionManager mManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");

		setContentView(R.layout.main);

		mManager = new ChampionManager(getApplicationContext());

		TabHost tabHost = getTabHost();  // The activity TabHost
		Resources res = getResources(); // Resource object to get Drawables

		// Tab for Left page, overall lore
		TabHost.TabSpec loreSpec = tabHost.newTabSpec("Lore");
		loreSpec.setIndicator("Lore", getResources().getDrawable(R.drawable.ken_tab));
		Intent loreIntent = new Intent(this, Lore.class);
		loreSpec.setContent(loreIntent);

		// Tab for mid page, champ info [this is the one to refresh]
		TabHost.TabSpec champSpec = tabHost.newTabSpec("Champions");
		champSpec.setIndicator("Champions", getResources().getDrawable(R.drawable.pop_tab));
		Intent champIntent = new Intent(this, Info.class);
		champSpec.setContent(champIntent);

		// Tab for righ tpage, more tab..
		TabHost.TabSpec moreSpec = tabHost.newTabSpec("More");
		moreSpec.setIndicator("More", getResources().getDrawable(R.drawable.teemo_tab));
		Intent moreIntent = new Intent(this, AppInfo.class);
		moreSpec.setContent(moreIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(loreSpec);
		tabHost.addTab(champSpec);
		tabHost.addTab(moreSpec);
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}
}