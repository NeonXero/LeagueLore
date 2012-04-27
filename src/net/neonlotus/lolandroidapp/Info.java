package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.flurry.android.FlurryAgent;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 10/26/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Info extends Activity {

	private static final String TAG = "LeagueLore";
	private GridAdapter MyGridAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");

		//==== GRID VIEW TESTING ====
		setContentView(R.layout.champ_grid);
		//grid = new GridAdapter(this);
		MyGridAdapter = new GridAdapter(this);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		//gridview.setAdapter(new CustomAdapter(this));
		gridview.setAdapter(MyGridAdapter);

		//bundle test stuff
		final Intent intent = new Intent(Info.this, Champion.class);
		final Bundle b = new Bundle();

		final String[] champ_list_array = getResources().getStringArray(R.array.champ_list);
		final String[] champ_list_joke = getResources().getStringArray(R.array.champ_list_egg);
		final String[] champ_lore_array = getResources().getStringArray(R.array.champ_lore);
		final String[] champ_stats_array = getResources().getStringArray(R.array.champ_stats);
		final String[] champ_tag_lines = getResources().getStringArray(R.array.champ_taglines);

		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				//Copying stuff from list adapter click thing
				ChampObj obj = new ChampObj();
				obj.setChampName(champ_list_array[position]);
				//obj.setChampName(newChamps[position]);
				obj.setChampStory(champ_lore_array[position]);
				obj.setChampStats(champ_stats_array[position]);
				obj.setChampTags(champ_tag_lines[position]);

				obj.setIndex(position);

				intent.putExtra("net.neonlotus.lolandroidapp.ChampObj", obj);
				startActivity(intent);
			}
		});
	} //here is end of oncreate

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG,"Tab resume happened");
		if(MyGridAdapter != null) {
			MyGridAdapter.notifyDataSetChanged();
		}
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
	}
}