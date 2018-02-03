package com.codingblocks.camera;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.codingblocks.camera.views.CameraPreview;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "CAM";
    FrameLayout flCamPreviewContainer;
    Button btnPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flCamPreviewContainer = findViewById(R.id.flCamPreviewContainer);
        btnPreview = findViewById(R.id.btnPreview);

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
            Camera camera = Camera.open();
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

                final CameraPreview camPrev = new CameraPreview(this, camera);
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
            }
        }

    }
}
