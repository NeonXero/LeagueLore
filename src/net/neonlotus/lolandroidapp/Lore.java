package net.neonlotus.lolandroidapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.commonsware.cwac.merge.MergeAdapter;
import com.flurry.android.FlurryAgent;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 10/26/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lore extends ListActivity {

	private static final String[] LoreList = new String[]{
			"Demacia", "Noxus", "The League of Legends"
	};
	private static final String[] JOJList = new String[]{
			"Issue 01", "Issue 02","Issue 03","Issue 04","Issue 05","Issue 06","Issue 07","Issue 08","Issue 09",
			"Issue 10","Issue 11","Issue 12","Issue 13","Issue 14","Issue 15","Issue 16","Issue 17","Issue 18",
			"Issue 19","Issue 20","Issue 21","Issue 22","Issue 23","Issue 24","Issue 25","BREAKING NEWS!",
			"Issue 26","Issue 27","Issue 28","Issue 29"
	};

	private MergeAdapter adapter=null;
	private ArrayAdapter<String> arrayAdapter=null;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");

		//Merge Adapter thing...
		adapter=new MergeAdapter();
		adapter.addView(buildTop());
		arrayAdapter=buildFirstList();
		adapter.addAdapter(arrayAdapter);
		adapter.addView(buildLabel());
		adapter.addAdapter(buildSecondList());

		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView parent, View v, int position,long id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(Lore.this);
		String urlPartOne="http://leagueoflegends.wikia.com/wiki/The_Journal_of_Justice:_Volume_1,_Issue_";
		Intent intent = new Intent();
		final AlertDialog alert;
		
		switch (position) {
			case 1:
				builder.setTitle("Demacia");
				builder.setMessage(R.string.dem_story);
				alert=builder.create();
				alert.show();
				break;
			case 2:
				builder.setTitle("Noxus");
				builder.setMessage(R.string.noxus_story);
				alert=builder.create();
				alert.show();
				break;
			case 3:
				builder.setTitle("The League of Legends");
				builder.setMessage(R.string.league_story);
				alert=builder.create();
				alert.show();
				break;
			case 5: //Episode 1
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 6:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 7:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 8:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 9: //Episode 5
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 10:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 11:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 12:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 13:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 14: //Episode 10
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 15:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 16:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 17:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 18:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 19: //Episode 15
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 20:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 21:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 22:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 23:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 24: //Episode 20
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 25:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 26:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 27:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 28:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 29: //Episode 25
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-4)));
				startActivity(intent);
				break;
			case 30: //Breaking news
				intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://leagueoflegends.wikia.com/wiki/The_Journal_of_Justice:_BREAKING_NEWS_01"));
				startActivity(intent);
				break;
			case 31:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-5)));
				startActivity(intent);
				break;
			case 32:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-5)));
				startActivity(intent);
				break;
			case 33:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-5)));
				startActivity(intent);
				break;
			case 34:
				intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPartOne+(position-5)));
				startActivity(intent);
				break;

		}
	}
	
	//Merge Adapter First List
	private ArrayAdapter<String> buildFirstList() {
		return(new ArrayAdapter<String>(this,R.layout.list_item,LoreList));
	}
	//Merge Adapter Second List
	private ArrayAdapter<String> buildSecondList() {
		return (new ArrayAdapter<String>(this,R.layout.list_item,JOJList));
	}

	//Merge thing label JOJ
	private View buildLabel() {
		TextView result=new TextView(this);
		result.setText("Journals of Justice, Volume 1");
		result.setTextSize(30);
		result.setWidth(LinearLayout.LayoutParams.FILL_PARENT);
		result.setGravity(Gravity.CENTER_HORIZONTAL);
		result.setPadding(0,10,0,0);
		return(result);
	}
	//Merge label top section
	private View buildTop() {
		TextView res2 = new TextView(this);
		res2.setText("Game Lore");
		res2.setTextSize(30);
		res2.setWidth(LinearLayout.LayoutParams.FILL_PARENT);
		res2.setGravity(Gravity.CENTER_HORIZONTAL);
		return(res2);
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}
}