package com.example.lesson_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_circle:
                    CircleDialogFragment dialog = new CircleDialogFragment();
                    dialog.show(getSupportFragmentManager(), "custom");
                    break;
                case R.id.item_home:
                    Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });

        ArrayList<BaseInfoItem> cards = fillData();

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

        recyclerView.addItemDecoration(new CharacterItemDecoration(24));
    }

    public static class CharacterItemDecoration extends RecyclerView.ItemDecoration {
        private final int offset;

        public CharacterItemDecoration(int offset) {
            this.offset = offset;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();

            if (layoutParams.getSpanIndex() % 2 != 0) {
                outRect.left = offset;
            }

            outRect.bottom = offset;
        }
    }

    ArrayList<BaseInfoItem> fillData() {
        ArrayList<BaseInfoItem> data = new ArrayList<>();

        ArrayList<String> headers = new ArrayList<>(Arrays.asList(
                "Квитанции",
                "Счетчики",
                "Рассрочка",
                "Страхование",
                "Интернет и ТВ",
                "Домофон",
                "Охрана",
                "Контакты УК и служб",
                "Мои заявки",
                "Памятка жителя A101"));

        ArrayList<String> info = new ArrayList<>(Arrays.asList(
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

        ArrayList<Integer> images = new ArrayList<>(Arrays.asList(
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

        ArrayList<Boolean> attentions = new ArrayList<>(Arrays.asList(
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false));

        // разделить на detail и base
        for (int i = 0; i < headers.size(); i++) {
            if (!info.get(i).equals("")) {
                data.add(new DetailInfoItem(headers.get(i), info.get(i), images.get(i), attentions.get(i)));
            } else {
                data.add(new BaseInfoItem(headers.get(i), images.get(i)));
            }
        }

        return data;
    }
}