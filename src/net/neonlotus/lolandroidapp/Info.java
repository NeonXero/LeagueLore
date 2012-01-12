package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 10/26/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Info extends Activity {

	private static final String TAG = "LeagueLore";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//===========================
		//==== GRID VIEW TESTING ====
		setContentView(R.layout.champ_grid);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new CustomAdapter(this));


		//bundle test stuff
		final Intent intent = new Intent(Info.this, Champion.class);
		final Bundle b = new Bundle();

		final String[] champ_list_array = getResources().getStringArray(R.array.champ_list);
		final String[] champ_lore_array = getResources().getStringArray(R.array.champ_lore);
		final String[] champ_stats_array = getResources().getStringArray(R.array.champ_stats);
		final String[] champ_tag_lines = getResources().getStringArray(R.array.champ_taglines);


		//setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, champ_list_array)); THIS

		//ListView lv = getListView(); THIS
		//lv.setTextFilterEnabled(true); THIS
		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				//Copying stuff from list adapter click thing
				ChampObj obj = new ChampObj();
				obj.setChampName(champ_list_array[position]);
				obj.setChampStory(champ_lore_array[position]);
				obj.setChampStats(champ_stats_array[position]);
				obj.setChampTags(champ_tag_lines[position]);

				obj.setIndex(position);
				Log.d(TAG, "Position=" + position);

				intent.putExtra("net.neonlotus.lolandroidapp.ChampObj", obj);
				startActivity(intent);
			}
		});

		//registerForContextMenu();

		/*AdapterView.OnItemLongClickListener listener = new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				//Log.d(TAG, "OnItemLongClickListener");
				//Toast.makeText(getApplicationContext(),"LONG",Toast.LENGTH_SHORT).show();
				//showOptionsMenu(position);
				return true;
			}
		};



		gridview.setOnItemLongClickListener(listener);*/



		/*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { THIS
			public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
				//Trying Scott parcel thing
				ChampObj obj = new ChampObj();
				//Set values etc.
				obj.setChampName(champ_list_array[position]);
				obj.setChampStory(champ_lore_array[position]);
				obj.setChampStats(champ_stats_array[position]);
				obj.setChampTags(champ_tag_lines[position]);

				//Intent stuff :D
				intent.putExtra("net.neonlotus.lolandroidapp.ChampObj", obj);
				startActivity(intent);


			} //end on click
		});*/
	}


	public class CustomAdapter extends BaseAdapter {
		private Context mContext;

		public CustomAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return mThumbIds.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		final String[] champ_list_array = getResources().getStringArray(R.array.champ_list);

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			View v;
			if (convertView == null) {  // if it's not recycled, initialize some attributes
				v = new View(getApplicationContext());
			} else {
				v = (View) convertView;
			}
			//Set content here...
			LayoutInflater li = getLayoutInflater();
			v = li.inflate(R.layout.icon, null);
			TextView tv = (TextView) v.findViewById(R.id.icon_text);
			tv.setText(champ_list_array[position]);
			ImageView iv = (ImageView) v.findViewById(R.id.icon_image);
			iv.setImageResource(mThumbIds[position]);
			iv.setPadding(5,5,5,5);
			return v;
		}

		// references to our images
		private Integer[] mThumbIds = {
				R.drawable.ahri, R.drawable.akal, R.drawable.ali, R.drawable.amumu, R.drawable.anivia,
				R.drawable.annie, R.drawable.ashe, R.drawable.blitz, R.drawable.brand, R.drawable.cait,
				R.drawable.cassi,
				R.drawable.cho, R.drawable.cork, R.drawable.drmu, R.drawable.evel, R.drawable.ezr, R.drawable.fiddle,
				R.drawable.fizz, R.drawable.galio, R.drawable.gang, R.drawable.garen, R.drawable.gragas,
				R.drawable.graves,
				R.drawable.heim, R.drawable.irel, R.drawable.janna, R.drawable.jarv, R.drawable.jax, R.drawable.karma,
				R.drawable.karth, R.drawable.kass, R.drawable.kata, R.drawable.kayle, R.drawable.kennen,
				R.drawable.kog,
				R.drawable.leblanc, R.drawable.leesin, R.drawable.leona, R.drawable.lux, R.drawable.malph,
				R.drawable.malz,
				R.drawable.mao, R.drawable.master, R.drawable.missfort, R.drawable.mord, R.drawable.morg,
				R.drawable.nasus,
				R.drawable.nidalee, R.drawable.noct, R.drawable.nunu, R.drawable.olaf, R.drawable.orian,
				R.drawable.panth,
				R.drawable.poppy, R.drawable.rammus, R.drawable.rene, R.drawable.riven, R.drawable.rumb,
				R.drawable.ryze,
				R.drawable.shaco, R.drawable.shen, R.drawable.shyv, R.drawable.singed, R.drawable.sion,
				R.drawable.sivir,
				R.drawable.skarn, R.drawable.sona, R.drawable.soraka, R.drawable.swain, R.drawable.talon,
				R.drawable.taric,
				R.drawable.teemo, R.drawable.trist, R.drawable.trundle, R.drawable.trynd, R.drawable.twifa,
				R.drawable.twitch,
				R.drawable.udyr, R.drawable.urgot, R.drawable.vayne, R.drawable.veig, R.drawable.viktor,
				R.drawable.vlad,
				R.drawable.volibear, R.drawable.warw, R.drawable.wukong, R.drawable.xera, R.drawable.xinz,
				R.drawable.yorik, R.drawable.zil
		};
	}
}