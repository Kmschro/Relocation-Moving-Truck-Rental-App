package com.example.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    int intMiles;
    double truckCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText miles = (EditText)findViewById(R.id.miles);
        RadioButton button1= (RadioButton) findViewById(R.id.rdb1);
        RadioButton button2= (RadioButton) findViewById(R.id.rdb2);
        RadioButton button3= (RadioButton) findViewById(R.id.rdb3);
        Button button = (Button)findViewById(R.id.button);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intMiles = Integer.parseInt(miles.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                if (button1.isChecked()){
                    truckCost = 19.95;
                }
                else if (button2.isChecked()){
                    truckCost = 29.95;
                }else if (button3.isChecked()){
                    truckCost = 39.95;
                }
                editor.putInt("key1", intMiles);
                editor.putInt("key2", (int) truckCost);
                editor.commit();
                startActivity(new Intent(MainActivity.this, cost.class));
            }
        });
    }
}