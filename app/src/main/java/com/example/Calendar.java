package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class Calendar extends AppCompatActivity {
    CalendarView cal;
    TextView txt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        cal = findViewById(R.id.zoomCal);
        txt = findViewById(R.id.move);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                String whatMonth = new DateFormatSymbols().getMonths()[month];
                Toast.makeText(getApplicationContext(), "" + whatMonth, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ZoomCalendar.class);
                String day = Integer.toString(dayOfMonth);
                Bundle b = new Bundle();
                b.putString("day", day);
                b.putString("month", whatMonth);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}