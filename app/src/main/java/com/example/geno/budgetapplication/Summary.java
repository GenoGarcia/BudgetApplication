package com.example.geno.budgetapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class Summary extends ActionBarActivity {

    protected TextView total;
    protected TextView food;
    protected TextView shelter;
    protected TextView utilities;
    protected TextView clothing;
    protected TextView transportation;
    protected TextView medical;
    protected TextView personal;
    protected TextView savings;
    protected TextView extra;

    public void initializeElements() {
        total = (TextView) findViewById(R.id.total);
        food = (TextView) findViewById(R.id.food);
        shelter = (TextView) findViewById(R.id.shelter);
        utilities = (TextView) findViewById(R.id.utilities);
        clothing = (TextView) findViewById(R.id.clothing);
        transportation = (TextView) findViewById(R.id.transportation);
        medical = (TextView) findViewById(R.id.medical);
        personal = (TextView) findViewById(R.id.personal);
        savings = (TextView) findViewById(R.id.savings);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        initializeElements();
        SharedPreferences sharedPref = getBaseContext().getSharedPreferences("Prefs", Context.MODE_PRIVATE);

        total.setText("Paycheck Amount: " + sharedPref.getFloat("Payment", 0));
        food.setText("Food: " + sharedPref.getFloat("Food", 0));
        shelter.setText("Shelter: " + sharedPref.getFloat("Shelter", 0));
        utilities.setText("Utilities: " + sharedPref.getFloat("Utilities", 0));
        clothing.setText("Clothing: " + sharedPref.getFloat("Clothing", 0));
        transportation.setText("Transportation: " + sharedPref.getFloat("Transportation", 0));
        medical.setText("Medical: " + sharedPref.getFloat("Medical", 0));
        personal.setText("Personal: " + sharedPref.getFloat("Personal", 0));
        savings.setText("Savings: " + sharedPref.getFloat("Savings", 0));
        extra.setText("Extra: " + sharedPref.getFloat("Extra", 0));
    }
}