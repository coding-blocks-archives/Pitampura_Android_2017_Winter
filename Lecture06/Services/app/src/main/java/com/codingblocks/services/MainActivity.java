package com.codingblocks.services;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        final RelativeLayout rlBackground = findViewById(R.id.rlBackground);

        final Handler h = new Handler();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlBackground.setBackgroundColor(
                        Color.rgb(
                                r.nextInt(255),
                                r.nextInt(255),
                                r.nextInt(255)
                        )
                );
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("HELLO");
                    }
                };
                h.postDelayed(r, 10000);

            }
        });
    }
}
