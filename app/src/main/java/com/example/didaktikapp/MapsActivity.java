package com.example.didaktikapp;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {
    CameraPosition cameraPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //map.setMinZoomPreference(25.0f);
       // map.setMaxZoomPreference(25.0f);
        map.getUiSettings().setCompassEnabled(false);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this, R.raw.mapa_noche);
        map.setMapStyle(mapStyleOptions);
        cameraPosition= new CameraPosition.Builder()
                //.target(new LatLng(43.318930, -3.071035))
                .target(new LatLng(43.311472, -3.070639))
                .zoom(20)
                .tilt(40)
                .bearing(20)
                .build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //Marcas de cada uno de los eventos
        LatLng zugaztieta = new LatLng(43.284306, -3.054611);
        map.addMarker(new MarkerOptions()
                .position(zugaztieta)
                //.title("Marca de zugaztieta")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        LatLng conchaMeategia = new LatLng(43.309194, -3.073000);
        map.addMarker(new MarkerOptions()
                .position(conchaMeategia)
                //.title("Marca de la mina de Concha")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        LatLng meatzaritzarenMuseoa = new LatLng(43.311556, -3.070583);
        map.addMarker(new MarkerOptions()
                .position(meatzaritzarenMuseoa)
                //.title("Marca del museo de la mineria")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        LatLng garraioa = new LatLng(43.311472, -3.070639);
        map.addMarker(new MarkerOptions()
                .position(garraioa)
                //.title("Marca del transporte")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        LatLng areilzaDoktorea = new LatLng(43.315778, -3.072722);
        map.addMarker(new MarkerOptions()
                .position(areilzaDoktorea)
                //.title("Marca del doctor Areilza")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        LatLng laPasionaria = new LatLng(43.316806, -3.074694);
        map.addMarker(new MarkerOptions()
                .position(laPasionaria)
                //.title("Marca de la Pasionaria")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        LatLng allIron = new LatLng(43.320194, -3.070806);
        map.addMarker(new MarkerOptions()
                .position(allIron)
                //.title("Marca de all Iron")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marca)));

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker m) {
                String marca = m.getId();

                CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                        m.getPosition(), 10.0f);
                map.animateCamera(location);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MapsActivity.this, DialogoActivity.class);

                        switch (marca)
                        {
                            case "m0":
                                intent.putExtra("marca", "Zugaztieta");
                                break;

                            case "m1":
                                intent.putExtra("marca", "MinaConcha");
                                break;

                            case "m2":
                                intent.putExtra("marca", "MuseoMineria");
                                break;

                            case "m3":
                                intent.putExtra("marca", "Transporte");
                                break;

                            case "m4":
                                intent.putExtra("marca", "DoctorAreilza");
                                break;

                            case "m5":
                                intent.putExtra("marca", "Pasionaria");
                                break;

                            case "m6":
                                intent.putExtra("marca", "AllIron");
                                break;
                        }
                        startActivity(intent);
                    }
                }, 700);

                return false;
            }

        });

        map.setOnMyLocationButtonClickListener(this);
        map.setOnMyLocationClickListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {}
        map.setMyLocationEnabled(true);
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }
}