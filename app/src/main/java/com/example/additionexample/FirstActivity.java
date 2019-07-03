package com.example.additionexample;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3;
    Button btnSum, btnDiff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_first);
        editText1 = findViewById (R.id.et1);
        editText2 = findViewById (R.id.et2);
        editText3 = findViewById (R.id.et3);
        btnSum = findViewById (R.id.btnAdd);
        btnDiff = findViewById (R.id.btnSubstract);

        btnSum.setOnClickListener (this);
        btnDiff.setOnClickListener (this);
    }

    @Override
    public void onClick(View v) { // common method for all buttons
        int num1 = Integer.parseInt (editText1.getText ( ).toString ( ));
        int num2 = Integer.parseInt (editText2.getText ( ).toString ( ));
        if (v.getId ( ) == R.id.btnAdd) {

            // Create Intent Object
            Intent intent = new Intent (this, SecondActivity.class);
            // Store data in Intent object
            intent.putExtra ("n1", num1);
            intent.putExtra ("n2", num2);
            // Send Intent object to Second Activity via Android System
            startActivityForResult (intent, 123);
        } else if (v.getId ( ) == R.id.btnSubstract) {
            // Create Intent Object
            Intent intent = new Intent (this, ThirdActivity.class);
            // Store data in Intent object
            intent.putExtra ("n1", num1);
            intent.putExtra ("n2", num2);
            // Send Intent object to Second Activity via Android System
            startActivityForResult (intent, 246);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent i) {
        super.onActivityResult (requestCode, resultCode, i);
        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                int sum = i.getIntExtra ("addition", 0);
                editText3.setText (sum + "");
            } else if (requestCode == 246) {
                int diff = i.getIntExtra ("substraction", 0);
                editText3.setText (diff + "");

            }
        }
    }
}

