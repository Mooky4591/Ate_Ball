package com.example.ate_ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

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


    }
}