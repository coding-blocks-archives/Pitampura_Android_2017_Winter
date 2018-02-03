package com.codingblocks.camera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.codingblocks.camera.views.CameraPreview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Camera.PictureCallback {
    public static final String TAG = "CAM";
    FrameLayout flCamPreviewContainer;
    View btnPreview, btnPhoto;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                flCamPreviewContainer = findViewById(R.id.flCamPreviewContainer);
        btnPreview = findViewById(R.id.btnPreview);
        btnPhoto = findViewById(R.id.btnPhoto);

        int camPerm = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);
        int storagePerm = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (camPerm == PackageManager.PERMISSION_DENIED ||
                storagePerm == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[] {
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.CAMERA
                    },
                    112
            );
        } else {
            camera = Camera.open();
            if (camera != null) {
                Log.d(TAG, "onCreate: We have the camera");
                List<Camera.Size> picSizes = camera.getParameters()
                        .getSupportedPictureSizes();
                for (Camera.Size picSize: picSizes ) {
                    Log.d(TAG, "Size: " + picSize.width + "x" + picSize.height);
                }

                picSizes = camera.getParameters().getSupportedPreviewSizes();
                for (Camera.Size picSize: picSizes ) {
                    Log.d(TAG, "Preview Size: " + picSize.width + "x" + picSize.height);
                }

                final CameraPreview camPrev = new CameraPreview(
                        this,
                        camera,
                        getWindowManager().getDefaultDisplay());

                flCamPreviewContainer.addView(camPrev);

                btnPreview.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                boolean newState = camPrev.togglePreview();
                                Toast.makeText(
                                        MainActivity.this,
                                        "Preview " + (newState ? "enabled" : "disabled"),
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                );

                btnPhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        camPrev.takePhoto(MainActivity.this);
                    }
                });
            }
        }

    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        try {
            File dcimDir =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File ourDir = new File(dcimDir, "CBCAM");
            if (!ourDir.exists()) {
                ourDir.mkdir();
            }
            String photoName = "CB" + System.currentTimeMillis() + ".jpg";
            File photo = new File(ourDir, photoName);
            FileOutputStream fos = new FileOutputStream(photo);
            fos.write(data);
            fos.close();
            // To Scan photo
            sendBroadcast(new Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse(photo.getAbsolutePath())
            ));

            // To open photo
            String type = MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpg");
            Intent photoOpenIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(photo.getAbsolutePath())
            );
            photoOpenIntent.setType(type);
            startActivity(photoOpenIntent);
        } catch (IOException ioe) {
            Log.e(TAG, "onPictureTaken: Could not save photo", ioe);
        } finally {
            camera.startPreview();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        camera.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        camera.stopPreview();

    }
}
