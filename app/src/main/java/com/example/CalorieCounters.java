package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joanc on 4/25/2018.
 */


public class CalorieCounters extends AppCompatActivity {

    private EditText bfcal;
    private EditText lunchcal;
    private EditText dinnercal;
    private EditText snackcal;
    private Button btntotal;
    private TextView total;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caloriecounter);

        bfcal = (EditText) findViewById(R.id.bfcal);
        lunchcal = (EditText) findViewById(R.id.lunchcal);
        dinnercal = (EditText) findViewById(R.id.dinnercal);
        snackcal = (EditText) findViewById(R.id.snackcal);
        btntotal = (Button) findViewById(R.id.btnTotal);
        total = (TextView) findViewById(R.id.total);
        back = findViewById(R.id.back);
        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int bfcalsi = Integer.parseInt(bfcal.getText().toString());
                int lunchcalsi = Integer.parseInt(lunchcal.getText().toString());
                int dinnercalsi = Integer.parseInt(dinnercal.getText().toString());
                int snackcalsi = Integer.parseInt(snackcal.getText().toString());
                int sum = bfcalsi+ lunchcalsi + dinnercalsi + snackcalsi;
                total.setText("Total: " +sum);
            }
        });
        //method to return to main page
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

