package com.example.lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class WithoutCLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_cl);


        Toolbar toolbar = findViewById(R.id.toolbarWithoutCL);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                final int item_edit_id = R.id.item_edit;

                switch (item.getItemId()) {
                    case android.R.id.home:
                        onBackPressed();
                        break;
                    case item_edit_id:
                        Toast.makeText(WithoutCLActivity.this, getString(R.string.edit_toast), Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

        TextView textViewName = findViewById(R.id.textViewNameWithoutCL);
        textViewName.setText(R.string.name_default);
        TextView textViewSurname = findViewById(R.id.textViewSurnameWithoutCL);
        textViewSurname.setText(R.string.surname_default);
        TextView textViewEmail = findViewById(R.id.textViewEmailWithoutCL);
        textViewEmail.setText(R.string.email_default);
        TextView textViewLogin = findViewById(R.id.textViewLoginWithoutCL);
        textViewLogin.setText(R.string.login_default);
        TextView textViewRegion = findViewById(R.id.textViewRegionWithoutCL);
        textViewRegion.setText(R.string.region_default);

        TextView textViewNumberCard = findViewById(R.id.textViewNumberCardWithoutCL);
        textViewNumberCard.setText(String.format(getString(R.string.number_card_textView_appbar), getString(R.string.number_of_card_default)));

        ImageButton buttonEdit = findViewById(R.id.buttonEditWithoutCL);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WithoutCLActivity.this, getString(R.string.edit_toast), Toast.LENGTH_SHORT).show();
            }
        });

        TextView buttonLogout = findViewById(R.id.buttonLogoutWithoutCL);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WithoutCLActivity.this, getString(R.string.logout_toast), Toast.LENGTH_SHORT).show();
            }
        });
    }
}