package com.nickmyb.testui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);

        Button alert_dialog = (Button) findViewById(R.id.alert_dialog);
        Button progress_dialog = (Button) findViewById(R.id.progress_dialog);
        alert_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder((TestDialog.this));
                dialog.setTitle("AlertDialog");
                dialog.setMessage("content");
                dialog.setCancelable(false);
                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestDialog.this, "NO USE", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });
        progress_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(TestDialog.this);
                dialog.setTitle("ProgressDialog");
                dialog.setMessage("Loading...");
                dialog.setCancelable(true);
                dialog.show();
            }
        });
    }
}