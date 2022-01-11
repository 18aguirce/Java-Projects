package com.example.lab06_fractions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etxtNumerator1;
    EditText etxtDenominator1;
    EditText etxtNumerator2;
    EditText etxtDenominator2;

    TextView txtNumResult;
    TextView txtDenResult;

    Button btnAdd, btnSub, btnMul, btnDiv;

    Fraction fract1, fract2;
    Fraction fractResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MyMsg", "Program starting...");

        /*
        fract1 = new Fraction();
        Log.d("MyMsg", "frac1 num = " + fract1.getNumerator());
        Log.d("MyMsg", "frac1 denom = " + fract1.getDenominator());

        fract2 = new Fraction(12,16);
        Log.d("MyMsg", "frac2 num = " + fract2.getNumerator());
        Log.d("MyMsg", "frac2 denom = " + fract2.getDenominator());



        Fraction fract3 = new Fraction(20, 25);
        Log.d("MyMsg", "frac3 num = " + fract3.getNumerator());
        Log.d("MyMsg", "frac3 denom = " + fract3.getDenominator());

        Fraction fract4 = new Fraction(2, 5);
        Log.d("MyMsg", "frac4 num = " + fract4.getNumerator());
        Log.d("MyMsg", "frac4 denom = " + fract4.getDenominator());


        Fraction result = new Fraction();
        result.Add(fract3, fract4);
        Log.d("MyMsg", "result num = " + result.getNumerator());
        Log.d("MyMsg", "result denom = " + result.getDenominator());

        Log.d("MyMsg", "built in toString = " + result.toString());

        Log.d("MyMsg", "Decimal equivalent = " + result.toDecimal());

         */

        etxtNumerator1 = (EditText) findViewById(R.id.etxtNumerator1);
        etxtDenominator1 = (EditText) findViewById(R.id.etxtDenominator1);
        etxtNumerator2 = (EditText) findViewById(R.id.etxtNumerator2);
        etxtDenominator2 = (EditText) findViewById(R.id.etxtDenominator2);

        txtNumResult = (TextView) findViewById(R.id.txtNumResult);
        txtDenResult = (TextView) findViewById(R.id.txtDenResult);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyMsg", "Clicked on Add button...");

                if(getCurrentFocus() != null)
                {
                    // Remove focus from all edit text boxes.
                    getCurrentFocus().clearFocus();

                    // Hide the soft keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                if(getInput())
                {
                    // fractResult = New Fraction().Add(fract1, fract2);
                    // The two lines below are the same as the one line above.

                    fractResult = new Fraction();
                    fractResult.Add(fract1, fract2);

                    txtNumResult.setText(Integer.toString(fractResult.getNumerator()));
                    txtDenResult.setText(Integer.toString(fractResult.getDenominator()));
                }
            }
        });

        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getCurrentFocus() != null)
                {
                    // Remove focus from all edit text boxes.
                    getCurrentFocus().clearFocus();

                    // Hide the soft keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                if(getInput())
                {
                    // fractResult = New Fraction().Add(fract1, fract2);
                    // The two lines below are the same as the one line above.

                    fractResult = new Fraction();
                    fractResult.Subtract(fract1, fract2);

                    txtNumResult.setText(Integer.toString(fractResult.getNumerator()));
                    txtDenResult.setText(Integer.toString(fractResult.getDenominator()));
                }
            }
        });

        btnMul = (Button) findViewById(R.id.btnMultiply);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentFocus() != null)
                {
                    // Remove focus from all edit text boxes.
                    getCurrentFocus().clearFocus();

                    // Hide the soft keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                if(getInput())
                {
                    // fractResult = New Fraction().Add(fract1, fract2);
                    // The two lines below are the same as the one line above.

                    fractResult = new Fraction();
                    fractResult.Multiply(fract1, fract2);

                    txtNumResult.setText(Integer.toString(fractResult.getNumerator()));
                    txtDenResult.setText(Integer.toString(fractResult.getDenominator()));
                }
            }
        });

        btnDiv = (Button) findViewById(R.id.btnDivide);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCurrentFocus() != null)
                {
                    // Remove focus from all edit text boxes.
                    getCurrentFocus().clearFocus();

                    // Hide the soft keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }

                if(getInput())
                {
                    // fractResult = New Fraction().Add(fract1, fract2);
                    // The two lines below are the same as the one line above.

                    fractResult = new Fraction();
                    fractResult.Divide(fract1, fract2);

                    txtNumResult.setText(Integer.toString(fractResult.getNumerator()));
                    txtDenResult.setText(Integer.toString(fractResult.getDenominator()));
                }
            }
        });
    }

    // Helper function to parse input data
    public boolean getInput() {
        boolean goodData = true;

        txtNumResult.setText("");
        txtDenResult.setText("");

        try {
            fract1 = new Fraction(Integer.parseInt(etxtNumerator1.getText().toString()),
                    Integer.parseInt(etxtDenominator1.getText().toString()));

            fract2 = new Fraction(Integer.parseInt(etxtNumerator2.getText().toString()),
                    Integer.parseInt(etxtDenominator2.getText().toString()));
        } catch (NumberFormatException ex) {
            goodData = false;

            Context context = getApplicationContext();
            CharSequence msgText = "Field Cannot be blank.";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, msgText, duration);
            toast.show();
        }
        return goodData;
    }
}

