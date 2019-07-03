package com.example.additionexample;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button btn;
    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_second);
        tv = findViewById (R.id.tvSum);
        btn = findViewById (R.id.btnReturn);
        btn.setOnClickListener (this);
        Intent intent = getIntent ( );
        int number1 = intent.getIntExtra ("n1", 0);
        int number2 = intent.getIntExtra ("n2", 0);
        sum = number1 + number2;
        tv.setText ("Result is " + sum);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra ("addition", sum);
        setResult (RESULT_OK, intent);
        finish ();
    }
}