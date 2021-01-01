package com.example.lesson_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWithoutCL = findViewById(R.id.buttonToWithoutCLActMain);
        buttonWithoutCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WithoutCLActivity.class));
            }
        });

        Button buttonWithCL = findViewById(R.id.buttonToWithCLActMain);
        buttonWithCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WithCLActivity.class));
            }
        });
    }
}