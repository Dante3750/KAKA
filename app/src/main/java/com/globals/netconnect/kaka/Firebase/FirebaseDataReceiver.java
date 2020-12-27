package com.globals.netconnect.kaka.Firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class FirebaseDataReceiver extends WakefulBroadcastReceiver {

    private final String TAG = "FirebaseDataReceiver";

    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "I'm in!!!");
        Bundle dataBundle = intent.getBundleExtra("data");
        Log.d(TAG, "onReceive: "+dataBundle.toString());
        Log.d(TAG, dataBundle.toString());
    }
}