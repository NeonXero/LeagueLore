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
	private String[] champ_names;
	private String[] realnames;
	private String[] nicknames;

	public ChampModel(Context c) {
		realnames = c.getResources().getStringArray(R.array.champ_list);
		nicknames = c.getResources().getStringArray(R.array.champ_list_egg);
		champ_names = null;
	}

	public void setChamp_names(Boolean b) {
		if (b) { //if checkbox is ticked, set names to "nicknames"
			champ_names = nicknames;
		} else {
			champ_names = realnames;
		}

	}

	public String[] getChamp_names() {
		return champ_names;
	}
}

//final String[] champ_list_array = getResources().getStringArray(R.array.champ_list);
//final String[] champ_list_joke = getResources().getStringArray(R.array.champ_list_egg);