package com.example.lesson_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class WithCLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_c_l);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(R.string.name_default);
        TextView textViewSurname = findViewById(R.id.textViewSurname);
        textViewSurname.setText(R.string.surname_default);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(R.string.email_default);
        TextView textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setText(R.string.login_default);
        TextView textViewRegion = findViewById(R.id.textViewRegion);
        textViewRegion.setText(getString(R.string.region_default));

        TextView textViewToolbar = findViewById(R.id.textViewToolbar);
        textViewToolbar.setText(String.format(getString(R.string.card_text), getString(R.string.number_of_card_default)));

        TextView textViewButtonLogout = findViewById(R.id.buttonLogout);
        textViewButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), getString(R.string.logout_text), Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton buttonEdit = findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), getString(R.string.edit_text), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.item_edit:
                Toast.makeText(this, R.string.edit_text, Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}