package com.nickmyb.testui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class TestProgressBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_bar);

        Button progress_bar_button = (Button) findViewById(R.id.progress_bar_button);
        ProgressBar progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        progress_bar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progress_bar.getProgress();
                progress += 20;
                if (progress >= 100) {
                    progress_bar.setVisibility(View.INVISIBLE);
                } else {
                    progress_bar.setProgress(progress);
                }
            }
        });
    }
}