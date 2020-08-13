package com.example.lesson_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    private TreeSet<String> studentList;
    private EditText inputEditText;
    private TextView arrayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.studentList = new TreeSet<String>();
        this.inputEditText = findViewById(R.id.editText);
        this.arrayTextView = findViewById(R.id.textView);
        Button buttonSaveInArray = findViewById(R.id.buttonSaveInArray);
    }

    public void onClickButtonSaveInArray (View view) {
        if (this.inputEditText.getText().toString().trim().length() != 0) {
            String name = this.inputEditText.getText().toString();
            this.studentList.add(name);
        }
    }

    public void onClickOutput(View view) {
        this.arrayTextView.setText("");
        for (String name : this.studentList) {
            this.arrayTextView.setText(this.arrayTextView.getText().toString() + name + "\n");
        }
    }
}