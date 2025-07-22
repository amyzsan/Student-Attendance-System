package com.example.studentattendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class AddClassDatabase extends SQLiteOpenHelper {

    // Database constants
    public static final String DATABASE_NAME = "StudentAttendanceDB";
    public static final int DATABASE_VERSION = 1;

    // Table and column names
    public static final String TABLE_CLASSES = "classes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE = "code";

    // Create table statement
    public static final String CREATE_TABLE_CLASSES =
            "CREATE TABLE " + TABLE_CLASSES + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CODE + " TEXT)";

    public AddClassDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CLASSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASSES);
        onCreate(db);
    }

    // Method to add a new class
    public void addClass(String name, String code) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_CODE, code);
        db.insert(TABLE_CLASSES, null, values);
        db.close();
    }

    // Method to get all classes
    public ArrayList<HashMap<String, String>> getAllClasses() {
        ArrayList<HashMap<String, String>> classList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CLASSES, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> classData = new HashMap<>();
                classData.put("name", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
                classData.put("code", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CODE)));
                classList.add(classData);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return classList;
    }
}