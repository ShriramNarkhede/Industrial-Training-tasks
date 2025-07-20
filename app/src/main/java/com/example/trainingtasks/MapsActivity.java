package com.example.trainingtasks;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trainingtasks.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Button normal,satellite,hybrid,terrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        normal=findViewById(R.id.normal);
        satellite=findViewById(R.id.satellite);
        hybrid=findViewById(R.id.hybrid);
        terrain=findViewById(R.id.terrain);


        terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng my_location = new LatLng(20.6999436375935, 77.00827796541454);
        mMap.addMarker(new MarkerOptions().position(my_location).title("Marker on Akola"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(my_location));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(my_location,19),5000,null);
        mMap.addCircle(new CircleOptions()
                .center(my_location)
                .fillColor(Color.parseColor("#508DCDF4"))
                .strokeWidth(Color.TRANSPARENT)
                .radius(50)
        );
        MarkerOptions markerOptions = new MarkerOptions();
        LatLng akola = new  LatLng(20.720740074167896, 77.02958832364742);
        markerOptions.position(akola);
        markerOptions.title("Marker on Shri Dawale College,Akola");
        mMap.addMarker(markerOptions);

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(20.6999436375935, 77.00827796541454),
                        new LatLng(20.720790248419718, 77.02966342550054))

                .width(5).color(Color.BLUE).geodesic(true));
    }




}