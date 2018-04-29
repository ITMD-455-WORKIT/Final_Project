package com.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}
