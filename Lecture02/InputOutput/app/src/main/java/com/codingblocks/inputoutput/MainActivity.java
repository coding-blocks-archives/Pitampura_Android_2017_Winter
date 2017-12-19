package com.codingblocks.inputoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etVar1, etVar2;
    Button btnAdd;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        btnAdd = findViewById(R.id.btnAdd);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int a = Integer.valueOf(etVar1.getText().toString());
                    int b = Integer.valueOf(etVar2.getText().toString());
                    int c = a + b;
                    Log.d("ADD", "Result is = " + c);
                    tvResult.setText(String.valueOf(c));
                } catch (NumberFormatException nfe) {
                    Toast.makeText(MainActivity.this,
                            "Inputs given were not valid numbers",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
