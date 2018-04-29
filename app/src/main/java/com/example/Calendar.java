package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.text.DateFormatSymbols;

public class Calendar extends AppCompatActivity {
    CalendarView cal;
    Button back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        cal = findViewById(R.id.zoomCal);
        back = findViewById(R.id.back);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                String whatMonth = new DateFormatSymbols().getMonths()[month];
                Intent intent = new Intent(getApplicationContext(), ZoomCalendar.class);
                String day = Integer.toString(dayOfMonth);
                Bundle b = new Bundle();
                b.putString("day", day);
                b.putString("month", whatMonth);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}