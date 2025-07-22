package com.example.studentattendance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class view_attend extends AppCompatActivity {

    public TextView txtClassName;
    public ListView studentListView;
    public Button btnSubmitAttendance;
    public ArrayList<HashMap<String, String>> studentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_attendence);

        txtClassName = findViewById(R.id.txtClassName);
        studentListView = findViewById(R.id.studentListView);
        btnSubmitAttendance = findViewById(R.id.btnSubmitAttendance);

        txtClassName.setText("Class: 10");
        loadStudentData();

        btnSubmitAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view_attend.this,
                        "Attendance Submitted Successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadStudentData() {
        studentList = new ArrayList<>();

        HashMap<String, String> student1 = new HashMap<>();
        student1.put("id", "101");
        student1.put("name", "John Doe");
        studentList.add(student1);

        HashMap<String, String> student2 = new HashMap<>();
        student2.put("id", "102");
        student2.put("name", "Jane Smith");
        studentList.add(student2);
    }
}