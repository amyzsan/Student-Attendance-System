package com.example.studentattendance;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class list_stud extends AppCompatActivity {

    public TableLayout tableLayout;
    public Button viewAttendanceButton;
    public List_Stud_Database databaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_students);

        tableLayout = findViewById(R.id.tableLayout);
        viewAttendanceButton = findViewById(R.id.viewAttendanceButton);
        databaseHelper = new List_Stud_Database(this);

        loadStudentData();

        viewAttendanceButton.setOnClickListener(v -> {
            Toast.makeText(list_stud.this, "Viewing Attendance...", Toast.LENGTH_SHORT).show();
        });
    }

    public void loadStudentData() {
        ArrayList<HashMap<String, String>> studentList = databaseHelper.getAllStudents();

        if (studentList.isEmpty()) {
            Toast.makeText(this, "No students found.", Toast.LENGTH_SHORT).show();
            return;
        }

        for (HashMap<String, String> student : studentList) {
            TableRow row = new TableRow(this);

            TextView idText = new TextView(this);
            idText.setText(student.get("id"));
            idText.setPadding(10, 10, 10, 10);

            TextView nameText = new TextView(this);
            nameText.setText(student.get("name"));
            nameText.setPadding(10, 10, 10, 10);

            TextView rollText = new TextView(this);
            rollText.setText(student.get("roll"));
            rollText.setPadding(10, 10, 10, 10);

            row.addView(idText);
            row.addView(nameText);
            row.addView(rollText);
            tableLayout.addView(row);
        }
    }
}