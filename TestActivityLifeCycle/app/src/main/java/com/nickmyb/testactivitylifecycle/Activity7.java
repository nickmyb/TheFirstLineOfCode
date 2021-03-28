package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity7 extends AppCompatActivity {
    private static final String TAG = "SINGLEINSTANCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        Log.i(TAG, "task id = " + getTaskId());
        Log.i(TAG, "instance = " + this);

        Button button_start_lunch_single_instance = (Button) findViewById(R.id.button_start_lunch_single_instance);
        button_start_lunch_single_instance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity7.this, Activity8.class);
                startActivity(intent);
            }
        });
    }
}