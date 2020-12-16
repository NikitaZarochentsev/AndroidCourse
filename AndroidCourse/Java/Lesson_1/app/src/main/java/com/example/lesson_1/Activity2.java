package com.example.lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Activity2 extends AppCompatActivity {
    private HashMap<Integer, Student> studentsHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        studentsHashMap = new HashMap<>();

        EditText editTextInputStudent = findViewById(R.id.editTextInputStudentAct2);
        editTextInputStudent.setOnEditorActionListener(((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String inputStr = editTextInputStudent.getText().toString().trim();
                editTextInputStudent.setText("");
                if (!inputStr.equals("")) {
                    String[] parts = inputStr.split(" ");
                    if (parts.length != 4) {
                        Toast.makeText(Activity2.this, R.string.incorrect_input_toast_act2, Toast.LENGTH_SHORT).show();
                    } else {
                        int id = (int) System.currentTimeMillis();
                        Student student = new Student(id, parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                        studentsHashMap.put(id, student);

                        Toast.makeText(Activity2.this, R.string.success_student_added_toast_act2, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Activity2.this, R.string.failure_student_added_toast_act2, Toast.LENGTH_SHORT).show();
                }
            }

            return true;
        }));

        Button buttonShowListOfStudents = findViewById(R.id.buttonShowListOfStudentsAct2);
        TextView textViewListOfStudents = findViewById(R.id.textViewListOfStudentsAct2);
        buttonShowListOfStudents.setOnClickListener(view -> {
            if (!studentsHashMap.isEmpty()) {
                for (HashMap.Entry<Integer, Student> studentHashMap : studentsHashMap.entrySet()) {
                    textViewListOfStudents.setText(String.format(getString(R.string.line_list_of_students_textView_act2), textViewListOfStudents.getText(), studentHashMap.getValue()));
                }
            } else {
                Toast.makeText(Activity2.this, R.string.empty_hashMap_toast_act2, Toast.LENGTH_SHORT).show();
            }

            hideKeyboardFrom(Activity2.this, buttonShowListOfStudents);
        });
    }

    private static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}