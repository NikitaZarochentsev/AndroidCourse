package com.example.lesson_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_circle:
                    CustomDialogFragment dialog = new CustomDialogFragment();
                    dialog.show(getSupportFragmentManager(), "custom");
                    break;
                case R.id.item_home:
                    Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter headerAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(headerAdapter);

        Collection<String> headers = Arrays.asList(
                "Квитанции",
                "Счетчики",
                "Рассрочка",
                "Страхование",
                "Интернет и ТВ",
                "Домофон",
                "Охрана",
                "Контакты УК и служб",
                "Мои заявки",
                "Памятка жителя");

        Collection<String> info = Arrays.asList(
                "- 40 080,55 Р",
                "Подайте показания",
                "Сл. платеж 25.02.2018",
                "Полис до 12.01.2019",
                "Баланс 350 Р",
                "Подключен",
                "Нет",
                "",
                "",
                "");

        headerAdapter.setItems(headers, info);
    }

    private ArrayList<String> fillListOfHeaders() {
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            data.add("line");
        }

        return data;
    }

    private ArrayList<String> fillListOfTexts() {
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            data.add("line");
        }

        return data;
    }
}