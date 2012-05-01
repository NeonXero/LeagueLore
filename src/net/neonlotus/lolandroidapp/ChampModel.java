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
	private String[] mStats;
	private String[] mTags;

	public ChampModel(Context c) { //Context c
		mRealnames = c.getResources().getStringArray(R.array.champ_list);
		mNicknames = c.getResources().getStringArray(R.array.champ_list_egg);
		mLore = c.getResources().getStringArray(R.array.champ_lore);
		mStats = c.getResources().getStringArray(R.array.champ_stats);
		mTags = c.getResources().getStringArray(R.array.champ_taglines);
	}



	public String[] getChampNames() {
		return mRealnames;
	}
	public String[] getChampNicknames() {
		return mNicknames;
	}

	public String[] getLore() {
		return mLore;
	}
	public String[] getStats() {
		return mStats;
	}
	public String[] getTags() {
		return mTags;
	}
}

//Possible function rewrite to return each individual array rather than checking and returning one