package com.example;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class ZoomCalendar extends AppCompatActivity {
    TextView day;
    Button month;
    String zoomedDay;
    String backMonth;
    EditText hour;
    EditText tasks;
    Button addBtn;
    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoomed);

        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        listView = findViewById(R.id.list);
        addBtn = findViewById(R.id.add);
        hour = findViewById(R.id.when);
        tasks = findViewById(R.id.task);

        //Getting data from calendar
        Bundle b = getIntent().getExtras();
        zoomedDay = b.getString("day");
        backMonth = b.getString("month");

        //Setting received data
        day.setText(zoomedDay);
        month.setText("< " + backMonth);

        //Makes database object
        final calendarTasks db = new calendarTasks(this);

        //Calls database and puts in results to a list
        List<Tasks> list = db.getSpecificDay(zoomedDay);
        listAdapter = new CalendarAdapter(list,ZoomCalendar.this );

        //Listener for add button that adds new entry
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addTask(new Tasks(zoomedDay, tasks.getText().toString(), hour.getText().toString()));

                List<Tasks> list = db.getSpecificDay(zoomedDay);
                listAdapter = new CalendarAdapter(list,ZoomCalendar.this );
                listView.setAdapter(listAdapter);
            }
        });
        listView.setAdapter(listAdapter);

        //Back button listener
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            }
        });
    }
}