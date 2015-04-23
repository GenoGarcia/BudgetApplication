package com.example.geno.budgetapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
		extra = (TextView) findViewById(R.id.extra);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);

		initializeElements();
		SharedPreferences sharedPref = getBaseContext().getSharedPreferences("Prefs", Context.MODE_PRIVATE);

		float totalValue = sharedPref.getFloat("Payment", 0);
		float foodValue = sharedPref.getFloat("Food", 0);
		float shelterValue = sharedPref.getFloat("Shelter", 0);
		float utilitiesValue = sharedPref.getFloat("Utilities", 0);
		float clothingValue = sharedPref.getFloat("Clothing", 0);
		float transportationValue = sharedPref.getFloat("Transportation", 0);
		float medicalValue = sharedPref.getFloat("Medical", 0);
		float personalValue = sharedPref.getFloat("Personal", 0);
		float savingsValue = sharedPref.getFloat("Savings", 0);
		float extraValue = totalValue - (foodValue + shelterValue + utilitiesValue + clothingValue +
				transportationValue + medicalValue + personalValue + savingsValue);

		String foodString = "$" + foodValue + "                          %" + ((int) (foodValue / totalValue * 100));
		String shelterString = "$" + shelterValue + "                      %" + ((int) (shelterValue / totalValue * 100));
		String utilitiesString = "$" + utilitiesValue + "                     %" + ((int) (utilitiesValue / totalValue * 100));
		String clothingString = "$" + clothingValue + "                      %" + ((int) (clothingValue / totalValue * 100));
		String transportationString = "$" + transportationValue + "          %" + ((int) (transportationValue / totalValue * 100));
		String medicalString = "$" + medicalValue + "                       %" + ((int) (medicalValue / totalValue * 100));
		String personalString = "$" + personalValue + "                      %" + ((int) (personalValue / totalValue * 100));
		String savingsString = "$" + savingsValue + "                        %" + ((int) (savingsValue / totalValue * 100));
		String extraString = "$" + extraValue + "                          %" + ((int) (extraValue / totalValue * 100));

		total.setText("Paycheck Amount: $" + totalValue);
		food.setText("Food: " + foodString);
		shelter.setText("Shelter: " + shelterString);
		utilities.setText("Utilities: " + utilitiesString);
		clothing.setText("Clothing: " + clothingString);
		transportation.setText("Transportation: " + transportationString);
		medical.setText("Medical: " + medicalString);
		personal.setText("Personal: " + personalString);
		savings.setText("Savings: " + savingsString);
		extra.setText("Extra: " + extraString);
 	}
} //End Class