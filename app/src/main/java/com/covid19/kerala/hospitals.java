package com.covid19.kerala;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class hospitals extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;
    private FusedLocationProviderClient fusedLocationClient;
    LocationRequest mLocationRequest;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(180000);
        mLocationRequest.setFastestInterval(90000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);

        // Test Center 1
        final LatLng center1 = new LatLng(11.456989, 75.806558);
        mMap.addMarker(new MarkerOptions().position(center1).title("AZA Diagnostic Centre, Kozhikode, Kerala").snippet("Phone Number: 096457 71188"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center1));

        //Test Center 2
        final LatLng center2 = new LatLng(11.552279, 75.960367);
        mMap.addMarker(new MarkerOptions().position(center2).title("MVR Cancer Centre & Research Institute, Poolacode, Kerala").snippet("Phone Number: 0495 228 9500"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center2));

        //Test Center 3
        final LatLng center3 = new LatLng(11.505898, 75.751626);
        mMap.addMarker(new MarkerOptions().position(center3).title("Aster MIMS Laboratory Services, Kozhikode, Kerala").snippet("Phone Number: 0495 248 8000"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center3));

        //Test Center 4
        final LatLng center4 = new LatLng(11.206132, 76.611062);
        mMap.addMarker(new MarkerOptions().position(center4).title("Government Medical College, Palakkad, Kerala").snippet("Phone Number: 0491 297 4125"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center4));

        //Test Center 5
        final LatLng center5 = new LatLng(11.562801, 75.751626);
        mMap.addMarker(new MarkerOptions().position(center5).title("Aswini Diagnostic Services, Kozhikode, Kerala").snippet("Phone Number: 0495 270 3250"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center5));

        //Test Center 6
        final LatLng center6 = new LatLng(11.363866, 76.655008);
        mMap.addMarker(new MarkerOptions().position(center6).title("Dane Diagnostics Laboratory, Palakkad, Kerala").snippet("Phone Number: 0491 253 9366"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center6));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(6));

        //Test Center 7
        final LatLng center7 = new LatLng(11.447469, 75.775451);
        mMap.addMarker(new MarkerOptions().position(center7).title("Micro Health Laboratories, Kozhikode, Kerala").snippet("Phone Number: 04952743"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center7));

        //Test Center 8
        final LatLng center8 = new LatLng(12.056012, 76.015306);
        mMap.addMarker(new MarkerOptions().position(center8).title("District Public Health Laboratory, Wayanad, Mananthavady, Kerala"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center8));

        //Test Center 9
        final LatLng center9 = new LatLng(11.539633, 75.795572);
        mMap.addMarker(new MarkerOptions().position(center9).title("Medical College, Kozhikode, Kerala").snippet("Phone Number: 0495 235 0216"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center9));

        //Test Center 10
        final LatLng center10 = new LatLng(11.301084, 76.545145);
        mMap.addMarker(new MarkerOptions().position(center10).title("District TB Centre, Palakkad, Kerala"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center10));

        //Test Center 11
        final LatLng center11 = new LatLng(11.627342, 76.109211);
        mMap.addMarker(new MarkerOptions().position(center11).title("Government Medical College, Manjeri, Kerala").snippet("Phone Number: 0483 276 4056"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center11));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker.getPosition().equals(center1)) {
                    Uri uriUrl = Uri.parse("http://www.azadiagnostics.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center2)) {
                    Uri uriUrl = Uri.parse("http://www.mvrcancerhospital.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

                else if(marker.getPosition().equals(center3)) {
                    Uri uriUrl = Uri.parse("https://astermims.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center4)) {
                    Uri uriUrl = Uri.parse("http://www.gmcpalakkad.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center5)) {
                    Uri uriUrl = Uri.parse("https://www.aswinicalicut.net/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center6)) {
                    Uri uriUrl = Uri.parse("http://dane-diagnostics.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center7)) {
                    Uri uriUrl = Uri.parse("http://www.microhealthcare.com/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center9)) {
                    Uri uriUrl = Uri.parse("https://www.govtmedicalcollegekozhikode.ac.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            }
        });

    }

    LocationCallback mLocationCallback=new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location1 : locationResult.getLocations()) {
                if (getApplicationContext() != null) {
                    mLastLocation = location1;
                    latLng = new LatLng(location1.getLatitude(), location1.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
                }
            }

        }
    };
    public void onBackPressed(){
        Intent intent = new Intent(hospitals.this, home.class);
        startActivity(intent);
        finish();
    };
}
