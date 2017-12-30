package com.codingblocks.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                new MyAsyncTask(
                        new MyAsyncTask.MyAsyncTaskListener() {
                            @Override
                            public void onProgressUpdate(Integer progress) {
                                textView.setText(String.valueOf(progress));
                            }

                            @Override
                            public void onPostExecute() {
                                textView.setText("DONE");
                            }
                        })
                        .execute(countUpto);
            }
        });
    }

    static void waitAsec () {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 1000;
        while (System.currentTimeMillis() < endTime);
    }
}
