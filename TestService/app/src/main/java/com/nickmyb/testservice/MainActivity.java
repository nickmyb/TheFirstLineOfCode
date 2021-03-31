package com.nickmyb.testservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NService.NBinder nBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            nBinder = (NService.NBinder) service;
            nBinder.start();
            nBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("NService", "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_start_service = (Button) findViewById(R.id.button_start_service);
        Button button_end_service = (Button) findViewById(R.id.button_end_service);
        button_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NService.class);
                startService(intent);
            }
        });
        button_end_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NService.class);
                stopService(intent);
            }
        });

        Button button_bind_service = (Button) findViewById(R.id.button_bind_service);
        Button button_unbind_service = (Button) findViewById(R.id.button_unbind_service);
        button_bind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
        button_unbind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NService.class);
                unbindService(serviceConnection);
            }
        });

        Button button_intent_service = (Button) findViewById(R.id.button_intent_service);
        button_intent_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NIntentService.class);
                startService(intent);
            }
        });
    }
}