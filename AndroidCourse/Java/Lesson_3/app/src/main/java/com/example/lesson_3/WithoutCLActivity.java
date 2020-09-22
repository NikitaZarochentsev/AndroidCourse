package com.example.lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WithoutCLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_cl);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText("Анастасия");
        TextView textViewSurname = findViewById(R.id.textViewSurname);
        textViewSurname.setText("Антонина");
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText("anykee.box@gmail.ru");
        TextView textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setText("HIE023UOI88");
        TextView textViewRegion = findViewById(R.id.textViewRegion);
        textViewRegion.setText("Санкт-Петербург");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}