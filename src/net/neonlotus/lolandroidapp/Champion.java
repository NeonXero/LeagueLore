package net.neonlotus.lolandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.TitleProvider;

public class Champion extends Activity implements View.OnClickListener {

	private ChampObj mChampData;
	private String mPrefPrefix;

	Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, bEmail;
	private SharedPreferences mPrefs;

	//Saved stuff
	String item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12;
	//Temp string... for saving prefs
	String t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	private static final String TAG = "LeagueLore";
	
	private int bPost;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Flurry
		FlurryAgent.onStartSession(this, " ");

		setContentView(R.layout.othermain);

		Bundle b = getIntent().getExtras();
		if (b != null && b.getParcelable("net.neonlotus.lolandroidapp.ChampObj") != null) {
			mChampData = b.getParcelable("net.neonlotus.lolandroidapp.ChampObj");
		} else {
			Toast.makeText(this, "No Champion selected!", Toast.LENGTH_SHORT).show();
			finish();
		}

		mPrefPrefix = mChampData.getChampName() + "_";

		mPrefs = getPreferences(MODE_PRIVATE);
		item1 = mPrefs.getString(mPrefPrefix + "item1", "Item 1");
		item2 = mPrefs.getString(mPrefPrefix + "item2", "Item 2");
		item3 = mPrefs.getString(mPrefPrefix + "item3", "Item 3");
		item4 = mPrefs.getString(mPrefPrefix + "item4", "Item 4");
		item5 = mPrefs.getString(mPrefPrefix + "item5", "Item 5");
		item6 = mPrefs.getString(mPrefPrefix + "item6", "Item 6");
		item7 = mPrefs.getString(mPrefPrefix + "item7", "Item 7");
		item8 = mPrefs.getString(mPrefPrefix + "item8", "Item 8");
		item9 = mPrefs.getString(mPrefPrefix + "item9", "Item 9");
		item10 = mPrefs.getString(mPrefPrefix + "item10", "Item 10");
		item11 = mPrefs.getString(mPrefPrefix + "item11", "Item 11");
		item12 = mPrefs.getString(mPrefPrefix + "item12", "Item 12");

