package com.codingblocks.intents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etVar1, etVar2;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(etVar1.getText().toString());
                int b = Integer.valueOf(etVar1.getText().toString());
                int c = a + b;

                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(i);
            }
        });

    }
}
