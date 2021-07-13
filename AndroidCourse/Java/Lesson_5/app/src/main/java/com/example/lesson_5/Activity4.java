package com.example.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // получаем время
        Long time = getIntent().getLongExtra("time", 0);

        // обновляем время в текстовом поле
        updateTime(time);

        // создаем кнопку
        Button againButton = findViewById(R.id.buttonToAct4AgainAct4);

        // создаем Intent
        Intent intent = new Intent(Activity4.this, Activity4.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("time", System.currentTimeMillis());
        againButton.setOnClickListener(view -> startActivity(intent));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        // получаем время
        Long time = intent.getLongExtra("time", 0);

        // обновляем время в текстовом поле
        updateTime(time);

        // создаем кнопку
        Button againButton = findViewById(R.id.buttonToAct4AgainAct4);
        
        // создаем Intent
        Intent intentButton = new Intent(Activity4.this, Activity4.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("time", System.currentTimeMillis());
        againButton.setOnClickListener(view -> startActivity(intent));
    }

    private void updateTime(Long time) {
        // создаем объект для приведения времени к нужному виду
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        // выводим его
        TextView timeTextView = findViewById(R.id.textViewTimeAct4);
        timeTextView.setText(dateFormat.format(new Date(time)));
    }
}