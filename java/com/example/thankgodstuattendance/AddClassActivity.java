package com.example.studentattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class AddClassActivity extends AppCompatActivity {

    private EditText classNameInput, classCodeInput;
    private Button addClassButton, viewClassesButton;
    private ListView classListView;
    private ArrayList<HashMap<String, String>> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_classes);

        // Initialize views
        classNameInput = findViewById(R.id.class_name_input);
        classCodeInput = findViewById(R.id.class_code_input);
        addClassButton = findViewById(R.id.add_class_button);
        viewClassesButton = findViewById(R.id.view_classes_button);
        classListView = findViewById(R.id.class_list);

        // Initialize class list
        classList = new ArrayList<>();

        // Set click listeners
        addClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String className = classNameInput.getText().toString().trim();
                String classCode = classCodeInput.getText().toString().trim();

                if (className.isEmpty() || classCode.isEmpty()) {
                    Toast.makeText(AddClassActivity.this,
                            "Please enter class name and code",
                            Toast.LENGTH_SHORT).show();
                } else {
                    addClass(className, classCode);
                }
            }
        });

        viewClassesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddClassActivity.this, view_attend.class);
                startActivity(intent);
            }
        });
    }

    private void addClass(String name, String code) {
        HashMap<String, String> newClass = new HashMap<>();
        newClass.put("id", String.valueOf(classList.size() + 1));
        newClass.put("name", name);
        newClass.put("code", code);
        classList.add(newClass);

        Toast.makeText(this, "Class Added Successfully", Toast.LENGTH_SHORT).show();

        // Clear input fields
        classNameInput.setText("");
        classCodeInput.setText("");
    }
}