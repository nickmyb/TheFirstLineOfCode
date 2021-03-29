package com.nickmyb.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

class ConnectivityChangeBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "CCBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        Log.i(TAG, "onReceive: " + intent);
        if (networkInfo != null && networkInfo.isAvailable()) {
            Toast.makeText(context, "当前网络可用", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "当前网络不可用", Toast.LENGTH_SHORT).show();
        }

    }
}
