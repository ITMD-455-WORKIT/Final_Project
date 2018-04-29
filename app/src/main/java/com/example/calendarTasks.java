package com.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class calendarTasks extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_Name = "CalendarDays";
    // Calendar table name
    private static final String TABLE_Calendar = "Calendar";
    // Calendar Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DAY = "day";
    private static final String KEY_TASK = "task";
    private static final String KEY_TIME = "timeofday";

    public calendarTasks(Context context) {
        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Calendar + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_DAY +
                " TEXT, " + KEY_TASK + " TEXT, " + KEY_TIME + " TEXT "+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Calendar);
        // Creating tables again
        onCreate(db);
    }

    // Adding new tasks on a calendar day
    public void addTask(Tasks task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DAY, task.getDay()); // Calendar Day
        values.put(KEY_TASK, task.getTask()); // Name of the task
        values.put(KEY_TIME,task.getTimeofday());// Time of day for the task

        // Inserting Row
        db.insert(TABLE_Calendar, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Tasks from on calendar day
    public List<Tasks> getSpecificDay(String k) {
        List<Tasks> TaskList = new ArrayList<Tasks>();

        // Select All Tasks on a certain Calendar day
        String selectQuery = "SELECT * FROM " + TABLE_Calendar + " WHERE " + KEY_DAY + " = " + k;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tasks task = new Tasks();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setDay(cursor.getString(1));
                task.setTask(cursor.getString(2));
                task.setTimeofday((cursor.getString(3)));
                // Adding to list
                TaskList.add(task);
            } while (cursor.moveToNext());
        }

        // return list
        return TaskList;
    }

    // Deleting a task
    public void deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Calendar, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}
