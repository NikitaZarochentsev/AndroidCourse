package com.example.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // получаем время
        Long time = getIntent().getLongExtra("time", 0);

        // выводим его
        TextView timeTextView = findViewById(R.id.textViewTimeAct4);
        timeTextView.setText(String.valueOf(time));
    }
}