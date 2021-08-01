package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    //variables for identifiers
    EditText checkAmountValue,partySizeValue;
    Button buttonCompute;
    EditText fifteenPercentTipValue,twentyPercentTipValue,twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue,twentyPercentTotalValue,twentyfivePercentTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting reference identifiers
        checkAmountValue=findViewById(R.id.checkAmountValue);
        partySizeValue=findViewById(R.id.partySizeValue);
        buttonCompute=findViewById(R.id.buttonCompute);

        fifteenPercentTipValue=findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue=findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue=findViewById(R.id.twentyfivePercentTipValue);

        fifteenPercentTotalValue=findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue=findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue=findViewById(R.id.twentyfivePercentTotalValue);

        //invoking listener when button pressed
        buttonCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //conditions to check for toast
                String checkAmtCheck = checkAmountValue.getText().toString();
                String partySizeCheck = partySizeValue.getText().toString();


                //toast message if amount/party size empty
                if(checkAmtCheck.length() == 0 || partySizeCheck.length()  == 0){
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_LONG).show();
                }
                //toast message if amount/party size is zero
                else if(Integer.valueOf(partySizeCheck) == 0 || Integer.valueOf(checkAmtCheck) == 0) {
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_LONG).show();
                }
                else{
                    double checkAmount = Double.valueOf(checkAmountValue.getText().toString());
                    int partySize = Integer.valueOf((partySizeValue.getText().toString()));

                    int tip15 = (int) Math.ceil((checkAmount/partySize) * 0.15);
                    fifteenPercentTipValue.setText(String.valueOf(tip15));

                    int tip20 = (int) Math.ceil((checkAmount/partySize) * 0.20);
                    twentyPercentTipValue.setText(String.valueOf(tip20));

                    int tip25 = (int) Math.ceil((checkAmount/partySize) * 0.25);
                    twentyfivePercentTipValue.setText(String.valueOf(tip25));

                    double tip15Check = ((checkAmount / partySize) * 0.15);
                    int tip15Total = (int) Math.ceil((checkAmount / partySize) + tip15Check);
                    fifteenPercentTotalValue.setText(String.valueOf(tip15Total));

                    double tip20Check = ((checkAmount / partySize) * 0.20);
                    int tip20Total = (int) Math.ceil((checkAmount / partySize) + tip20Check);
                    twentyPercentTotalValue.setText(String.valueOf(tip20Total));

                    double tip25Check = ((checkAmount / partySize) * 0.25);
                    int tip25Total = (int) Math.ceil((checkAmount / partySize) + tip25Check);
                    twentyfivePercentTotalValue.setText(String.valueOf(tip25Total));

                    //closes keyboard on phone
                    keyboardClose();
                }
            }
        });
    }
    public void keyboardClose() {
        View v = this.getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}