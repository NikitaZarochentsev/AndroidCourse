package com.example.lesson_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMain.setNavigationOnClickListener { onBackPressed() }

        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item_circle -> {
                    val dialogFragment = CircleDialogFragment()
                    dialogFragment.show(supportFragmentManager, "custom")
                }
                R.id.item_home -> {
                    Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}