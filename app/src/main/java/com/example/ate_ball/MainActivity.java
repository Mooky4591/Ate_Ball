package com.example.ate_ball;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String Char;
    public Integer dist;
    public double lat;
    public double lon;
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//API: https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&key=AIzaSyABF2V9P8AcXW3iM_n7Wz--xIbVob5UIXg
//API_KEY: AIzaSyABF2V9P8AcXW3iM_n7Wz--xIbVob5UIXg
        Button findbttn;
        Spinner distancespin;
        final RadioGroup RG;


//initialize each component
        findbttn = (Button) findViewById(R.id.find_bttn);
        distancespin = (Spinner) findViewById(R.id.distance);
        RG = (RadioGroup) findViewById(R.id.priceGroup);


//Capturing a value on the change of radio buttons
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = RG.findViewById(checkedId);
                int index = RG.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        Char = "$";
                        Toast.makeText(getApplicationContext(), Char, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Char = "$$";
                        Toast.makeText(getApplicationContext(), Char, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Char = "$$$";
                        Toast.makeText(getApplicationContext(), Char, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Char = "$$$$";
                        Toast.makeText(getApplicationContext(), Char, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

//creating the spinner elements
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
//create the array adapter and drop down menu for the spinner
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distancespin.setAdapter(arrayAdapter);

//capturing the distance value when the selection changes
        distancespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dist = (int) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Selected: " + dist, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        findbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check for permission to access location service
                if (ContextCompat.checkSelfPermission(
                        getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_CODE_LOCATION_PERMISSION
                    );
                } else {
                    getCurrentLocation();
                }
                Toast.makeText(getApplicationContext(), "Selected price: " + Char + " Selected distance: " + dist + " Longitude: " + lon + " Latitude: " + lat, Toast.LENGTH_LONG).show();

            }

        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0) {
            getCurrentLocation();
        } else {
            Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
        }
    }

    void getCurrentLocation() {
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

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
        LocationServices.getFusedLocationProviderClient(MainActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(MainActivity.this)
                                .removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int latestLocationIndex = locationResult.getLocations().size() - 1;
                            lat = locationResult.getLocations().get(latestLocationIndex).getLatitude();
                            lon = locationResult.getLocations().get(latestLocationIndex).getLongitude();
                        }
                    }


                },  Looper.getMainLooper());
    }
}
