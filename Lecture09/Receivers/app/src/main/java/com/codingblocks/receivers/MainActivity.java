package com.codingblocks.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FrameLayout flBackground;
    ChargerReceiver cr;
    IntentFilter chargeFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flBackground = findViewById(R.id.flBackground);

        cr = new ChargerReceiver();
        chargeFilter = new IntentFilter();
        chargeFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        chargeFilter.addAction(Intent.ACTION_POWER_CONNECTED);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(cr, chargeFilter);

    }

    @Override
    protected void onPause() {
        unregisterReceiver(cr);
        super.onPause();
    }

    class ChargerReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }

            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                flBackground.setBackgroundColor(Color.GREEN);
            }

            if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                flBackground.setBackgroundColor(Color.RED);
            }
        }
    }
}
