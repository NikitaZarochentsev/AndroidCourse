package com.example.lesson_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        buttonSaveInArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputEditText.getText().toString().trim().length() != 0) {
                    String name = inputEditText.getText().toString();
                    studentList.add(name);

                    Toast.makeText(getApplicationContext(), "Имя " + name + " сохранено", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Заполните поле ввода", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button outputButton = findViewById(R.id.buttonOutput);
        outputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayTextView.setText("");
                for (String name : studentList) {
                    String lineName = arrayTextView.getText().toString() + name + "\n";
                    arrayTextView.setText(lineName);
                }

                Toast.makeText(
                        getApplicationContext(),
                        "Выведено " + Integer.toString(studentList.size()) + " элементов",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}