package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tronicles on 4/16/2018.
 */

public class MacroResults extends AppCompatActivity {

    TextView totalcal, totalcarb, totalprot, totalfat;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macro_results);

        totalcal = findViewById(R.id.totalcal);
        totalprot = findViewById(R.id.totalprot);
        totalfat = findViewById(R.id.totalfat);
        totalcarb = findViewById(R.id.totalcarb);
        back = findViewById(R.id.back);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String a = bundle.getString("newTDEE");
        String b = bundle.getString("totProt");
        String c = bundle.getString("totFat");
        String d = bundle.getString("totCarb");

        totalcal.setText(a);
        totalprot.setText(b);
        totalfat.setText(c);
        totalcarb.setText(d);

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
