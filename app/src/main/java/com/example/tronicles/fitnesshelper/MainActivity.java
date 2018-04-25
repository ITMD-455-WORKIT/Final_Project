package com.example.tronicles.fitnesshelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button macrocalc;
    Button calcount;
    Button wroutine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        macrocalc = findViewById(R.id.macrocalc);
        calcount = findViewById(R.id.calcount);
        wroutine = findViewById(R.id.wroutine);


        macrocalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MacroCalc.class);
                startActivity(i);
            }
        });
        calcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), caloriecounter.class);
                startActivity(i);
            }
        });
        wroutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ExcerciseActivity.class);
                startActivity(i);
            }
        });
    }
}
