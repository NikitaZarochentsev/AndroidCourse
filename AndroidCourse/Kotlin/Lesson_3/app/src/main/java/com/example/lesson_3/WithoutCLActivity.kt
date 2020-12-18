package com.example.lesson_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_with_c_l.*
import kotlinx.android.synthetic.main.activity_without_c_l.*

class WithoutCLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_c_l)

        toolbarWithoutCL.inflateMenu(R.menu.menu)
        toolbarWithoutCL.setNavigationOnClickListener {
            onBackPressed()
        }

        toolbarWithoutCL.setOnMenuItemClickListener {
            when (it.itemId) {
                android.R.id.home -> onBackPressed()
                R.id.item_edit -> Toast.makeText(
                    this,
                    getString(R.string.edit_toast),
                    Toast.LENGTH_SHORT
                ).show()
            }

            return@setOnMenuItemClickListener true
        }

        textViewNameWithoutCL.setText(R.string.name_default)
        textViewSurnameWithoutCL.setText(R.string.surname_default)
        textViewEmailWithoutCL.setText(R.string.email_default)
        textViewLoginWithoutCL.setText(R.string.login_default)
        textViewRegionWithoutCL.setText(R.string.region_default)

        (textViewNumberCardWithoutCL)?.setText(
            String.format(
                getString(R.string.number_card_textView_appbar),
                getString(R.string.number_of_card_default)
            )
        )

        buttonEditWithoutCL.setOnClickListener {
            Toast.makeText(this, getString(R.string.edit_toast), Toast.LENGTH_SHORT).show()
        }

        buttonLogoutWithoutCL.setOnClickListener {
            Toast.makeText(this, getString(R.string.logout_toast), Toast.LENGTH_SHORT).show()
        }
        buttonEditWithoutCL.setOnClickListener {
            Toast.makeText(this, R.string.edit_toast, Toast.LENGTH_SHORT).show()
        }
    }
}