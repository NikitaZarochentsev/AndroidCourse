package com.example.lesson_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<CardInfo> cards = fillData();
        int emptyPosition = -1;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).info.equals("")) {
                emptyPosition = i;
                break;
            }
        }

        if (emptyPosition % 2 == 1) {
            emptyPosition--;
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if (position < 6) {
                    return 1;
                }

                return 2;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        DetailViewAdapter detailViewAdapter = new DetailViewAdapter();
        recyclerView.setAdapter(detailViewAdapter);
        detailViewAdapter.setItems(cards);
    }

    ArrayList<CardInfo> fillData() {
        ArrayList<CardInfo> data = new ArrayList<CardInfo>();

        ArrayList<String> headers = new ArrayList<String>(Arrays.asList(
                "Квитанции",
                "Счетчики",
                "Рассрочка",
                "Страхование",
                "Интернет и ТВ",
                "Домофон",
                "Охрана",
                "Контакты УК и служб",
                "Мои заявки",
                "Памятка жителя"));

        ArrayList<String> info = new ArrayList<String>(Arrays.asList(
                "- 40 080,55 Р",
                "Подайте показания",
                "Сл. платеж 25.02.2018",
                "Полис до 12.01.2019",
                "Баланс 350 Р",
                "Подключен",
                "Нет",
                "",
                "",
                ""));

        ArrayList<Integer> images = new ArrayList<Integer>(Arrays.asList(
                R.drawable.ic_bill,
                R.drawable.ic_counter,
                R.drawable.ic_installment,
                R.drawable.ic_insurance,
                R.drawable.ic_internet_tv,
                R.drawable.ic_intercom,
                R.drawable.ic_security,
                R.drawable.ic_contacts,
                R.drawable.ic_applications,
                R.drawable.ic_memo));

        for (int i = 0; i < headers.size(); i++) {
            data.add(new CardInfo(headers.get(i), info.get(i), images.get(i)));
        }

        return data;
    }
}