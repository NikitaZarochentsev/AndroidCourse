package com.example.lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonActivity1 = findViewById(R.id.buttonActivity1);
        buttonActivity1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity1.class)));

        Button buttonActivity2 = findViewById(R.id.buttonActivity2);
        buttonActivity2.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity2.class)));
    }
}