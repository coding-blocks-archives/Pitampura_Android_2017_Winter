package com.codingblocks.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DynamicFragmentActivity
        extends AppCompatActivity
        implements View.OnClickListener {
    FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        fragMan = getSupportFragmentManager();

        findViewById(R.id.btnBlue).setOnClickListener(this);
        findViewById(R.id.btnRed).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBlue:
                BlueFragment blueFrag = new BlueFragment();
                fragMan.beginTransaction()
                    .add(R.id.flContainer, blueFrag)
                    .commit();
                break;
            case R.id.btnRed:
                RedFragment redFrag = new RedFragment();
                fragMan.beginTransaction()
                        .add(R.id.flContainer, redFrag)
                        .commit();
                break;
        }
    }
}
