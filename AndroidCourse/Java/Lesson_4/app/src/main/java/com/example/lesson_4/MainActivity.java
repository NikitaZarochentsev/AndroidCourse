package com.example.lesson_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

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
    }
}