package com.nickmyb.testbroadcastn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class N1Receiver extends BroadcastReceiver {
    private static final String TAG = "N N1Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive");
        Toast.makeText(context, "N N1Receiver收到广播", Toast.LENGTH_SHORT).show();
        // abortBroadcast();
    }
}