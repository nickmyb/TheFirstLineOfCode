package com.nickmyb.testactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buuton_activity_1 = (Button) findViewById(R.id.button_activity_1);
        buuton_activity_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                startActivity(intent);
            }
        });

        Button buuton_activity_2 = (Button) findViewById(R.id.button_activity_2);
        buuton_activity_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 没有添加android.intent.category.DEFAULT的Activity是永远无法被匹配到的
                Intent intent = new Intent("com.nickmyb.testactivity.ACTION_START");
                startActivity(intent);
            }
        });

        Button buuton_activity_3 = (Button) findViewById(R.id.button_activity_3);
        buuton_activity_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.nickmyb.testactivity.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }
        });

        // 自定义的category也首先需要添加android.intent.category.DEFAULT,否则无法匹配
        Button buuton_activity_4 = (Button) findViewById(R.id.button_activity_4);
        buuton_activity_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.nickmyb.testactivity.ACTION_START");
                intent.addCategory("com.nickmyb.testactivity.MY_CATEGORY");
                startActivity(intent);
            }
        });

//        buuton_activity_1.setVisibility(View.INVISIBLE);
//        buuton_activity_2.setVisibility(View.INVISIBLE);
//        buuton_activity_3.setVisibility(View.INVISIBLE);
    }
}