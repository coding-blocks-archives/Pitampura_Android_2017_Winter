package com.codingblocks.network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ShowUrlDataActivity extends AppCompatActivity {
    EditText etUrl;
    Button btnShow;
    TextView tvContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_url_data);

        etUrl = findViewById(R.id.etUrl);
        btnShow = findViewById(R.id.btnShow);
        tvContents = findViewById(R.id.tvContents);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlString = etUrl.getText().toString();
                try {
                    URL url = new URL(urlString);
                    new DownloadUrlTask().execute(url);
                } catch (MalformedURLException e) {
                    Toast.makeText(ShowUrlDataActivity.this, "Wrong URL format", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
    
    class DownloadUrlTask extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            try {
                HttpsURLConnection connection = (HttpsURLConnection) urls[0].openConnection();
                if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300 ) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream())
                    );
                    StringBuilder sb = new StringBuilder();
                    String buf = br.readLine();
                    while (buf != null) {
                        sb.append(buf);
                        buf = br.readLine();
                    }
                    return sb.toString();
                }
            }  catch (IOException e) {
                Toast.makeText(ShowUrlDataActivity.this, "Could not connect", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvContents.setText(Html.fromHtml(s));
        }
    }
}
