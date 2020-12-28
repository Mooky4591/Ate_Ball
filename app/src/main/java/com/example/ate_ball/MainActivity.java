package com.example.ate_ball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public String Char;
    public Integer dist;
    public double lat;
    public double lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//API: https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&key=AIzaSyABF2V9P8AcXW3iM_n7Wz--xIbVob5UIXg

        Button findbttn;
        Spinner distancespin;
        final RadioGroup RG;
        LocationManager locationManager;


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
        switch (index){
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
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        findbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selected price: " + Char + " Selected distance: " + dist + " Longitude: " + getLong() + " Latitude: " + getLat(), Toast.LENGTH_LONG).show();
            }
        });

        //Creating location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
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
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);

    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
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

    public double getLat(){
        return lat;
    }

    public double getLong(){
        return lng;
    }
}