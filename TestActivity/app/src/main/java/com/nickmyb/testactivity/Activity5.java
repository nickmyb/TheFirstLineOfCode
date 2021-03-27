package com.nickmyb.testactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        Toast.makeText(this, "get data from activity4 = " + data, Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button_activity_5_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data", "5");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data", "55");
        setResult(RESULT_OK, intent);
        finish();
    }
}