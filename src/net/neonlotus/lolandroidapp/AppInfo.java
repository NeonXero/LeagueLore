package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.flurry.android.FlurryAgent;

public class AppInfo extends Activity implements View.OnTouchListener{
	private static final String TAG = "LeagueLore";
	private TextView tv1, tv2, tv3;
	private CheckBox mCheckbox;
	Intent emailIntent;
	//private ChampModel mModel;
	private ChampionManager championManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_app);

		tv1 = (TextView) findViewById(R.id.emailTV);
		tv1.setOnTouchListener(this);
		tv2 = (TextView) findViewById(R.id.donateTV);
		tv2.setOnTouchListener(this);
		tv3 = (TextView) findViewById(R.id.refTV);
		tv3.setOnTouchListener(this);
		//mModel= new ChampModel();
		championManager = new ChampionManager();

		mCheckbox = (CheckBox) findViewById(R.id.checkbox);
		mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// save the updated result
				//mModel.setChampNames(mCheckbox.isChecked());

				PreferenceManager.save(getApplicationContext(), isChecked);
			}
		});
		PreferenceManager.apply(getApplicationContext(), mCheckbox);

		emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"neonxero@gmail.com"});
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "League Lore User");

		//Flurry
		FlurryAgent.onStartSession(this, " ");
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}

	public boolean onTouch(View view, MotionEvent motionEvent) {
		if (view == tv1) {
			startActivity(Intent.createChooser(emailIntent, "Send your email with:"));
		} else if (view==tv2) {
			Uri uri = Uri.parse( "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XSL3ED3KR87ZY" );
			startActivity( new Intent( Intent.ACTION_VIEW, uri ) );
		} else if (view==tv3) {
			Uri uri = Uri.parse( "http://signup.leagueoflegends.com/?ref=4f627efc72b81300825765" );
			startActivity( new Intent( Intent.ACTION_VIEW, uri ) );
		}

		return false;
	}
}