package com.example.additionexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button btn;
    int diff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_third);


        tv = findViewById (R.id.tvDiff);
        btn = findViewById (R.id.btnReturn);
        btn.setOnClickListener (this);
        Intent intent = getIntent ( );
        int number1 = intent.getIntExtra ("n1", 0);
        int number2 = intent.getIntExtra ("n2", 0);
        diff = number1 - number2;
        tv.setText ("Result is " + diff);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent ( );
        intent.putExtra ("substraction", diff);
        setResult (RESULT_OK, intent);
        finish ( );
    }

}

