package com.nickmyb.testui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TestImageView extends AppCompatActivity {
    private int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_image_view);

        Button image_view_button = (Button) findViewById(R.id.image_view_button);
        ImageView image_view = (ImageView) findViewById(R.id.image_view);
        image_view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n += 1;
                if (n % 2 == 1) {
                    image_view.setImageResource(R.drawable.image1);
                } else {
                    image_view.setImageResource(R.drawable.image2);
                }

            }
        });
    }
}