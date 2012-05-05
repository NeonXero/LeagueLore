package net.neonlotus.lolandroidapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CheckBox;

/**
 * PreferenceManager.java
 *
 * Basic preferences manager to manage the value of a checkbox across sessions
 */
public class PreferenceManager {
    /* constants for shared prefs */
    private static final String PREFERENCES = "_my_prefs";
    private static final String CHECKBOX = "checkbox";
	private static String LOG = "League/PreferencesManager";

    /* easy checkbox view mgmt -- maybe a little too coupled*/
    public static void apply(Context context, CheckBox checkBox) {
        if(checkBox != null) checkBox.setChecked(PreferenceManager.get(context));
    }

    /* basic CRUD */
    public static boolean save(Context context, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).edit();
        editor.putBoolean(CHECKBOX, value);
		Log.d(LOG,"Save was called");
		editor.commit(); //bonus?
        return editor.commit();
    }
    public static boolean get(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
		Log.d(LOG,"Get was called");
        return sharedPreferences.getBoolean(CHECKBOX, false);
    }
    public static void clear(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }

}
