package com.nickmyb.testbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private IntentFilter intentFilter;
    private ConnectivityChangeBroadcastReceiver connectivityChangeBroadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        connectivityChangeBroadcastReceiver = new ConnectivityChangeBroadcastReceiver();
        registerReceiver(connectivityChangeBroadcastReceiver, intentFilter);

        IntentFilter intentFilterN1 = new IntentFilter();
        intentFilterN1.addAction("com.nickmyb.testbroadcast.N1_BROADCAST");
        intentFilterN1.setPriority(50);
        N1Receiver n1Receiver = new N1Receiver();
        registerReceiver(n1Receiver, intentFilterN1);

        IntentFilter intentFilterLocal = new IntentFilter();
        intentFilterLocal.addAction("com.nickmyb.testbroadcast.LOCAL_BROADCAST");
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(new LocalReceiver(), intentFilterLocal);

        Button n1_broadcast_button = (Button) findViewById(R.id.n1_broadcast_button);
        n1_broadcast_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.nickmyb.testbroadcast.N1_BROADCAST");

                // 8.0后需要setPackage 或者 setComponent
                // intent.setPackage(getPackageName());
//                intent.setComponent(new ComponentName(
//                        getPackageName(),
//                        "com.nickmyb.testbroadcast.N1Receiver")
//                );
//                sendBroadcast(intent);

                sendOrderedBroadcast(intent, null);

                Intent localIntent = new Intent("com.nickmyb.testbroadcast.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(localIntent);
            }
        });

        IntentFilter intentFilterForceOfflineDynamic = new IntentFilter();
        intentFilterForceOfflineDynamic.addAction("com.nickmyb.testbroadcast.FORCE_OFFLINE_DYNAMIC");
        registerReceiver(new ForceOfflineReceiverDynamic(), intentFilterForceOfflineDynamic);

        Button force_offline_button_dynamic = (Button) findViewById(R.id.force_offline_button_dynamic);
        force_offline_button_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.nickmyb.testbroadcast.FORCE_OFFLINE_DYNAMIC");
                sendBroadcast(intent);
            }
        });

        Button force_offline_button_static = (Button) findViewById(R.id.force_offline_button_static);
        force_offline_button_static.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.nickmyb.testbroadcast.FORCE_OFFLINE_STATIC");
                intent.setPackage(getPackageName());
                Log.i("ForceOffline", "SEND STATIC");
                sendBroadcast(intent);
            }
        });
    }
}
