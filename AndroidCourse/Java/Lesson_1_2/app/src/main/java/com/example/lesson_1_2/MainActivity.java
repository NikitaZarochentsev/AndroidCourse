package com.example.lesson_1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<Integer, Student> studentsHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        this.studentsHashMap = new HashMap<>();
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String inputStr = editText.getText().toString().trim();
                    if (!inputStr.equals("")) {
                        String[] parts = inputStr.split(" ");
                        int id = (int) System.currentTimeMillis();
                        Student student = new Student(id, parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                        studentsHashMap.put(id, student);

                        editText.setText("");
                        Toast.makeText(MainActivity.this, R.string.textStudentAdded, Toast.LENGTH_SHORT).show();

                        return true;
                    }
                    else {
                        Toast.makeText(MainActivity.this, R.string.textStudentNotAdded, Toast.LENGTH_SHORT).show();
                    }
                }

                return false;
            }
        });

        Button button = findViewById(R.id.button);
        final TextView textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!studentsHashMap.isEmpty()) {
                    for (HashMap.Entry<Integer, Student> studentHashMap : studentsHashMap.entrySet()) {
                        String outputText = textView.getText().toString() + studentHashMap.getValue().toString() + "\n";
                        textView.setText(outputText);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), R.string.textEmpty, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}