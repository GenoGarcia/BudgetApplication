package com.example.geno.budgetapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
//-----------------------------------------------------
//
//		Fields
//
//-----------------------------------------------------
	protected Button budgetButton;
	protected TextView amount;
	protected TextView foodBudget;
	protected TextView shelterBudget;
	protected TextView utilitiesBudget;
	protected TextView clothingBudget;
	protected TextView transportationBudget;
	protected TextView medicalBudget;
	protected TextView personalBudget;
	protected TextView savingsBudget;

//-----------------------------------------------------
//
//		onCreate et al
//
//-----------------------------------------------------
	@Override //Main
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initializeElements();
		addActionHandlers();

	}

//-----------------------------------------------------
//
//		GUI
//
//-----------------------------------------------------
	//Match the fields to the GUI elements and give the elements any default values
	public void initializeElements() {
		budgetButton = (Button)findViewById(R.id.budgetButton);
		amount = (TextView) findViewById(R.id.amount);
		foodBudget = (TextView) findViewById(R.id.foodBudget);
		shelterBudget = (TextView) findViewById(R.id.shelterBudget);
		utilitiesBudget = (TextView) findViewById(R.id.utilitiesBudget);
		clothingBudget = (TextView) findViewById(R.id.clothingBudget);
		transportationBudget = (TextView) findViewById(R.id.transportationBudget);
		medicalBudget = (TextView) findViewById(R.id.medicalBudget);
		personalBudget = (TextView) findViewById(R.id.personalBudget);
		savingsBudget = (TextView) findViewById(R.id.savingsBudget);
	}

//-----------------------------------------------------
//
//		Logic
//
//-----------------------------------------------------

	public void addActionHandlers() {
        budgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!amount.getText().toString().equals("")) {

                    SharedPreferences prefs = getBaseContext().getSharedPreferences(
                            "Prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor sharedPref = prefs.edit();

					float food;
					float shelter;
					float utilities;
					float clothing;
					float transportation;
					float medical;
					float personal;
					float savings;

					try {
						food = Float.parseFloat(foodBudget.getText().toString());
					} catch (NumberFormatException e) {
						food = 0;
					}
					try {
						shelter = Float.parseFloat(shelterBudget.getText().toString());
					} catch (NumberFormatException e) {
						shelter = 0;
					}
					try {
						utilities = Float.parseFloat(utilitiesBudget.getText().toString());
					} catch (NumberFormatException e) {
						utilities = 0;
					}
					try {
						clothing = Float.parseFloat(clothingBudget.getText().toString());
					} catch (NumberFormatException e) {
						clothing = 0;
					}
					try {
						transportation = Float.parseFloat(transportationBudget.getText().toString());
					} catch (NumberFormatException e) {
						transportation = 0;
					}
					try {
						medical = Float.parseFloat(medicalBudget.getText().toString());
					} catch (NumberFormatException e) {
						medical = 0;
					}
					try {
						personal = Float.parseFloat(personalBudget.getText().toString());
					} catch (NumberFormatException e) {
						personal = 0;
					}
					try {
						savings = Float.parseFloat(savingsBudget.getText().toString());
					} catch (NumberFormatException e) {
						savings = 0;
					}

					sharedPref.putFloat("Payment", Float.parseFloat(amount.getText().toString()));
                    sharedPref.putFloat("Food", food);
                    sharedPref.putFloat("Shelter", shelter);
                    sharedPref.putFloat("Utilities", utilities);
                    sharedPref.putFloat("Clothing", clothing);
                    sharedPref.putFloat("Transportation", transportation);
                    sharedPref.putFloat("Medical", medical);
                    sharedPref.putFloat("Personal", personal);
                    sharedPref.putFloat("Savings", savings);
                    sharedPref.commit();

                    //Start next activity with an intent

					Intent i = new Intent(getBaseContext(), Summary.class);
					startActivity(i);

                }else{
                    Toast toast = Toast.makeText(getBaseContext(), "Please Enter Payment Amount", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
} //End Class