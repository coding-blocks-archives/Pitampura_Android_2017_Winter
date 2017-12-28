package com.codingblocks.permissions;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "FILE";
    Button btnWriteFile, btnReadFile;
    TextView tvFileData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWriteFile = findViewById(R.id.btnWriteFile);
        btnReadFile = findViewById(R.id.btnReadFile);
        tvFileData = findViewById(R.id.tvFileData);

        btnWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int perm = ContextCompat.checkSelfPermission(
                        MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);

                if (perm == PackageManager.PERMISSION_GRANTED) {
                    writeFile();
                } else {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            44
                    );
                }
            }
        });

        btnReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int perm = ContextCompat.checkSelfPermission(
                        MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE);

                if (perm == PackageManager.PERMISSION_GRANTED) {
                    tvFileData.setText(readFile());
                } else {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                            45
                    );
                }
            }
        });
    }

    void writeFile () {
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File helloTxt = new File(sdCard, "hello.txt");
            FileOutputStream foutStream = new FileOutputStream(helloTxt, true);
            foutStream.write("Hello World".getBytes());
        } catch (IOException ioe) {
            Log.e(TAG, "writeFile: ", ioe);
        }
    }

    String readFile() {
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File helloTxt = new File(sdCard, "hello.txt");
            FileInputStream finStream = new FileInputStream(helloTxt);
            BufferedReader br = new BufferedReader(new InputStreamReader(finStream));
            StringBuilder sb = new StringBuilder("");
            String buf = br.readLine();
            while (buf != null) {
                sb.append(buf);
                sb.append("\n");
                buf = br.readLine();
            }
            return sb.toString();
        } catch (IOException ioe) {
            Log.e(TAG, "readFile: ", ioe);
            return "";
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == 44) { //write request
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                writeFile();
            } else {
                Toast.makeText(this, "Writing file required this permission", Toast.LENGTH_SHORT).show();

            }
        }

        if (requestCode == 45) { //read request
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                tvFileData.setText(readFile());
            } else {
                Toast.makeText(this, "Reading file required this permission", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("We need this permission to read the file.\n" +
                                "Please allow this permission")
                        .setPositiveButton("GIVE PERMISSION", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(
                                        MainActivity.this,
                                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                                        45
                                );
                            }
                        })
                        .setNegativeButton("NO THANKS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Sigh! I tried", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .show();
            }
        }
    }
}
