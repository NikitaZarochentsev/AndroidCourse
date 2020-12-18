package com.example.lesson_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_with_c_l.*

class WithCLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_c_l)

        toolbarWithCL.inflateMenu(R.menu.menu)
        toolbarWithCL.setNavigationOnClickListener {
            onBackPressed()
        }

        toolbarWithCL.setOnMenuItemClickListener {
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

        textViewNameWithCL.setText(R.string.name_default)
        textViewSurnameWithCL.setText(R.string.surname_default)
        textViewEmailWithCL.setText(R.string.email_default)
        textViewLoginWithCL.setText(R.string.login_default)
        textViewRegionWithCL.setText(R.string.region_default)

        textViewNumberCardWithCL?.text = String.format(
            getString(R.string.number_card_textView_appbar), getString(
                R.string.number_of_card_default
            )
        )

        buttonLogoutWithCL.setOnClickListener {
            Toast.makeText(this, getString(R.string.logout_toast), Toast.LENGTH_SHORT).show()
        }

        buttonEditWithCL.setOnClickListener {
            Toast.makeText(this, getString(R.string.edit_toast), Toast.LENGTH_SHORT).show()
        }
    }
}