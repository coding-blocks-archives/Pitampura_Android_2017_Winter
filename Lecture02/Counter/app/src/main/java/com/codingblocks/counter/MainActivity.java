package com.codingblocks.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
        Log.d(TAG, "onCreate is called");
        Log.e(TAG, "onCreate: ");
        Log.w(TAG, "onCreate: ");
        Log.i(TAG, "onCreate: ");
//        Log.wtf(TAG,"onCrreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    public void increment(View view) {
        TextView tv = findViewById(R.id.textView);
        EditText et1 = findViewById(R.id.editText1);
        EditText et2 = findViewById(R.id.editText2);

        String input1 = et1.getText().toString();
        String input2 = et2.getText().toString();

        Integer firstInput = Integer.valueOf(input1);
        Integer secondInpit = Integer.valueOf(input2);

        Integer result = firstInput + secondInpit;

        tv.setText(""+result);

        Log.e(TAG, "increment: ");

    }
}
