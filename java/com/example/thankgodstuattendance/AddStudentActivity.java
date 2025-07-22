package com.example.studentattendance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity {

    private EditText etFirstName, etLastName, etFatherName, etFatherContact, etStudentID, etStudentAddress;
    private Spinner spinnerClass;
    private Button btnAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);

        // Initialize views
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etFatherName = findViewById(R.id.etFatherName);
        etFatherContact = findViewById(R.id.etFatherContact);
        etStudentID = findViewById(R.id.etStudentID);
        etStudentAddress = findViewById(R.id.etStudentAddress);
        spinnerClass = findViewById(R.id.spinnerClass);
        btnAddStudent = findViewById(R.id.btnAddStudent);

        // Set click listener for add student button
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String fatherName = etFatherName.getText().toString().trim();
                String fatherContact = etFatherContact.getText().toString().trim();
                String studentID = etStudentID.getText().toString().trim();
                String studentAddress = etStudentAddress.getText().toString().trim();
                String studentClass = spinnerClass.getSelectedItem().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || fatherName.isEmpty() ||
                        fatherContact.isEmpty() || studentID.isEmpty() || studentAddress.isEmpty()) {
                    Toast.makeText(AddStudent.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddStudent.this, "Student Added Successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                }
            }
        });
    }

    private void clearFields() {
        etFirstName.setText("");
        etLastName.setText("");
        etFatherName.setText("");
        etFatherContact.setText("");
        etStudentID.setText("");
        etStudentAddress.setText("");
    }
}