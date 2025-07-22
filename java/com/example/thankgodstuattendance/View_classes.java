package com.example.studentattendance;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class view_classess extends AppCompatActivity {

    public ListView classListView;
    public ArrayList<HashMap<String, String>> classList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_classes);

        classListView = findViewById(R.id.class_list);
        loadClassData();
    }

    public void loadClassData() {
        classList = new ArrayList<>();

        HashMap<String, String> class1 = new HashMap<>();
        class1.put("id", "1");
        class1.put("name", "Class 10");
        classList.add(class1);

        HashMap<String, String> class2 = new HashMap<>();
        class2.put("id", "2");
        class2.put("name", "Class 9");
        classList.add(class2);
    }
}