package com.nickmyb.testui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.main_edit_text);
        button = (Button) findViewById(R.id.main_button);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    startUIActivity();
                    return true;
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startUIActivity();
            }
        });
    }

    private void startUIActivity() {
        String UIClassName = editText.getText().toString();
        try {
            Class UIClass = Class.forName("com.nickmyb.testui.Test" + UIClassName);
            Intent intent = new Intent(MainActivity.this, UIClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            Toast.makeText(MainActivity.this, UIClassName + " NOT FOUND", Toast.LENGTH_LONG).show();
        }
    }
}