package com.example.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // переход на Act3
        Button buttonToAct1 = findViewById(R.id.buttonToAct1Act3);
        Intent intentToAct1 = new Intent(Activity3.this, Activity1.class);
        buttonToAct1.setOnClickListener(view -> startActivity(intentToAct1));
    }
}