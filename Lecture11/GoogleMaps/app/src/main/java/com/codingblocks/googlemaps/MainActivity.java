package com.codingblocks.googlemaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "LOC";

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locLis = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(TAG, "onLocationChanged: latitude = " + location.getLatitude());
                Log.d(TAG, "onLocationChanged: longitude = " + location.getLongitude());
                Log.d(TAG, "onLocationChanged: altitude = " + location.getAltitude());
                Log.d(TAG, "onLocationChanged: accuracy = " + location.getAccuracy());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        locMan.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                1000,
                10,
                locLis

        );

    }
}
