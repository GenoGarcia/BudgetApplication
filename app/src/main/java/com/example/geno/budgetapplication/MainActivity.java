package com.example.geno.budgetapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    Button budgetButton;
    TextView amount;

    /** Get Value from TextView (amount) Field */

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        budgetButton = (Button)findViewById(R.id.budgetButton);
        amount = (TextView) findViewById(R.id.amount);

        budgetButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick() {
                        update ListView ();
                    }
                });
        public void update MainActivity() {
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
        ArrayAdapter adapt = new ArrayAdapter (getBaseContext, list());
        outputList.setAdapter(adapt);
        }
    }

    public class ListActivity extends MainActivity {

        /** Adding user input from TextView (amount) into List View */

        private ListView foodBudget;
        private ListView shelterBudget;
        private ListView utilitiesBudget;
        private ListView clothingBudget;
        private ListView transportationBudget;
        private ListView medicalBudget;
        private ListView personalBudget;
        private ListView savingsBudget;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            foodBudget = (ListView) findViewById(R.id.foodBudget);
            shelterBudget = (ListView) findViewById(R.id.shelterBudget);
            utilitiesBudget = (ListView) findViewById(R.id.utilitiesBudget);
            clothingBudget = (ListView) findViewById(R.id.clothingBudget);
            transportationBudget = (ListView) findViewById(R.id.transportationBudget);
            medicalBudget = (ListView) findViewById(R.id.medicalBudget);
            personalBudget = (ListView) findViewById(R.id.personalBudget);
            savingsBudget = (ListView) findViewById(R.id.savingsBudget);
        }
    }
}