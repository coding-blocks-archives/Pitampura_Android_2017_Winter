package com.codingblocks.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by arnav on 12/24/2017.
 */

public class MyIntentService extends IntentService {
    public static final String TAG = "ISRVC";

    public MyIntentService() {
        super("MYSERVICE");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() < start + 10000);
        Log.d(TAG, "onHandleIntent: wait is over");
    }
}
