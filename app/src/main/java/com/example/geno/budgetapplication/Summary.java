package com.example.geno.budgetapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Summary extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        sharedPref.setText(amount.getText().toString() + " " + foodBudget);
        sharedPref.setText(amount.getText().toString() + " " + shelterBudget);
        sharedPref.setText(amount.getText().toString() + " " + utilitiesBudget);
        sharedPref.setText(amount.getText().toString() + " " + clothingBudget);
        sharedPref.setText(amount.getText().toString() + " " + transportationBudget);
        sharedPref.setText(amount.getText().toString() + " " + MedicalBudget);
        sharedPref.setText(amount.getText().toString() + " " + personalBudget);
        sharedPref.setText(amount.getText().toString() + " " + savingsBudget);
        //pull values from shared prefs using names and supplying default values to use if the specified values aren't in the shared prefs
        //BreakAway in main Activity where they pull from sharedprefs
    }

}
