package com.example;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ZoomCalendar extends AppCompatActivity {
    TextView day;
    TextView month;
    String zoomedDay;
    String backMonth;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    EditText hour;
    EditText tasks;
    Button addBtn;
    ListView listView;

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

        Bundle b = getIntent().getExtras();
        zoomedDay = b.getString("day");
        backMonth = b.getString("month");

        day.setText(zoomedDay);
        month.setText("< Back to " + backMonth);

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(hour.getText().toString() +"\t\t\t\t\t\t"+ tasks.getText().toString());

                hour.setText("");
                tasks.setText("");

                Collections.sort(list);
                adapter.notifyDataSetChanged();
            }
        });

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                CheckedTextView checkedTextView = ((CheckedTextView)view);
                checkedTextView.setChecked(!checkedTextView.isChecked());

                if(checkedTextView.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ZoomCalendar.this);
                    builder.setTitle("Remove Entry?");
                    builder.setMessage("Are you want to delete this entry?");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.remove(adapter.getItem(position));
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });

        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            }
        });
    }
}