package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
}