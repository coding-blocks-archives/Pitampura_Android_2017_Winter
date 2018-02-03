package com.codingblocks.camera.views;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Context context;
    private Camera camera;

    private boolean isPreviewEnabled = false;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.context = context;
        this.camera = camera;
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            Camera.Parameters camParams = camera.getParameters();
            camParams.setPreviewSize(640, 480);
            camera.setParameters(camParams);

            camera.setPreviewDisplay(this.getHolder());

            camera.setDisplayOrientation(90);
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
}
