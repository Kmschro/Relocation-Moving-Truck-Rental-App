package com.example.relocationmovingtruckrentalapp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class cost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        TextView result = (TextView) findViewById(R.id.result);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intMiles = sharedPref.getInt("key1", 0);
        int truckCost = sharedPref.getInt("key2", 0);
        double cost = (intMiles * 0.99) + truckCost;
        result.setText("Your Body Mass Index is " + cost);
    }
}