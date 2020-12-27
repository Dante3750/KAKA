package com.globals.netconnect.kaka.App;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

import static com.globals.netconnect.kaka.App.Cons.KEY_LOGGED_IN;
import static com.globals.netconnect.kaka.App.Cons.KEY_MOBILE_NO;

public class PrefManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context mContext;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "NetConnectSharedPref";
    private static final String KEY_NOTIFICATIONS = "notifications";


    public PrefManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void createLoginDetails(String mobileNo) {
        editor.putString(KEY_MOBILE_NO, mobileNo);
        editor.putBoolean(KEY_LOGGED_IN, true);
        editor.commit();
    }



    public HashMap<String, String> getEmpDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_MOBILE_NO, pref.getString(KEY_MOBILE_NO, null));
        return user;
    }




    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_LOGGED_IN, false);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
        Log.d("TAG", "Deleted all user info from shared preference");
    }



}
