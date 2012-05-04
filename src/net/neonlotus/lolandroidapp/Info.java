package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.flurry.android.FlurryAgent;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 10/26/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Info extends Activity implements Observer {

	private String LOG = "League/Info";
	private GridAdapter mGridAdapter;
	private ChampionManager mManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");
		setContentView(R.layout.champ_grid);

		mManager = new ChampionManager(getApplicationContext());
		mManager.addObserver(this);

		mGridAdapter = new GridAdapter(this);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(mGridAdapter);

		//bundle test stuff
		final Intent intent = new Intent(Info.this, Champion.class);

		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				//Copying stuff from list adapter click thing
				ChampObj obj = new ChampObj();
				//todo: manager.getchampobj take position in

				obj.setChampName(mManager.getChampNames()[position]);

				obj.setChampStory(mManager.getChampLore()[position]);
				//todo: mManager.getChampLore(position)
				//todo: getChampLore(int pos) { return mChampModel.getChampLore()[pos];
				//todo: wiki article 'programming delegation'

				obj.setChampStats(mManager.getChampStats()[position]);

				obj.setChampTags(mManager.getChampTags()[position]);

				obj.setIndex(position);

				intent.putExtra("net.neonlotus.lolandroidapp.ChampObj", obj);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(LOG,"Tab resume happened");
		if(mGridAdapter != null) {
			mGridAdapter.notifyDataSetChanged();
		}
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
	}

	public void update(Observable observable, Object o) {
		if(mGridAdapter != null) {
			mGridAdapter.notifyDataSetChanged();
		}
	}
}