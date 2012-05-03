package net.neonlotus.lolandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 4/23/12
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class GridAdapter extends BaseAdapter {
	private Context mContext;
	//private String[] champ_list_array;
	//private String[] champ_list_joke;
	private ChampionManager mManager;
	private String LOG = "League/GridAdapter";

	public GridAdapter(Context c) {
		mContext = c;
		//champ_list_array = mContext.getResources().getStringArray(R.array.champ_list);
		//champ_list_joke = mContext.getResources().getStringArray(R.array.champ_list_egg);
		mManager = new ChampionManager(c);
	}

	public int getCount() {
		//return mThumbIds.length;
		return mManager.getThumbIds().length;
	}

	public Object getItem(int i) {
		return i;
	}

	public long getItemId(int i) {
		return i;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;

		if (convertView == null) { // if it's not recycled, initialize some attributes
			v = new View(mContext);
		} else {
			v = (View) convertView;
		}
		//Set content here...
		LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = li.inflate(R.layout.icon, null);
		TextView tv = (TextView) v.findViewById(R.id.icon_text);

		if (PreferenceManager.get(mContext)) {
			//tv.setText(champ_list_joke[position]);
			tv.setText(mManager.getChampNames()[position]);
		} else {
			//tv.setText(champ_list_array[position]);
			tv.setText(mManager.getChampNames()[position]);
		}

		ImageView iv = (ImageView) v.findViewById(R.id.icon_image);
		//iv.setImageResource(mThumbIds[position]);
		iv.setImageResource(mManager.getThumbIds()[position]);
		iv.setPadding(5, 5, 5, 5);
		return v;
	}

	// references to our images
	//todo: put these in model, then delegate to the manager
	/*private Integer[] mThumbIds = {
			R.drawable.ahri, R.drawable.akal, R.drawable.ali, R.drawable.amumu, R.drawable.anivia,
			R.drawable.annie, R.drawable.ashe, R.drawable.blitz, R.drawable.brand, R.drawable.cait,
			R.drawable.cassi,R.drawable.cho, R.drawable.cork, R.drawable.drmu, R.drawable.evel, R.drawable.ezr,
			R.drawable.fiddle,R.drawable.fiora,R.drawable.fizz, R.drawable.galio, R.drawable.gang,
			R.drawable.garen, R.drawable.gragas,R.drawable.graves, R.drawable.hecarim,R.drawable.heim,
			R.drawable.irel, R.drawable.janna, R.drawable.jarv, R.drawable.jax, R.drawable.karma,
			R.drawable.karth, R.drawable.kass, R.drawable.kata, R.drawable.kayle, R.drawable.kennen,
			R.drawable.kog,R.drawable.leblanc, R.drawable.leesin, R.drawable.leona,R.drawable.lulu,
			R.drawable.lux, R.drawable.malph,R.drawable.malz,R.drawable.mao, R.drawable.master,
			R.drawable.missfort, R.drawable.mord, R.drawable.morg,R.drawable.nasus, R.drawable.naut,
			R.drawable.nidalee, R.drawable.noct, R.drawable.nunu, R.drawable.olaf, R.drawable.orian,
			R.drawable.panth,R.drawable.poppy, R.drawable.rammus, R.drawable.rene, R.drawable.riven,
			R.drawable.rumb,R.drawable.ryze,R.drawable.sej,R.drawable.shaco, R.drawable.shen, R.drawable.shyv,
			R.drawable.singed, R.drawable.sion,R.drawable.sivir,R.drawable.skarn, R.drawable.sona,
			R.drawable.soraka, R.drawable.swain, R.drawable.talon,R.drawable.taric,R.drawable.teemo,
			R.drawable.trist, R.drawable.trundle, R.drawable.trynd, R.drawable.twifa,R.drawable.twitch,
			R.drawable.udyr, R.drawable.urgot, R.drawable.vayne, R.drawable.veig, R.drawable.viktor,
			R.drawable.vlad,R.drawable.volibear, R.drawable.warw, R.drawable.wukong, R.drawable.xera,
			R.drawable.xinz,R.drawable.yorik, R.drawable.ziggs,R.drawable.zil
	};*/
}