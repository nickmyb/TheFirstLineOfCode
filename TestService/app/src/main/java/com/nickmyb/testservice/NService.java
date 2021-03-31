package com.nickmyb.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class NService extends Service {
    private static final String TAG = "NService";
    private NBinder nBinder = new NBinder();

    class NBinder extends Binder {
        public void start() {
            Log.d(TAG, "start");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress");
            return 0;
        }
    }

    public NService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "NService instance = " + this);
        Log.i(TAG, "NBinder instance = " + nBinder);
        return nBinder;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        Log.i(TAG, "NService instance = " + this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}