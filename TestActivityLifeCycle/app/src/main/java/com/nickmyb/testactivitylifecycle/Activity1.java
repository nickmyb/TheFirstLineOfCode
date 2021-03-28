package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button button_start_main = (Button) findViewById(R.id.button_start_main);
        button_start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, MainActivity.class);
                // 这里新开的MainActivity back之后会调用onDestroy
                startActivity(intent);
            }
        });
    }
}