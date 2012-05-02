package net.neonlotus.lolandroidapp;

import android.content.Context;

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
		mStatus = PreferenceManager.get(c);
	}

	public void setChampNames (boolean b) {
		mStatus = b;
		//Log.d(LOG, "mstatus is now - " +mStatus.toString());
	}
	//todo: Research value and reference variable passing (obj: reference) (value: simple variable)
	//todo: overall just make sure variables are consistently named and better

	public String[] getChampNames() {
		if (mStatus) {
			return mChampModel.getChampNicknames();
		}  else{
			return mChampModel.getChampNames();
		}
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