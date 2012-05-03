package net.neonlotus.lolandroidapp;

import android.content.Context;
import android.util.Log;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 4/30/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChampionManager extends Observable {
	private ChampModel mChampModel;
	private boolean mStatus; //todo: better name later
	private String LOG = "League/ChampManager";

	public ChampionManager(Context c) {
		mChampModel = new ChampModel(c);
		//mStatus = PreferenceManager.get(c);
		Log.d(LOG,"Pref mang" + PreferenceManager.get(c));
		setChampNames(PreferenceManager.get(c));
	}

	public void setChampNames (boolean b) {
		mStatus = b;
		Log.d(LOG,"Set champ name manager was called");
		Log.d(LOG,"mstatus is " + mStatus);
		notifyObservers(); //this?


		//Log.d(LOG, "mstatus is now - " +mStatus.toString());
		//^ when I changed that to Boolean, and logged it out.. seems to be correctly changing from false to true based on the state of the checkbox in AppInfo...
	}
	//todo: Research value and reference variable passing (obj: reference) (value: simple variable)
	//todo: overall just make sure variables are consistently named and better

	public String[] getChampNames() {
		Log.d(LOG,"get champ was called");
		Log.d(LOG,"mstatus = " + mStatus);
		if (mStatus) {
			return mChampModel.getChampNicknames();
			//return mChampModel.getChampNames();
		}  /*else{
			//return mChampModel.getChampNames();
			return mChampModel.getChampNicknames();
		}*/
		return mChampModel.getChampNames();
		//mstatus is always false currently... or rather, the else statement is being returned
	}

	public String[] getChampLore() {
		return mChampModel.getLore();
	}
	public String[] getChampStats() {
		return mChampModel.getStats();
	}
	public String[] getChampTags() {
		return mChampModel.getTags();
	}
	public Integer[] getThumbIds() {
		return mChampModel.getThumbIds();
	}

}

/*
//todo: investigate this...
 guess what i mean was
when your app starts
PrefManager.set(true);
and then log it out in your manager
if it says false there that means your over writing it somewhere
then you can log out the set function in the manager and see how often it's being called
*/