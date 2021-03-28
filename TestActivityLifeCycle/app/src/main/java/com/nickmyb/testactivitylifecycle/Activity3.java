package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {
    private static final String TAG = "STANDARD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "task id = " + getTaskId());
        Log.i(TAG, "instance = " + this);
        setContentView(R.layout.activity_3);

        Button button_start_lunch_standard = (Button) findViewById(R.id.button_start_lunch_standard);
        button_start_lunch_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, Activity3.class);
                startActivity(intent);
            }
        });
    }
}