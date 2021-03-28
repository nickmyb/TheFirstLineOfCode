package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity8 extends BaseActivity {
    private static final String TAG = "SINGLEINSTANCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);
        Log.i(TAG, "task id = " + getTaskId());
        Log.i(TAG, "instance = " + this);

        Button button_new_activity_7 = (Button) findViewById(R.id.button_new_activity_7);
        button_new_activity_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity8.this, Activity7.class);
                startActivity(intent);
            }
        });
    }
}