		MyPagerAdapter adapter = new MyPagerAdapter();
		ViewPager myPager = (ViewPager) findViewById(R.id.thisshouldwork);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);

		TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.titles);
		titleIndicator.setViewPager(myPager);
	}

	public void onClick(View view) {
		//To change body of implemented methods use File | Settings | File Templates.
	}


	private class MyPagerAdapter extends PagerAdapter implements TitleProvider {

		public int getCount() {
			return 3; //Amount of pages
		}

		public Object instantiateItem(View collection, final int position) {

			LayoutInflater inflater = (LayoutInflater) collection.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View view = null;
			switch (position) {
				case 0:
					view = inflater.inflate(R.layout.left_page, null);
					((TextView) view.findViewById(R.id.lorechamp)).setText(mChampData.getChampStory());
					((TextView) view.findViewById(R.id.champName)).setText(mChampData.getChampTags());

					//Banner work
					Resources res = getResources();
					TypedArray icons = res.obtainTypedArray(R.array.champ_banners);
					Drawable drawable = icons.getDrawable(mChampData.getIndex());
					//Log.d(TAG, "Index=" + mChampData.getIndex());

					((ImageView) view.findViewById(R.id.champ_banner)).setImageDrawable(drawable);

					break;
				case 1:
					view = inflater.inflate(R.layout.mid_page, null);
					((TextView) view.findViewById(R.id.champName)).setText(mChampData.getChampTags());
					((TextView) view.findViewById(R.id.champ_stats)).setText(mChampData.getChampStats());

					//Champ stat magic
					String allRoles = "";
					String junkStuff = mChampData.getChampStats();
					String noSpace = junkStuff.replaceAll(" ", "").toLowerCase();
					String noJunk[] = noSpace.split(",");
					for (int i = 0; i < noJunk.length; i++) {
						// WORKS, returns each role Toast.makeText(Champion.this, noJunk[i], Toast.LENGTH_SHORT).show();
						if (noJunk[i].equals("assassin")) {
							allRoles = allRoles + getString(R.string.assassin) + "\n\n";
						}
						if (noJunk[i].equals("carry")) {
							allRoles = allRoles + getString(R.string.carry) + "\n\n";
						}
						if (noJunk[i].equals("fighter")) {
							allRoles = allRoles + getString(R.string.fighter) + "\n\n";
						}
						if (noJunk[i].equals("jungler")) {
							allRoles = allRoles + getString(R.string.jungler) + "\n\n";
						}
						if (noJunk[i].equals("mage")) {
							allRoles = allRoles + getString(R.string.mage) + "\n\n";
						}
						if (noJunk[i].equals("melee")) {
							allRoles = allRoles + getString(R.string.melee) + "\n\n";
						}
						if (noJunk[i].equals("pusher")) {
							allRoles = allRoles + getString(R.string.pusher) + "\n\n";
						}
						if (noJunk[i].equals("ranged")) {
							allRoles = allRoles + getString(R.string.ranged) + "\n\n";
						}
						if (noJunk[i].equals("recommended")) {
							allRoles = allRoles + getString(R.string.recommended) + "\n\n";
						}
						if (noJunk[i].equals("stealth")) {
							allRoles = allRoles + getString(R.string.stealth) + "\n\n";
						}
						if (noJunk[i].equals("support")) {
							allRoles = allRoles + getString(R.string.support) + "\n\n";
						}
						if (noJunk[i].equals("tank")) {
							allRoles = allRoles + getString(R.string.tank) + "\n\n";
						}

						((TextView) view.findViewById(R.id.descone)).setText(allRoles);
					}
					break;
				case 2:
					view = inflater.inflate(R.layout.right_page, null);
					((TextView) view.findViewById(R.id.champName)).setText(mChampData.getChampTags());

					//======= WISH I COULD CLEAN THIS UP A BIT... DURR ======//

					b1 = ((Button) view.findViewById(R.id.itemButton1));
					b2 = ((Button) view.findViewById(R.id.itemButton2));
					b3 = ((Button) view.findViewById(R.id.itemButton3));
					b4 = ((Button) view.findViewById(R.id.itemButton4));
					b5 = ((Button) view.findViewById(R.id.itemButton5));
					b6 = ((Button) view.findViewById(R.id.itemButton6));
					b7 = ((Button) view.findViewById(R.id.itemButton7));
					b8 = ((Button) view.findViewById(R.id.itemButton8));
					b9 = ((Button) view.findViewById(R.id.itemButton9));
					b10 = ((Button) view.findViewById(R.id.itemButton10));
					b11 = ((Button) view.findViewById(R.id.itemButton11));
					b12 = ((Button) view.findViewById(R.id.itemButton12));
					bEmail=((Button)view.findViewById(R.id.emailButton));

					LoadPreferences();

					b1.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=1;
							showOptionsMenu(0);
						}
					});
					b2.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=2;
							showOptionsMenu(1);
						}
					});
					b3.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=3;
							showOptionsMenu(2);
						}
					});
					b4.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost = 4;
							showOptionsMenu(3);
						}
					});
					b5.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=5;
							showOptionsMenu(4);
						}
					});
					b6.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=6;
							showOptionsMenu(5);
						}
					});
					b7.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=7;
							showOptionsMenu(6);
						}
					});
					b8.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=8;
							showOptionsMenu(7);
						}
					});
					b9.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=9;
							showOptionsMenu(8);
						}
					});
					b10.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=10;
							showOptionsMenu(9);
						}
					});
					b11.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=11;
							showOptionsMenu(10);
						}
					});
					b12.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							bPost=12;
							showOptionsMenu(11);
						}
					});
					bEmail.setOnClickListener(new View.OnClickListener() {
						public void onClick(View view) {
							Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

							emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "League Lore Build for " + mChampData.getChampName());
							String sendThis = "1. " + b1.getText()+"\n2. "+b2.getText()+"\n3. "+b3.getText()+"\n4. "+b4.getText()
									+"\n5. "+b5.getText()+"\n6. "+b6.getText()+"\n7. "+b7.getText()+"\n8. "+b8.getText()
									+"\n9. "+b9.getText()+"\n10. "+b10.getText()+"\n11. "+b11.getText()+"\n12. "+b12.getText();
							emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, sendThis);

							emailIntent.setType("text/plain");

							startActivity(Intent.createChooser(emailIntent, "Send mail..."));

							finish();
						}
					});

					break;
			}

			((ViewPager) collection).addView(view, 0);

			return view;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);
		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub
		}

		public String getTitle(int position) {
			switch (position) {
				case 0:
					return "Lore";
				case 1:
					return "Tags";
				case 2:
					return "Build";
			}
			return Integer.toString(position);
		}
	}

	public void showOptionsMenu(final int position) { //position = which button was pressed

		new AlertDialog.Builder(this)
				.setTitle("Item List").setCancelable(true).setItems(R.array.shoplvlone,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) { //int i = which item in dialog was pressed
						//take actions here according to what the user has selected
						final String[] topLevel = getResources().getStringArray(R.array.shoplvlone);

						switch (i) {
							case 0:
								//Defense method
								dialogDefense();
								break;
							case 1:
								//Attack Method
								dialogAttack();
								break;
							case 2:
								//Magic Method
								dialogMagic();
								break;
							case 3:
								//Movement
								movementItems();
								break;
							case 4:
								//Consumables
								consumeItems();
								break;
						}
					}
				}
		).show();
	}

	//DEFENSE SUB CATEGORY done
	public void dialogDefense () {
		new AlertDialog.Builder(this).setTitle("Defense Items").setCancelable(true).setItems(R.array.shopDefense,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						switch (b) {
							case 0:
								healthItems();
								break;
							case 1:
								mresistItems();
								break;
							case 2:
								hregenItems();
								break;
							case 3:
								armorItems();
								break;
						}
					}
				}).show();
	}
	//ATTACK SUB CATEGORY done
	public void dialogAttack () {
		new AlertDialog.Builder(this).setTitle("Attack Items").setCancelable(true).setItems(R.array.shopAttack,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						switch (b) { //damange, crit, aspd, life steal
							case 0:
								damageItems();
								break;
							case 1:
								critItems();
								break;
							case 2:
								aspdItems();
								break;
							case 3:
								lifestealItems();
								break;
						}
					}
				}).show();
	}
	//MAGIC SUB CATEGORY done
	public void dialogMagic () {
		new AlertDialog.Builder(this).setTitle("Magic Items").setCancelable(true).setItems(R.array.shopMagic,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						switch (b) {
							case 0:
								abpoItems();
								break;
							case 1:
								cdrItems();
								break;
							case 2:
								manaItems();
								break;
							case 3:
								mregItems();
								break;
						}
					}
				}).show();
	}
	//MOVEMENT SUB CATEGORY done
	public void movementItems() {
		new AlertDialog.Builder(this).setTitle("Movement Items").setCancelable(true).setItems(R.array.moveItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.moveItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//CONSUMABLES SUB CATEGORY done
	public void consumeItems() {
		new AlertDialog.Builder(this).setTitle("Consumables").setCancelable(true).setItems(R.array.consumeItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.consumeItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//HEALTH ITEMS
	public void healthItems() {
		new AlertDialog.Builder(this).setTitle("Health Items").setCancelable(true).setItems(R.array.healthItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.healthItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//MAGIC RESIST ITEMS
	public void mresistItems() {
		new AlertDialog.Builder(this).setTitle("Magic Resist Items").setCancelable(true).setItems(R.array.mresistItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.mresistItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//HEALTH REGEN ITEMS
	public void hregenItems() {
		new AlertDialog.Builder(this).setTitle("Health Regen Items").setCancelable(true).setItems(R.array.hregenItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.hregenItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//ARMOR ITEMS
	public void armorItems() {
		new AlertDialog.Builder(this).setTitle("Armor Items").setCancelable(true).setItems(R.array.armor,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.armor);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//DAMAGE ITEMS
	public void damageItems() {
		new AlertDialog.Builder(this).setTitle("Damage Items").setCancelable(true).setItems(R.array.damageItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.damageItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//CRITICAL STRIKE ITEMS
	public void critItems() {
		new AlertDialog.Builder(this).setTitle("Crit Strike Items").setCancelable(true).setItems(R.array.critItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.critItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//ATTACK SPEED ITEMS
	public void aspdItems() {
		new AlertDialog.Builder(this).setTitle("Attack Speed Items").setCancelable(true).setItems(R.array.aspeedItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.aspeedItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//LIFE STEAL ITEMS
	public void lifestealItems() {
		new AlertDialog.Builder(this).setTitle("Life Steal Items").setCancelable(true).setItems(R.array.lifestealItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.lifestealItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//ABILITY POWER ITEMS
	public void abpoItems() {
		new AlertDialog.Builder(this).setTitle("Spell Damage Items").setCancelable(true).setItems(R.array.apItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.apItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//COOLDOWN REDUCTION ITEMS
	public void cdrItems() {
		new AlertDialog.Builder(this).setTitle("CDR Items").setCancelable(true).setItems(R.array.cdrItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.cdrItems);
						takinCareOfBusiness(bPost,b,itemArray);
					}
				}).show();
	}
	//MANA ITEMS
	public void manaItems() {
		new AlertDialog.Builder(this).setTitle("Mana Items").setCancelable(true).setItems(R.array.manaItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray = getResources().getStringArray(R.array.manaItems);
						takinCareOfBusiness(bPost, b, itemArray);
					}
				}).show();
	}
	//MANA REGEN ITEMS
	public void mregItems() {
		new AlertDialog.Builder(this).setTitle("Mana Regen Items").setCancelable(true).setItems(R.array.manaregenItems,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialogInterface, int b) {
						String[] itemArray= getResources().getStringArray(R.array.manaregenItems);
						takinCareOfBusiness(bPost,b, itemArray);
					}
				}).show();
	}
	
	public void takinCareOfBusiness(int theButton, int theB, String[] theArray) {
		int test = theButton;
		int test2 = theB;
		String[] someItems = theArray;

		//==== LOG testing ====//
		//Log.d(TAG,"Button ?? " +test);
		//Log.d(TAG,"Other thing ?? " +test2);

		//switch for test
		switch (test) { //initial button press
			case 1:
				b1.setText(someItems[test2]); //b, menu selection
				t1 = b1.getText().toString(); //change button text
				SavePreferences(mPrefPrefix + "item1", t1); //save preference
				break;
			case 2:
				b2.setText(someItems[test2]);
				t2 = b2.getText().toString();
				SavePreferences(mPrefPrefix + "item2", t2);
				break;
			case 3:
				b3.setText(someItems[test2]);
				t3 = b3.getText().toString();
				SavePreferences(mPrefPrefix + "item3", t3);
				break;
			case 4:
				b4.setText(someItems[test2]);
				t4 = b4.getText().toString();
				SavePreferences(mPrefPrefix + "item4", t4);
				break;
			case 5:
				b5.setText(someItems[test2]);
				t5 = b5.getText().toString();
				SavePreferences(mPrefPrefix + "item5", t5);
				break;
			case 6:
				b6.setText(someItems[test2]);
				t6 = b6.getText().toString();
				SavePreferences(mPrefPrefix + "item6", t6);
				break;
			case 7:
				b7.setText(someItems[test2]);
				t7 = b7.getText().toString();
				SavePreferences(mPrefPrefix + "item7", t7);
				break;
			case 8:
				b8.setText(someItems[test2]);
				t8 = b8.getText().toString();
				SavePreferences(mPrefPrefix + "item8", t8);
				break;
			case 9:
				b9.setText(someItems[test2]);
				t9 = b9.getText().toString();
				SavePreferences(mPrefPrefix + "item9", t9);
				break;
			case 10:
				b10.setText(someItems[test2]);
				t10 = b10.getText().toString();
				SavePreferences(mPrefPrefix + "item10", t10);
				break;
			case 11:
				b11.setText(someItems[test2]);
				t11 = b11.getText().toString();
				SavePreferences(mPrefPrefix + "item11", t11);
				break;
			case 12:
				b12.setText(someItems[test2]);
				t12 = b12.getText().toString();
				SavePreferences(mPrefPrefix + "item12", t12);
				break;
		}

	}

	private void SavePreferences(String key, String value) {
		mPrefs = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = mPrefs.edit();
		editor.putString(key, value);
		editor.commit();
	}

	private void LoadPreferences() {
		mPrefs = getPreferences(MODE_PRIVATE);
		String s1 = mPrefs.getString(mPrefPrefix + "item1", "Item 1");
		b1.setText(s1);
		String s2 = mPrefs.getString(mPrefPrefix + "item2", "Item 2");
		b2.setText(s2);
		String s3 = mPrefs.getString(mPrefPrefix + "item3", "Item 3");
		b3.setText(s3);
		String s4 = mPrefs.getString(mPrefPrefix + "item4", "Item 4");
		b4.setText(s4);
		String s5 = mPrefs.getString(mPrefPrefix + "item5", "Item 5");
		b5.setText(s5);
		String s6 = mPrefs.getString(mPrefPrefix + "item6", "Item 6");
		b6.setText(s6);
		String s7 = mPrefs.getString(mPrefPrefix + "item7", "Item 7");
		b7.setText(s7);
		String s8 = mPrefs.getString(mPrefPrefix + "item8", "Item 8");
		b8.setText(s8);
		String s9 = mPrefs.getString(mPrefPrefix + "item9", "Item 9");
		b9.setText(s9);
		String s10 = mPrefs.getString(mPrefPrefix + "item10", "Item 10");
		b10.setText(s10);
		String s11 = mPrefs.getString(mPrefPrefix + "item11", "Item 11");
		b11.setText(s11);
		String s12 = mPrefs.getString(mPrefPrefix + "item12", "Item 12");
		b12.setText(s12);
	}

	public void onStop()
	{
		super.onStop();
		FlurryAgent.onEndSession(this);
		// your code
	}
}