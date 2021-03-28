package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity5 extends BaseActivity {
    private static final String TAG = "SINGLETASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        Log.i(TAG, "Activity5 task id = " + getTaskId());
        Log.i(TAG, "instance = " + this);

        Button button_start_lunch_single_task = (Button) findViewById(R.id.button_start_lunch_single_task);
        button_start_lunch_single_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity5.this, Activity6.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Activity5 onRestart " + this);
    }
}