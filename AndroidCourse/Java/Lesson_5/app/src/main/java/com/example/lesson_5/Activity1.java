package com.example.lesson_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        // переход на Act4
        Button buttonToAct4 = findViewById(R.id.buttonToAct4Act1);
        Intent intentToAct4 = new Intent(Activity1.this, Activity4.class);
        intentToAct4.putExtra("time", System.currentTimeMillis());
        buttonToAct4.setOnClickListener(view -> startActivity(intentToAct4));

        // переход на Act2
        Button buttonToAct2 = findViewById(R.id.buttonToAct2Act1);
        Intent intentToAct2 = new Intent(Activity1.this, Activity2.class);
        buttonToAct2.setOnClickListener(view -> startActivity(intentToAct2));
    }
}