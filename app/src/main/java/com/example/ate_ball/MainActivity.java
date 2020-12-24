package com.example.ate_ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button findbttn;
        Spinner distancespin;
        RadioButton $, $$, $$$, $$$$;


//initialize each component
        findbttn = (Button) findViewById(R.id.find_bttn);
        distancespin = (Spinner) findViewById(R.id.distance);
        $ = (RadioButton) findViewById(R.id.one_dollar);
        $$ = (RadioButton) findViewById(R.id.two_dollars);
        $$$ = (RadioButton) findViewById(R.id.three_dollars);
        $$$$ = (RadioButton) findViewById(R.id.four_dollars);

//creating the spinner elements
        ArrayList<String> list = new ArrayList<>();
        list.add("5 miles");
        list.add("10 miles");
        list.add("15 miles");
        list.add("20 miles");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distancespin.setAdapter(arrayAdapter);
        distancespin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }
}