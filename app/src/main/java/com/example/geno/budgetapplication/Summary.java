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

    /*      Pie Chart     */

    /*
    //Still need to create a surface view for pie chart...

    public class PercentView extends View {

    public PercentView (Context context) {
        super(context);
        init();
    }
    public PercentView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public PercentView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    private void init() {
        foodPaint = new Paint();
        shelterPaint = new Paint();
        utilitiesPaint = new Paint();
        clothingPaint = new Paint();
        transportationPaint = new Paint();
        medicalPaint = new Paint();
        personalPaint = new Paint();
        savingsPaint = new Paint();
        extraPaint = new Paint();

        foodPaint.setColor(getContext().getResources().getColor(R.color.#ffceecff));
        foodPaint.setAntiAlias(true);
        foodPaint.setStyle(Paint.Style.FILL);

        shelterPaint.setColor(getContext().getResources().getColor(R.color.#ffe1ffc4));
        shelterPaint.setAntiAlias(true);
        shelterPaint.setStyle(Paint.Style.FILL);

        utilitiesPaint.setColor(getContext().getResources().getColor(R.color.#ffffd99c));
        utilitiesPaint.setAntiAlias(true);
        utilitiesPaint.setStyle(Paint.Style.FILL);

        clothingPaint.setColor(getContext().getResources().getColor(R.color.#ffffbdea));
        clothingPaint.setAntiAlias(true);
        clothingPaint.setStyle(Paint.Style.FILL);

        transportationPaint.setColor(getContext().getResources().getColor(R.color.#ffffb9b9));
        transportationPaint.setAntiAlias(true);
        transportationPaint.setStyle(Paint.Style.FILL);

        medicalPaint.setColor(getContext().getResources().getColor(R.color.#ff9dffb7));
        medicalPaint.setAntiAlias(true);
        medicalPaint.setStyle(Paint.Style.FILL);

        personalPaint.setColor(getContext().getResources().getColor(R.color.#ffecc8ff));
        personalPaint.setAntiAlias(true);
        personalPaint.setStyle(Paint.Style.FILL);

        savingsPaint.setColor(getContext().getResources().getColor(R.color.#ffffffc1));
        savingsPaint.setAntiAlias(true);
        savingsPaint.setStyle(Paint.Style.FILL);

        extraPaint.setColor(getContext().getResources().getColor(R.color.#ffc3d1ff));
        extraPaint.setAntiAlias(true);
        extraPaint.setStyle(Paint.Style.FILL);

        rect = new RectF();
    }
    foodPaint paint;
    shelterPaint paint;
    utilitiesPaint paint;
    clothingPaint paint;
    transportationPaint paint;
    medicalPaint paint;
    personalPaint paint;
    savingsPaint paint;
    extraPaint paint;

    RectF rect;
    float percentage = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //draw background circle anyway
        int left = 0;
        int width = getWidth();
        int top = 0;
        rect.set(left, top, left+width, top + width);
        canvas.drawArc(rect, -90, 360, true, extraPaint);
        if(percentage!=0) {
            canvas.drawArc(rect, -90, (360*percentage), true, paint);
        }
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage / 100;
        invalidate();
    }
}*/
} //End Class