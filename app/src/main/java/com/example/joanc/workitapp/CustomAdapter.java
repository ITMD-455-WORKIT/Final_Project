package com.example.joanc.workitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.view.LayoutInflater;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomAdapter extends ArrayAdapter<Excercises> {

    private List<Excercises> Excercises;
    private final Activity mContext;

    final SqlHelper db = new SqlHelper(getContext());
    // private RatingBar listViewBar;
   /* private static class ViewHolder {
        TextView IDnumber;
        TextView ExcercisesTitle;
        TextView AuthorName;
        RatingBar stars;
    }*/

    public CustomAdapter(List<Excercises> data, Activity context) {
        super(context, R.layout.routine, data);
        this.Excercises = data;
        this.mContext=context;

    }@Override
    public int getCount() {
        return Excercises.size(); //returns total of items in the list
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView=convertView;
        if(listitemView==null){
            listitemView=LayoutInflater.from(getContext()).inflate(R.layout.routine, null, true);
        }
        final Excercises Excercises =getItem(position);


        TextView listViewId = (TextView) listitemView.findViewById(R.id.textViewId);

        //final int id = Integer.parseInt(listViewId.getText().toString());



        TextView listViewName = (TextView)
                listitemView.findViewById(R.id.textView3);
        TextView listViewExLength = (TextView)
                listitemView.findViewById(R.id.textView4);
        TextView listViewExTime = (TextView)
                listitemView.findViewById(R.id.textView5);
        Button deletebutten =(Button)listitemView.findViewById(R.id.button2);
        deletebutten.setTag(position);
        deletebutten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  int positionToRemove = (int)view.getTag();
                  removeItem(positionToRemove);
                  db.deleteExcercise(Excercises.getId());
                  notifyDataSetChanged();
                //int id = Integer.parseInt(listViewId.getText().toString());
                //db.deleteExcercise(id);
                Toast.makeText(mContext.getApplicationContext(), "Excercise Deleted", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });

      // listViewId.setText(Excercises.getId());
        listViewName.setText(Excercises.getName());
        listViewExLength.setText(""+Excercises.getExcerciselength());
        listViewExTime.setText(""+Excercises.getTimetoexcercise());


        return listitemView;
    }

    public void removeItem(int position){
        Excercises.remove(position);
        notifyDataSetChanged();

    }


}
