package com.example.lesson_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_with_c_l.*

class WithCLActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_c_l)

        setSupportActionBar(main_toolbar as? Toolbar)

        textViewName.setText(R.string.name_default)
        textViewSurname.setText(R.string.surname_default)
        textViewEmail.setText(R.string.email_default)
        textViewLogin.setText(R.string.login_default)
        textViewRegion.setText(R.string.region_default)

        (textViewToolbar as? TextView)?.setText(
            String.format(
                getString(R.string.card_text), getString(
                    R.string.number_of_card_default
                )
            )
        )

        buttonLogout.setOnClickListener {
            Toast.makeText(this, getString(R.string.logout_text), Toast.LENGTH_SHORT).show()
        }

        buttonEdit.setOnClickListener {
            Toast.makeText(this, getString(R.string.edit_text), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.item_edit -> Toast.makeText(
                this,
                getString(R.string.edit_text),
                Toast.LENGTH_SHORT
            ).show()
        }

        return super.onOptionsItemSelected(item)
    }
}