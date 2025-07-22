package com.example.studentattendance;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import
        android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import
        androidx.appcompat.app.AppCompatActiv
ity;
import java.util.ArrayList;
import java.util.Calendar;
public class AttendanceActivity extends
        AppCompatActivity {
    public AutoCompleteTextView
            classDropdown;
    public Button setDateTimeButton,
            takeAttendanceButton,
            viewAttendanceButton;
    public TextView selectedDateTime;
    public AttendanceDatabase
            databaseHelper;
    public String selectedDate,
            selectedTime;
    @Override
    public void onCreate(Bundle
                                 savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_attenden
                ce);
        classDropdown =
                findViewById(R.id.classDropdown);
        setDateTimeButton =
                findViewById(R.id.setDateTimeButton);
        takeAttendanceButton =
                findViewById(R.id.takeAttendanceButton)
        ;
        viewAttendanceButton =
                findViewById(R.id.viewAttendanceButton
                );
        databaseHelper = new
                AttendanceDatabase(this);
        populateClassDropdown();

        setDateTimeButton.setOnClickListener(v -
                > showDateTimePicker());
        takeAttendanceButton.setOnClickListener(
                v -> saveAttendance());
        viewAttendanceButton.setOnClickListener
                (v -> viewAttendanceRecords());
    }
    public void populateClassDropdown() {
        ArrayList<String> classList = new
                ArrayList<>();
        classList.add("Mathematics");
        classList.add("Physics");
        classList.add("Computer Science");
        ArrayAdapter<String> adapter = new
                ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_
        1line, classList);

        classDropdown.setAdapter(adapter);
    }
    public void showDateTimePicker() {
        final Calendar calendar =
                Calendar.getInstance();
        int year =
                calendar.get(Calendar.YEAR);
        int month =
                calendar.get(Calendar.MONTH);
        int day =
                calendar.get(Calendar.DAY_OF_MONTH
                );
        int hour =
                calendar.get(Calendar.HOUR_OF_DAY);
        int minute =
                calendar.get(Calendar.MINUTE);
        new DatePickerDialog(this, (view,
                                    selectedYear, selectedMonth, selectedDay)
                -> {
            selectedDate = selectedDay + "/" +
                    (selectedMonth + 1) + "/" + selectedYear;
            new TimePickerDialog(this,
                    (view1, selectedHour, selectedMinute) ->
                    {
                        selectedTime = selectedHour +
                                ":" + selectedMinute;
                        selectedDateTime.setText("Selected: " +
                                selectedDate + " at " + selectedTime);
                    }, hour, minute, true).show();
        }, year, month, day).show();
    }
    public void saveAttendance() {
        String className =
                classDropdown.getText().toString();
        if (className.isEmpty() ||
                selectedDate == null || selectedTime ==
                null) {
            Toast.makeText(this, "Please select
            class, date, and time",
            Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isInserted =
                databaseHelper.addAttendance(className,
                        selectedDate, selectedTime, "Present");
        if (isInserted) {
            Toast.makeText(this, "Attendance
                    Recorded Successfully",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error
                    Recording Attendance",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void viewAttendanceRecords() {
        Cursor cursor =
                databaseHelper.getAllAttendance();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No
                    Attendance Records Found",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuilder records = new
                StringBuilder();
        while (cursor.moveToNext()) {
            records.append("Class:
                    ").append(cursor.getString(1))
                            .append("\nDate:
                                    ").append(cursor.getString(2))
                                            .append("\nTime:
                                                    ").append(cursor.getString(3))
                                                            .append("\nStatus:
                                                                    ").append(cursor.getString(4))
                                                                            .append("\n-------------------
                                                                                    \n");
        }
        Toast.makeText(this,
                records.toString(),
                Toast.LENGTH_LONG).show();
    }
}