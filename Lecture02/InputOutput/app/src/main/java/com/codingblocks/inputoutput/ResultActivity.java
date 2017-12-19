package com.codingblocks.inputoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int result = getIntent().getIntExtra("result", 0);

        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText(String.valueOf(result));

    }
}
