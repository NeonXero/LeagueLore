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
	private ChampionManager mManager;
	private String LOG = "League/GridAdapter";

	public GridAdapter(Context c) {
		mContext = c;
		mManager = new ChampionManager(c);
	}

	public int getCount() {
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

		//this is kind of curious.... maybe?
		if (PreferenceManager.get(mContext)) {
			//tv.setText(champ_list_joke[position]);
			tv.setText(mManager.getChampNames()[position]);
		} else {
			//tv.setText(champ_list_array[position]);
			tv.setText(mManager.getChampNames()[position]);
		}
		//tv.setText(mManager.getChampNames()[position]); //removing the if statement?

		ImageView iv = (ImageView) v.findViewById(R.id.icon_image);
		//iv.setImageResource(mThumbIds[position]);
		iv.setImageResource(mManager.getThumbIds()[position]);
		iv.setPadding(5, 5, 5, 5);
		return v;
	}
}