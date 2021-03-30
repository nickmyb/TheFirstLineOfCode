package com.nickmyb.testbroadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ForceOfflineReceiverStatic extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ForceOffline", "ForceOfflineReceiverStatic RECEIVED");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Force Offline Static");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Force Offline Static", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
