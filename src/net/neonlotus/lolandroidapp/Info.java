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

	private static final String TAG = "LeagueLore";
	private GridAdapter mGridAdapter;
	//private ChampModel mModel;
	private ChampionManager mManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");
		setContentView(R.layout.champ_grid);

		//mModel = new ChampModel(getApplicationContext());
		//mModel.addObserver(this);
		mManager = new ChampionManager(getApplicationContext());
		mManager.addObserver(this);
		mManager = new ChampionManager(getApplicationContext());

		//mManager.setChampNames(PreferenceManager.get(getApplicationContext())); //set boolean on load?

		mGridAdapter = new GridAdapter(this);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(mGridAdapter);

		//bundle test stuff
		final Intent intent = new Intent(Info.this, Champion.class);
		//final Bundle b = new Bundle();

		//final String[] champ_list_array = getResources().getStringArray(R.array.champ_list);
		//final String[] champ_list_joke = getResources().getStringArray(R.array.champ_list_egg);
		//final String[] champ_lore_array = getResources().getStringArray(R.array.champ_lore);
		//final String[] champ_stats_array = getResources().getStringArray(R.array.champ_stats);
		//final String[] champ_tag_lines = getResources().getStringArray(R.array.champ_taglines);

		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				//Copying stuff from list adapter click thing
				ChampObj obj = new ChampObj();
				//todo: manager.getchampobj take position in

				//obj.setChampName(champ_list_array[position]);
				obj.setChampName(mManager.getChampNames()[position]);
				//obj.setChampName(mModel.getChampNames()[position]);

				//obj.setChampStory(champ_lore_array[position]);
				//obj.setChampStory(mModel.getLore()[position]);
				obj.setChampStory(mManager.getChampLore()[position]);
				//todo: mManager.getChampLore(position)
				//todo: getChampLore(int pos) { return mChampModel.getChampLore()[pos];
				//todo: wiki article 'programming delegation'

				//obj.setChampStats(champ_stats_array[position]);
				obj.setChampStats(mManager.getChampStats()[position]);

				//obj.setChampTags(champ_tag_lines[position]);
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
		Log.d(TAG,"Tab resume happened");
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