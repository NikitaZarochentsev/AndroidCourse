package com.example.lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class WithCLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_c_l);

        Toolbar toolbar = findViewById(R.id.toolbarWithCL);
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
                        Toast.makeText(WithCLActivity.this, getString(R.string.edit_toast), Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

        TextView textViewName = findViewById(R.id.textViewNameWithCL);
        textViewName.setText(R.string.name_default);
        TextView textViewSurname = findViewById(R.id.textViewSurnameWithCL);
        textViewSurname.setText(R.string.surname_default);
        TextView textViewEmail = findViewById(R.id.textViewEmailWithCL);
        textViewEmail.setText(R.string.email_default);
        TextView textViewLogin = findViewById(R.id.textViewLoginWithCL);
        textViewLogin.setText(R.string.login_default);
        TextView textViewRegion = findViewById(R.id.textViewRegionWithCL);
        textViewRegion.setText(getString(R.string.region_default));

        TextView textViewNumberCard = findViewById(R.id.textViewNumberCardWithCL);
        textViewNumberCard.setText(String.format(getString(R.string.number_card_textView_appbar), getString(R.string.number_of_card_default)));

        TextView buttonLogout = findViewById(R.id.buttonLogoutWithCL);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WithCLActivity.this, getString(R.string.logout_toast), Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton buttonEdit = findViewById(R.id.buttonEditWithCL);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WithCLActivity.this, getString(R.string.edit_toast), Toast.LENGTH_SHORT).show();
            }
        });
    }
}