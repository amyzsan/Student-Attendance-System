package com.example.studentattendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class per_stud extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "StudentAttendanceDB";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_ATTENDANCE = "per_student_attendance";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STUDENT_NAME = "student_name";
    public static final String COLUMN_CLASS_NAME = "class_name";
    public static final String COLUMN_ATTENDANCE_STATUS = "attendance_status";
    public static final String COLUMN_DATE = "date";

    public static final String CREATE_TABLE_ATTENDANCE =
            "CREATE TABLE " + TABLE_ATTENDANCE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_STUDENT_NAME + " TEXT, " +
                    COLUMN_CLASS_NAME + " TEXT, " +
                    COLUMN_ATTENDANCE_STATUS + " TEXT, " +
                    COLUMN_DATE + " TEXT)";

    public per_stud(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ATTENDANCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        onCreate(db);
    }

    public boolean insertAttendance(String studentName, String className,
                                    String attendanceStatus, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_STUDENT_NAME, studentName);
        values.put(COLUMN_CLASS_NAME, className);
        values.put(COLUMN_ATTENDANCE_STATUS, attendanceStatus);
        values.put(COLUMN_DATE, date);

        long result = db.insert(TABLE_ATTENDANCE, null, values);
        db.close();
        return result != -1;
    }

    public Cursor getAttendanceRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ATTENDANCE, null);
    }
}