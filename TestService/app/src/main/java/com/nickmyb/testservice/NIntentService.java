package com.nickmyb.testservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class NIntentService extends IntentService {
    public NIntentService() {
        super("NIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("NIntentService", "Thread id is " + Thread.currentThread(). getId());
    }

    @Override
    public void onDestroy() {
        Log.i("NIntentService", "onDestroy");
    }
}
