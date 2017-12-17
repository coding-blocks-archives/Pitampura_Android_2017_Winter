package com.codingblocks.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etPhone, etEmail;
    Button btnDial, btnSendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        btnDial = findViewById(R.id.btnDial);
        btnSendMail = findViewById(R.id.btnSendMail);
        btnDial.setOnClickListener(this);
        btnSendMail.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDial:
                Intent i1 = new Intent(Intent.ACTION_DIAL);
                String telString = "tel:" + etPhone.getText().toString();
                i1.setData(Uri.parse(telString));
                startActivity(i1);
                break;
            case R.id.btnSendMail:
                Intent i2 = new Intent(Intent.ACTION_SENDTO);
                String mailtoString = "mailto:" + etEmail.getText().toString();
                i2.setData(Uri.parse(mailtoString));
                startActivity(i2);
                break;
        }
    }
}
