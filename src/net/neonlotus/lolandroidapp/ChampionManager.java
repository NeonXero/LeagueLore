package net.neonlotus.lolandroidapp;

/**
 * Created with IntelliJ IDEA.
 * User: Ryan
 * Date: 4/30/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChampionManager {
	ChampModel champModel;
	private String[] mChampnames;
	private String[] mRealnames;
	private String[] mNicknames;

	public ChampionManager() {
		champModel = new ChampModel();
	}

	public void setChampNames(Boolean b) {
		if (b) { //if checkbox is ticked, set names to "nicknames"
			mChampnames = mNicknames;
		} else {
			mChampnames = mRealnames;
		}
	}


	public String[] getChampNames() {
		return champModel.getChampNames();
	}
	public String[] getChampLore() {
		return champModel.getLore();
	}

}
