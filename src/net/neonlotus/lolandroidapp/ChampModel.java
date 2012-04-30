package net.neonlotus.lolandroidapp;

import android.content.Context;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 4/27/12
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChampModel extends Observable {
	//String arrays for either real names or fake names
	private String[] mChampnames;
	private String[] mRealnames;
	private String[] mNicknames;
	private String[] mLore;
	private String[] real;

	public ChampModel(Context c) { //Context c
		mRealnames = c.getResources().getStringArray(R.array.champ_list);
		mNicknames = c.getResources().getStringArray(R.array.champ_list_egg);
		mLore = c.getResources().getStringArray(R.array.champ_lore);
		mChampnames = null;
	}

	/*public ChampModel() {
		//To change body of created methods use File | Settings | File Templates.
		real = mRealnames;
		String[] fake = mNicknames;
	}*/

	public void setChampNames(Boolean b) {
		if (b) { //if checkbox is ticked, set names to "nicknames"
			mChampnames = mNicknames;
		} else {
			mChampnames = mRealnames;
		}
		notifyObservers();
	}

	public String[] getChampNames() {
		//return mChampnames;
		return real;
	}
	public String[] getLore() {
		return mLore;
	}
}

//Possible function rewrite to return each individual array rather than checking and returning one