package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: RyanThomas
 * Date: 12/22/11
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemClass {
	private static Context context;
	//Maybe handle item pulling in here
	//Or... just all the data pulling?
	//Jsoup + Mobafire



	



	/*public static ArrayList<String> getChampNames() {
		final ArrayList<String> champInternetList = new ArrayList<String>();

		String url = "http://www.mobafire.com/league-of-legends/champions";
		Document document = null;
		Elements divs = null;
		try {
			document = Jsoup.connect(url).get();
			divs = document.select("div.champ-name");

			for (Element div : divs) {
				System.out.println(div.text());
				champInternetList.add(div.text());
			}

		} catch (IOException e) {
			//Toast.makeText(context,"Error pulling chamnpion names",Toast.LENGTH_SHORT).show();
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		return champInternetList;
	}*/


	/*public static ArrayList<String> getChampTags() {
		final ArrayList<String> champTags = new ArrayList<String>();

		String url = "http://na.leagueoflegends.com/champions";
		Document document = null;
		Elements divz = null;
		try {
			document = Jsoup.connect(url).get();
			Elements divs = document.select("div#mode_view_grid");
			divz = divs.select("span.search_text");

			for (Element span : divz) {
				champTags.add(span.text());
				System.out.println(span.text());
			}
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		return champTags;
	}*/

	/*public static ArrayList<String> getChampStatus() {
		final ArrayList<String> champStats = new ArrayList<String>();

		String url = "http://na.leagueoflegends.com/champions";
		Document document = null;
		Elements tagz=null;
		Elements togz = null;

		*//*
		for(int i = 0, len = tagz.size(); i < len; i++) { // iterate though all champ sections
           theus = tagz.get(i).select("u"); // get list of u's for JUST this champ section (i)
           if(theus.size() > 0) {
               champStats.add(theus.get(0)); // if there are u's just save the first one.
               break; // stop iterating
           }
       }
.get might be the wrong syntax you will  have to figure that otu
if you put it up on git ill write it
and test it
5:28 PM


		 *//*

		try {
			document = Jsoup.connect(url).get();
			//Elements divs = document.select("div#mode_view_list");
			tagz = document.select("td.description");
			
			//togz = tagz.select("span:has(u)");

			*//*for (Element u : tagz) {
				System.out.println(u.text());
				champStats.add(u.text());
			}*//*
			
			System.out.println(tagz.text());
			
			int len = tagz.size();
			
			for (int i=0; i<len; i++) { //Iterate champs
				String theus = tagz.select("u").text(); //u's for champ section
				//if (theus.size()>0) {
					champStats.add(theus);
				System.out.println(theus);
				//	break;
				//}

			}
		} catch (IOException e) {
			//Toast.makeText(context,"Error pulling chamnpion tags",Toast.LENGTH_SHORT).show();
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}

		return champStats;
	}*/
}