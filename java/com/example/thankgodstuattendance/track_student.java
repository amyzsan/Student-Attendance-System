package com.example.studentattendance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class track_stud extends AppCompatActivity {

    public EditText studentIdInput;
    public Button trackButton;
    public TextView errorMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_student);

        studentIdInput = findViewById(R.id.student_id_input);
        trackButton = findViewById(R.id.track_button);
        errorMessage = findViewById(R.id.error_message);

        trackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = studentIdInput.getText().toString().trim();

                if (studentId.isEmpty()) {
                    errorMessage.setVisibility(View.VISIBLE);
                    errorMessage.setText("Student ID cannot be empty");
                } else {
                    trackStudent(studentId);
                }
            }
        });
    }

    public void trackStudent(String studentId) {
        if (studentId.equals("12345")) {
            Toast.makeText(this, "Tracking Student ID: " + studentId, Toast.LENGTH_SHORT).show();
            errorMessage.setVisibility(View.GONE);
        } else {
            errorMessage.setText("Invalid Student ID");
            errorMessage.setVisibility(View.VISIBLE);
        }
    }
}