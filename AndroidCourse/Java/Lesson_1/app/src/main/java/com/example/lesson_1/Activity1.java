package com.example.lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TreeSet;

public class Activity1 extends AppCompatActivity {
    private TreeSet<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        studentList = new TreeSet<>();

        Button buttonSaveInArray = findViewById(R.id.buttonSaveInArrayAct1);
        EditText editTextInputStudent = findViewById(R.id.editTextInputStudentAct1);
        buttonSaveInArray.setOnClickListener(view -> {
            if (!editTextInputStudent.getText().toString().trim().isEmpty()) {
                String name = editTextInputStudent.getText().toString();
                studentList.add(name);
                editTextInputStudent.setText("");

                Toast.makeText(Activity1.this, String.format(getString(R.string.success_save_student_text_act1), name), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Activity1.this, R.string.empty_editTextInputStudent_text_act1, Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonOutput = findViewById(R.id.buttonOutputAct1);
        TextView textViewOutput = findViewById(R.id.textViewOutputAct1);
        buttonOutput.setOnClickListener(view -> {
            textViewOutput.setText("");

            for (String student : studentList) {
                String name = textViewOutput.getText() + student + "\n";
                textViewOutput.setText(name);
            }

            hideKeyboardFrom(Activity1.this, buttonOutput);

            Toast.makeText(Activity1.this, String.format(getString(R.string.output_message_text_act1), Integer.toString(studentList.size())), Toast.LENGTH_SHORT).show();
        });
    }

    private static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}