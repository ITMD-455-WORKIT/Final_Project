package com.example;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

//Customer List Adapter method that adds listview in app
public class CustomAdapter extends ArrayAdapter<Excercises> {
//initializing variables
    private List<Excercises> Excercises;
    private final Activity mContext;
//calling SqlHelper class
    final SqlHelper db = new SqlHelper(getContext());
    // private RatingBar listViewBar;
   /* private static class ViewHolder {
        TextView IDnumber;
        TextView ExcercisesTitle;
        TextView AuthorName;
        RatingBar stars;
    }*/
//
    public CustomAdapter(List<Excercises> data, Activity context) {
        super(context, R.layout.routine, data);
        this.Excercises = data;
        this.mContext=context;

    }

    //
    @Override
    public int getCount() {
        return Excercises.size(); //returns total of items in the list
    }
    @Override
    public long getItemId(int position) {
        return position;
    }//get the id of exercise
    //method to get the excercise and put them in listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView=convertView;
        if(listitemView==null){
            listitemView=LayoutInflater.from(getContext()).inflate(R.layout.routine, null, true);
        }
        final Excercises Excercises =getItem(position);


        TextView listViewId = (TextView) listitemView.findViewById(R.id.textViewId);

        //final int id = Integer.parseInt(listViewId.getText().toString());


//seting data to the textview items in app
        TextView listViewName = (TextView)
                listitemView.findViewById(R.id.textView3);
        TextView listViewExLength = (TextView)
                listitemView.findViewById(R.id.textView4);
        TextView listViewExTime = (TextView)
                listitemView.findViewById(R.id.textView5);
        Button deletebutten =(Button)listitemView.findViewById(R.id.button2);
        deletebutten.setTag(position);//seting button to id
        //method to delete item from databse when button clicked
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
//calling methods to set listview items
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
