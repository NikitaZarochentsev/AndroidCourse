package com.example.lesson_1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var studentsHashMap: HashMap<Int, Student> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextStudent.setOnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val inputStr = editTextStudent.text.toString().trim()
                editTextStudent.setText("")
                if (inputStr != "") {
                    val parts = inputStr.split(" ")
                    if (parts.size != 4) {
                        Toast.makeText(
                            this,
                            R.string.text_incorrect_input_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        val id = System.currentTimeMillis().toInt()
                        val student =
                            Student(id, parts[0], parts[1], parts[2], parts[3].toIntOrNull() ?: -1)
                        studentsHashMap[id] = student

                        Toast.makeText(
                            applicationContext,
                            R.string.text_student_added,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        R.string.text_student_not_added,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            true
        }

        buttonShowListOfStudents.setOnClickListener {
            if (studentsHashMap.isNotEmpty()) {
                for (studentHashMap in studentsHashMap) {
                    val outputText =
                        "${textViewListOfStudents.text.toString()}${studentHashMap.value.toString()}\n"
                    textViewListOfStudents.text = outputText
                }
            } else {
                Toast.makeText(applicationContext, R.string.text_empty, Toast.LENGTH_SHORT).show()
            }
        }
    }
}