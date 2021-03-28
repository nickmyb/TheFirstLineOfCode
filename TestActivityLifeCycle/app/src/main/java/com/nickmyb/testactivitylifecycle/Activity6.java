package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity6 extends BaseActivity {
    private static final String TAG = "SINGLETASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        Log.i(TAG, "Activity6 task id = " + getTaskId());
        Log.i(TAG, "instance = " + this);

        Button button_start_relunch_single_task = (Button) findViewById(R.id.button_start_relunch_single_task);
        button_start_relunch_single_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity6.this, Activity5.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity6 onDestroy " + this);
    }
}