package com.codingblocks.camera.views;

import android.content.Context;
import android.hardware.Camera;
import android.support.v7.widget.AppCompatImageButton;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Context context;
    private Camera camera;
    private Display display;

    private boolean isPreviewEnabled = false;

    public CameraPreview(Context context, Camera camera, Display display) {
        super(context);
        this.context = context;
        this.camera = camera;
        this.display = display;
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            Camera.Parameters camParams = camera.getParameters();
            camParams.setPreviewSize(640, 480);
            camParams.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            camera.setParameters(camParams);

            camera.setPreviewDisplay(this.getHolder());

            switch (display.getRotation()) {
                case Surface.ROTATION_0:
                    camera.setDisplayOrientation(90);
                    break;
                case Surface.ROTATION_90:
                    camera.setDisplayOrientation(0);
                    break;
                case Surface.ROTATION_180:
                    camera.setDisplayOrientation(270);
                    break;
                case Surface.ROTATION_270:
                    camera.setDisplayOrientation(180);
                    break;
            }

            camera.startPreview();
            isPreviewEnabled = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.stopPreview();
        isPreviewEnabled = false;
        camera.release();
    }

    public boolean togglePreview () {
        if (isPreviewEnabled) {
            camera.stopPreview(); isPreviewEnabled = false;
        } else {
            camera.startPreview(); isPreviewEnabled = true;
        }
        return isPreviewEnabled;
    }

    public void takePhoto (Camera.PictureCallback pictureCallback) {
        if (camera != null || isPreviewEnabled) {
            camera.takePicture(null, null, pictureCallback);
        }
    }
}
