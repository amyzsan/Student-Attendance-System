package com.example.studentattendance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class take_attendence extends AppCompatActivity {

    public TableLayout tableLayout;
    public Button btnSubmitAttendance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_attendence_classwise);

        tableLayout = findViewById(R.id.tableLayout);
        btnSubmitAttendance = findViewById(R.id.btnSubmitAttendance);

        btnSubmitAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateAttendance()) {
                    Toast.makeText(take_attendence.this,
                            "Attendance Submitted Successfully",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(take_attendence.this,
                            "Please mark attendance for all students",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validateAttendance() {
        for (int i = 1; i < tableLayout.getChildCount(); i++) {
            View row = tableLayout.getChildAt(i);

            if (row instanceof TableRow) {
                RadioGroup presentGroup = row.findViewById(R.id.radioPresent);
                RadioGroup absentGroup = row.findViewById(R.id.radioAbsent);

                if (presentGroup != null && absentGroup != null) {
                    boolean isPresentChecked =
                            ((RadioButton) presentGroup.getChildAt(0)).isChecked();
                    boolean isAbsentChecked =
                            ((RadioButton) absentGroup.getChildAt(0)).isChecked();

                    if (!isPresentChecked && !isAbsentChecked) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}