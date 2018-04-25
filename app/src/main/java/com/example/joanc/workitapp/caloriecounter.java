package com.example.joanc.workitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joanc on 4/25/2018.
 */


public class caloriecounter extends AppCompatActivity {

    private EditText bfcal;
    private EditText lunchcal;
    private EditText dinnercal;
    private EditText snackcal;
    private Button btntotal;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bfcal = (EditText) findViewById(R.id.bfcal);
        lunchcal = (EditText) findViewById(R.id.lunchcal);
        dinnercal = (EditText) findViewById(R.id.dinnercal);
        snackcal = (EditText) findViewById(R.id.snackcal);
        btnTotal = (Button) findViewById(R.id.btnTotal);
        total = (TextView) findViewById(R.id.total);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bfcal = Integer.parseInt(bfcal.getText().toString());
                int lunchcal = Integer.parseInt(lunchcal.getText().toString());
                int dinnercal = Integer.parseInt(dinnercal.getText().toString());
                int snackcal = Integer.parseInt(snackcal.getText().toString());
                int sum = bfcal + lunchcal + dinnercal + snackcal;
                total.setText("Total: " + String.valueOf(sum));

            }
        });

    }
}

