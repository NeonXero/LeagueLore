package net.neonlotus.lolandroidapp;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 4/27/12
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChampModel {

	private String LOG = "League/ChampModel";
	private String[] mRealnames;
	private String[] mNicknames;
	private String[] mLore;
	private String[] mStats;
	private String[] mTags;
	private Integer[] mThumbIds;

	public ChampModel(Context c) {
		mRealnames = c.getResources().getStringArray(R.array.champ_list);
		mNicknames = c.getResources().getStringArray(R.array.champ_list_egg);
		mLore = c.getResources().getStringArray(R.array.champ_lore);
		mStats = c.getResources().getStringArray(R.array.champ_stats);
		mTags = c.getResources().getStringArray(R.array.champ_taglines);

		mThumbIds = new Integer[]{
				R.drawable.ahri, R.drawable.akal, R.drawable.ali, R.drawable.amumu, R.drawable.anivia,
				R.drawable.annie, R.drawable.ashe, R.drawable.blitz, R.drawable.brand, R.drawable.cait,
				R.drawable.cassi, R.drawable.cho, R.drawable.corki, R.drawable.darius, R.drawable.diana, R.drawable.drmu, R.drawable.draven,
				R.drawable.evel, R.drawable.ezr,
				R.drawable.fiddle, R.drawable.fiora, R.drawable.fizz, R.drawable.galio, R.drawable.gang,
				R.drawable.garen, R.drawable.gragas, R.drawable.graves, R.drawable.hecarim, R.drawable.heim,
				R.drawable.irel, R.drawable.janna, R.drawable.jarv, R.drawable.jax, R.drawable.jayce, R.drawable.karma,
				R.drawable.karth, R.drawable.kass, R.drawable.kata, R.drawable.kayle, R.drawable.kennen,
				R.drawable.kog, R.drawable.leblanc, R.drawable.leesin, R.drawable.leona, R.drawable.lulu,
				R.drawable.lux, R.drawable.malph, R.drawable.malz, R.drawable.mao, R.drawable.master,
				R.drawable.missfort, R.drawable.mord, R.drawable.morg, R.drawable.nasus, R.drawable.naut,
				R.drawable.nidalee, R.drawable.noct, R.drawable.nunu, R.drawable.olaf, R.drawable.orian,
				R.drawable.panth, R.drawable.poppy, R.drawable.rammus, R.drawable.rene, R.drawable.rengar, R.drawable.riven,
				R.drawable.rumb, R.drawable.ryze, R.drawable.sej, R.drawable.shaco, R.drawable.shen, R.drawable.shyv,
				R.drawable.singed, R.drawable.sion, R.drawable.sivir, R.drawable.skarn, R.drawable.sona,
				R.drawable.soraka, R.drawable.swain, R.drawable.talon, R.drawable.taric, R.drawable.teemo,
				R.drawable.trist, R.drawable.trundle, R.drawable.trynd, R.drawable.twifa, R.drawable.twitch,
				R.drawable.udyr, R.drawable.urgot, R.drawable.varus, R.drawable.vayne, R.drawable.veig,
				R.drawable.viktor,R.drawable.vlad, R.drawable.volibear, R.drawable.warw, R.drawable.wukong,
				R.drawable.xera,R.drawable.xinz, R.drawable.yorik, R.drawable.ziggs, R.drawable.zil, R.drawable.zyra
		};
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
	public Integer[] getThumbIds() {
		return mThumbIds;
	}
}