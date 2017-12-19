package com.codingblocks.inputoutput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etVar1, etVar2;
    Button btnAdd, btnSub, btnMult, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        btnAdd = findViewById(R.id.btnAdd);
        btnMult = findViewById(R.id.btnMult);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int a = 0;
        int b = 0;
        try {
            a = Integer.valueOf(etVar1.getText().toString());
            b = Integer.valueOf(etVar2.getText().toString());
        } catch (NumberFormatException nfe) {
            Toast.makeText(MainActivity.this,
                    "Inputs given were not valid numbers",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        int c = 0;

        try {
            switch(v.getId()) {
                case R.id.btnAdd:
                    c = a + b;
                    break;
                case R.id.btnSub:
                    c = a - b;
                    break;
                case R.id.btnMult:
                    c = a * b;
                    break;
                case R.id.btnDiv:
                    c = a / b;
                    break;
            }
            tvResult.setText(String.valueOf(c));
            // Send result to a new activity

            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("result", c);
            startActivity(i);

        } catch (ArithmeticException ae) {
            Toast.makeText(MainActivity.this,
                    "This operation is not possible",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
