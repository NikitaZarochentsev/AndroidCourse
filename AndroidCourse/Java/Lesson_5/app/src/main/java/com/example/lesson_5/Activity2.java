package com.example.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // переход на Act3
        Button buttonToAct3 = findViewById(R.id.buttonToAct3Act2);
        Intent intentToAct3 = new Intent(Activity2.this, Activity3.class);
        buttonToAct3.setOnClickListener(view -> startActivity(intentToAct3));
    }
}