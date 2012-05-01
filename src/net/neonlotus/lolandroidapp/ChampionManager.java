package net.neonlotus.lolandroidapp;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 4/30/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChampionManager {
	private ChampModel mChampModel;
	private Boolean mStatus; //todo: better name later

	public ChampionManager(Context c) {
		mChampModel = new ChampModel(c);
	}

	public void setChampNames (boolean b) {
		mStatus = b;
	} //todo: lookup value and reference variable passing (obj: reference) (value: simple variable)
	//todo: overall just make sure variables are consistently named

	public String[] getChampNames() {
		if (mStatus) {
			return mChampModel.getChampNames();
		} else {
			return mChampModel.getChampNicknames();
		}
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

}