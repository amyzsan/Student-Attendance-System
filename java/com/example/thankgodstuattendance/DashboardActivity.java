package com.example.studentattendance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    public TextView navHome, navClasses, navStudents, navTeachers, navLogout;
    public Button btnTakeAttendance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        navHome = findViewById(R.id.nav_home);
        navClasses = findViewById(R.id.nav_classes);
        navStudents = findViewById(R.id.nav_students);
        navTeachers = findViewById(R.id.nav_teachers);
        navLogout = findViewById(R.id.nav_logout);
        btnTakeAttendance = findViewById(R.id.btntakeattendence);

        navHome.setOnClickListener(v ->
                navigateTo(DashboardActivity.class));
        navClasses.setOnClickListener(v ->
                navigateTo(AddClassActivity.class));
        navStudents.setOnClickListener(v ->
                navigateTo(AddStudent.class));
        navTeachers.setOnClickListener(v ->
                navigateTo(AddTeachers.class));
        navLogout.setOnClickListener(v ->
                logoutUser());
        btnTakeAttendance.setOnClickListener(v ->
                navigateTo(AttendanceActivity.class));
    }

    public void navigateTo(Class<?> targetActivity) {
        Intent intent = new Intent(DashboardActivity.this, targetActivity);
        startActivity(intent);
    }

    public void logoutUser() {
        Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}