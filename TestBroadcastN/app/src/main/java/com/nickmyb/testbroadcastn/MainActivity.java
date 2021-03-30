package com.nickmyb.testbroadcastn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilterN1 = new IntentFilter();
        intentFilterN1.addAction("com.nickmyb.testbroadcast.N1_BROADCAST");
        intentFilterN1.setPriority(100);
        N1Receiver n1Receiver = new N1Receiver();
        registerReceiver(n1Receiver, intentFilterN1);
    }
}