package net.neonlotus.lolandroidapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 10/26/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lore extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, LoreList));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				AlertDialog.Builder builder = new AlertDialog.Builder(Lore.this);

				builder.setTitle(((TextView) view).getText());
				if (((TextView) view).getText().equals("Demacia")) {
					builder.setMessage(R.string.dem_story);
				} else if (((TextView) view).getText().equals("Noxus")) {
					builder.setMessage(R.string.noxus_story);
				} else if (((TextView) view).getText().equals("The League of Legends")) {
					builder.setMessage(R.string.league_story);
				}

				final AlertDialog alert = builder.create();
				alert.show();
			}
		});
	}

	static final String[] LoreList = new String[]{
			"Demacia", "Noxus", "The League of Legends"
	};
}