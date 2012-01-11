package net.neonlotus.lolandroidapp;
 
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

// A basic object that can be parcelled to transfer between objects
public class ChampObj implements Parcelable {
 
	// Standard basic constructor for non-parcel object creations
	private String champName;
	private String champStory;
	private String champStats;
	private String statDesc;
	private String champBuilds;
	private String champTags; //add
	private String champAbil; //add


	public ChampObj() {};
 
	// Constructor to use when re-constructing object from a parcel
	// @param in a parcel from which to read this object

	public ChampObj(Parcel in) {
		readFromParcel(in);
	}
 
	//GET and SET for Champ Name
	public String getChampName() {
		return champName;
	}
	public void setChampName(String champName) {
		this.champName = champName;
	}

	
	//GET and SET for Champ Story
	public String getChampStory() {
		return champStory;
	}
	public void setChampStory(String champStory) {
		this.champStory = champStory;
	}

	// GET and SET for Champ Stats
	public String getStatDesc() {
		return statDesc;
	}
	public void setStatDesc(String statDesc) {
		this.statDesc=statDesc;
	}
	
    //GET and SET for Champ Stats
	public String getChampStats() {
		return champStats;
	}
	public void setChampStats(String champStats) {
		this.champStats=champStats;
	}
	

	//GET and SET for Champ Builds
	public String getChampBuilds() {
		return champBuilds;
	}
	public void setChampBuilds(String champBuilds) {
		this.champBuilds=champBuilds;
	}
	
	//TAG STUFF O>O>O>O>O
	public String getChampTags() {
		return champTags; //returning a straight string works... not the variable :(
	}
	public void setChampTags(String champTags) {
		this.champTags=champTags;
	}
	
	//GET and SET for Champ Stats... new... from Internet (Mage, tank, etc)
	public String getChampAbil() {
		return champAbil;
	}
	public void setChampAbil(String champAbil) {
		this.champAbil=champAbil;
	}

	//@Override
	public int describeContents() {
		return 0;
	}
 
	//@Override
	public void writeToParcel(Parcel dest, int flags) {
		// We just need to write each field into the
		// parcel. When we read from parcel, they
		// will come back in the same order
		dest.writeString(champName);
		dest.writeString(champStory);
		dest.writeString(champStats);
		dest.writeString(champBuilds);
		dest.writeString(statDesc);
		dest.writeString(champTags); //add
		dest.writeString(champAbil); //add
	}
 
	// Called from the constructor to create this object from a parcel.
	// @param in parcel from which to re-create object

	private void readFromParcel(Parcel in) {
		// We just need to read back each field in the order that it was written to the parcel
		champName = in.readString();
		champStory = in.readString();
		champStats = in.readString();
		champBuilds = in.readString();
		statDesc = in.readString();
		champTags=in.readString(); //add
		champAbil=in.readString();//add 2
	}
 
    /**
     *
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * This also means that you can use use the default
     * constructor to create the object and use another
     * method to hyrdate it as necessary.
     *
     * I just find it easier to use the constructor.
     * It makes sense for the way my brain thinks ;-)
     *
     */
    public static final Parcelable.Creator CREATOR =
    	new Parcelable.Creator() {
            public ChampObj createFromParcel(Parcel in) {
                return new ChampObj(in);
            }
 
            public ChampObj[] newArray(int size) {
                return new ChampObj[size];
            }
        };

//	int[] iconBox = new int[]{R.drawable.ak, R.drawable.al, R.drawable.am};
//
//	public int[] getIcon() {
//		return iconBox;
//	}
}