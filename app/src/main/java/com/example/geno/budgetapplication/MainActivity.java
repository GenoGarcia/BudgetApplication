package com.example.geno.budgetapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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

                    sharedPref.putFloat("Payment", Float.parseFloat(amount.getText().toString()));
                    sharedPref.putFloat("Food", Float.parseFloat(foodBudget.getText().toString()));
                    sharedPref.putFloat("Shelter", Float.parseFloat(shelterBudget.getText().toString()));
                    sharedPref.putFloat("Utilities", Float.parseFloat(utilitiesBudget.getText().toString()));
                    sharedPref.putFloat("Clothing", Float.parseFloat(clothingBudget.getText().toString()));
                    sharedPref.putFloat("Transportation", Float.parseFloat(transportationBudget.getText().toString()));
                    sharedPref.putFloat("Medical", Float.parseFloat(medicalBudget.getText().toString()));
                    sharedPref.putFloat("Personal", Float.parseFloat(personalBudget.getText().toString()));
                    sharedPref.putFloat("Savings", Float.parseFloat(savingsBudget.getText().toString()));
                    sharedPref.commit();

                    //Start next activity with an intent

                }else{
                    Toast toast = Toast.makeText(getBaseContext(), "Please Enter Payment Amount", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
} //End Class