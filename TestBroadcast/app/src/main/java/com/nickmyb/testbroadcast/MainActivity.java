package com.nickmyb.testbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private IntentFilter intentFilter;
    private ConnectivityChangeBroadcastReceiver connectivityChangeBroadcastReceiver;

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
            }
        });
    }
}