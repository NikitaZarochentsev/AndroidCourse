package com.example.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonToAct4Main);

        // заранее создадим Intent
        Intent intent = new Intent(MainActivity.this, Activity4.class);
        intent.putExtra("time", System.currentTimeMillis());

        button.setOnClickListener(view -> startActivity(intent));
    }
}