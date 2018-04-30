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

    // Initializing textviews
    TextView totalcal, totalcarb, totalprot, totalfat;
    Button back;

    // onCreate method initialized when app loads up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macro_results);

        // Obtaining values and setting them to local variables
        totalcal = findViewById(R.id.totalcal);
        totalprot = findViewById(R.id.totalprot);
        totalfat = findViewById(R.id.totalfat);
        totalcarb = findViewById(R.id.totalcarb);
        back = findViewById(R.id.back);

        // Initialize intent to get intent
        Intent intent = getIntent();

        // Initialize bundle to grab values from bundle
        Bundle bundle = intent.getExtras();

        // Unbundling the values from the bundle and setting them to a string variable
        String a = bundle.getString("newTDEE");
        String b = bundle.getString("totProt");
        String c = bundle.getString("totFat");
        String d = bundle.getString("totCarb");

        // Setting textboxes to the value of the unbundled string
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