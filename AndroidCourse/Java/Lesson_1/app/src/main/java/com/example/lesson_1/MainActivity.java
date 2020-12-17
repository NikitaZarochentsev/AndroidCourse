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

        Button buttonToAct1Main = findViewById(R.id.buttonToAct1Main);
        buttonToAct1Main.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity1.class)));

        Button buttonToAct2Main = findViewById(R.id.buttonToAct2Main);
        buttonToAct2Main.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Activity2.class)));
    }
}