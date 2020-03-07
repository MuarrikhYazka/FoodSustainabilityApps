package com.example.foodsustainabilityapps.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Preferences {

    private static final String KEY_STATUS_notifikasi = "status_notifkasi";

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    static void setStatusNotifkasi(Context context, Boolean status) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_STATUS_notifikasi, status);
        editor.apply();
    }

    static Boolean getStatusNotifikasi(Context context) {
        return getSharedPreference(context).getBoolean(KEY_STATUS_notifikasi, true);
    }
}