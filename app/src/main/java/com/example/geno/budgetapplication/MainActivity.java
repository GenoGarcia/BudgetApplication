package com.example.geno.budgetapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
//-----------------------------------------------------
//
//		Fields
//
//-----------------------------------------------------
	protected Button budgetButton;
	protected TextView amount;
	protected ListView foodBudget;
	protected ListView shelterBudget;
	protected ListView utilitiesBudget;
	protected ListView clothingBudget;
	protected ListView transportationBudget;
	protected ListView medicalBudget;
	protected ListView personalBudget;
	protected ListView savingsBudget;

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
		foodBudget = (ListView) findViewById(R.id.foodBudget);
		shelterBudget = (ListView) findViewById(R.id.shelterBudget);
		utilitiesBudget = (ListView) findViewById(R.id.utilitiesBudget);
		clothingBudget = (ListView) findViewById(R.id.clothingBudget);
		transportationBudget = (ListView) findViewById(R.id.transportationBudget);
		medicalBudget = (ListView) findViewById(R.id.medicalBudget);
		personalBudget = (ListView) findViewById(R.id.personalBudget);
		savingsBudget = (ListView) findViewById(R.id.savingsBudget);
	}


//-----------------------------------------------------
//
//		Logic
//
//-----------------------------------------------------

		/*
         public outputList() {
            final budgetButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick() {
                            updateListView();
                        }
                    });

        }

        public void updateMainActivity() {
        ArrayList<String> list = new ArrayList<>();
        double amount = Double.parseDouble(amount.getText());
        list.add("Food Budget $ " + (amount*.15));
        list.add("Shelter Budget $ " + (amount*.25));
        list.add("Utilities Budget $ " + (amount*.15));
        list.add("Clothing Budget $ " + (amount*.10));
        list.add("Transportation Budget $ " + (amount*.15));
        list.add("Medical Budget $ " + (amount*.10));
        list.add("Personal Budget $ " + (amount*.7));
        list.add("Savings Budget $ " + (amount*.3));
        ArrayAdapter adapt = new ArrayAdapter (getBaseContext, list);
        outputList.setAdapter(adapt);
        }*/


} //End Class