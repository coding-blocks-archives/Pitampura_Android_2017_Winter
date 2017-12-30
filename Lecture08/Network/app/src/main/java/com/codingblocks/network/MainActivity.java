package com.codingblocks.network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ASYNC";
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int countUpto = Integer.valueOf(editText.getText().toString());
                MyAsyncTask task = new MyAsyncTask();
                task.execute(countUpto);
            }
        });
    }

    class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute: ");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int countUpto = 0;
            if (integers.length > 0) countUpto = integers[0];

            for (int i = 0; i < countUpto; i++) {
                waitAsec();
                publishProgress(i+1);
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            textView.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            textView.setText("DONE");
            super.onPostExecute(aVoid);
        }

    }

    void waitAsec () {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 1000;
        while (System.currentTimeMillis() < endTime);
    }
}
