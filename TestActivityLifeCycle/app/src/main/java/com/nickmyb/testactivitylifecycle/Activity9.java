package com.nickmyb.testactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity9 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        Button button_exit = (Button) findViewById(R.id.button_exit);
        Button button_add_exit = (Button) findViewById(R.id.button_add_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.exit();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        button_add_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity9.this, Activity9.class);
                startActivity(intent);
            }
        });
    }

    public static void startActivity9(Context context, String param) {
        Intent intent = new Intent(context, Activity9.class);
        intent.putExtra("param", param);
        context.startActivity(intent);
    }
}