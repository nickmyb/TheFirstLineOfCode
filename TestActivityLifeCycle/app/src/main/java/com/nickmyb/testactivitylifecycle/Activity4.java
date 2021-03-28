package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {
    private static final String TAG = "SINGLETOP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "task id = " + getTaskId());
        Log.i(TAG, "instance = " + this);
        setContentView(R.layout.activity_4);

        Button button_start_lunch_single_top = (Button) findViewById(R.id.button_start_lunch_single_top);
        button_start_lunch_single_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity4.class);
                startActivity(intent);
            }
        });
    }
}