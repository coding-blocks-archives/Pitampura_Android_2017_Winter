package com.codingblocks.permissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivityWithPerman extends AppCompatActivity {
    public static final String TAG = "FILE";
    Button btnWriteFile, btnReadFile;
    TextView tvFileData;
    PermissionManager perMan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        perMan = new PermissionManager(this);

        btnWriteFile = findViewById(R.id.btnWriteFile);
        btnReadFile = findViewById(R.id.btnReadFile);
        tvFileData = findViewById(R.id.tvFileData);

        btnWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perMan.doWithPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        new PermissionManager.OnPermissionResult() {

                            @Override
                            public void onGranted(String permission) {
                                writeFile();
                            }

                            @Override
                            public void onDenied(String permission) {

                            }
                        });
            }
        });

        btnReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perMan.doWithPermission(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        new PermissionManager.OnPermissionResult() {

                            @Override
                            public void onGranted(String permission) {
                                tvFileData.setText(readFile());
                            }

                            @Override
                            public void onDenied(String permission) {

                            }
                        });
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
        perMan.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
