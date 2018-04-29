package com.example;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CalendarAdapter extends ArrayAdapter<Tasks> {

    private List<Tasks> tasks;
    private final Activity cont;

    final calendarTasks db = new calendarTasks(getContext());

    public CalendarAdapter(List<Tasks> tasks, Activity cont) {
        super(cont, R.layout.routine, tasks);
        this.tasks = tasks;
        this.cont = cont;

    }@Override
    public int getCount() {
        return tasks.size(); //returns total of items in the list
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView=convertView;
        if(listitemView==null){
            listitemView=LayoutInflater.from(getContext()).inflate(R.layout.cal_tasks, null, true);
        }
        final Tasks tasks =getItem(position);

        TextView taskName = listitemView.findViewById(R.id.textView3);
        TextView taskTime = listitemView.findViewById(R.id.textView5);
        Button deleteBtn = listitemView.findViewById(R.id.button2);
        deleteBtn.setTag(position);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positionToRemove = (int)view.getTag();
                removeItem(positionToRemove);
                db.deleteTask(tasks.getId());
                notifyDataSetChanged();
            }
        });

        taskName.setText(tasks.getTask());
        taskTime.setText(""+tasks.getTimeofday());

        return listitemView;
    }

    public void removeItem(int position){
        tasks.remove(position);
        notifyDataSetChanged();
    }
}