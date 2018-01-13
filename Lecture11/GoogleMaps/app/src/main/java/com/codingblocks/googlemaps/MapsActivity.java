package com.codingblocks.googlemaps;

import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        Double cbLat = 28.6969421;
        Double cbLng = 77.1423825;
        LatLng codingBlocks = new LatLng(cbLat, cbLng);
        PolygonOptions cbRect = new PolygonOptions()
                .strokeColor(Color.RED)
                .fillColor(Color.argb(100, 200, 100, 100))
                .add(new LatLng(cbLat - 0.01, cbLng - 0.01))
                .add(new LatLng(cbLat - 0.01, cbLng + 0.01))
                .add(new LatLng(cbLat + 0.01, cbLng + 0.01))
                .add(new LatLng(cbLat + 0.01, cbLng - 0.01));
        float[] dist = new float[3];
        Location.distanceBetween(
                cbLat, cbLng,
                cbLat + 0.01, cbLng + 0.01,
                dist
        );
        float distanceInMetres = dist[0];
        mMap.addMarker(new MarkerOptions().position(codingBlocks).title("Coding Blocks"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(codingBlocks, 15));
        mMap.addPolygon(cbRect);

    }
}
