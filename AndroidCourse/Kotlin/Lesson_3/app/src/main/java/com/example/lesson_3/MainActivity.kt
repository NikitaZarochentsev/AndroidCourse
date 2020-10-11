package com.example.lesson_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonWithoutCL.setOnClickListener{
            startActivity(Intent(this, WithoutCLActivity::class.java))
        }

        buttonWithCL.setOnClickListener{
            startActivity(Intent(this, WithCLActivity::class.java))
        }
    }
}