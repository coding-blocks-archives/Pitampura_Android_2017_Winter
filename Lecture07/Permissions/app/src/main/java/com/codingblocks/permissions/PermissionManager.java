package com.codingblocks.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by arnav on 12/28/2017.
 */

public class PermissionManager {
    private Activity activity;
    private ArrayList<OnPermissionResult> permissionHandlers = new ArrayList<>();

    public PermissionManager(Activity activity) {
        this.activity = activity;
    }

    public void doWithPermission (String[] permissions, OnPermissionResult opr) {
        int deniedPermissions = 0;
        for (String permission: permissions) {
            int perm = ContextCompat.checkSelfPermission(activity, permission);
            if (perm == PackageManager.PERMISSION_GRANTED) {
                opr.onGranted(permission);
            } else {
                deniedPermissions++;
            }
        }
        if (deniedPermissions > 0) {
            int requestCode = permissionHandlers.size();
            permissionHandlers.add(requestCode, opr);
            ActivityCompat.requestPermissions(
                    activity,
                    permissions,
                    requestCode
            );
        }

    }
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                permissionHandlers.get(requestCode).onGranted(permissions[i]);
            } else {
                permissionHandlers.get(requestCode).onDenied(permissions[i]);
            }
        }

        permissionHandlers.remove(requestCode);

    }

    interface OnPermissionResult {
        void onGranted(String permission);
        void onDenied(String permission);
    }


}
