package com.example.lesson_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_1.*
import java.util.*

class Activity1 : AppCompatActivity() {
    private var studentList: TreeSet<String> = TreeSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        buttonSaveInArrayAct1.setOnClickListener {
            if (editTextInputStudentAct1.text.toString().trim().isNotEmpty()) {
                val name = editTextInputStudentAct1.text.toString()
                studentList.add(name)
                editTextInputStudentAct1.setText("")

                Toast.makeText(
                    this,
                    String.format(getString(R.string.success_save_student_text_act1), name),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    R.string.empty_editTextInputStudent_text_act1,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonOutputAct1.setOnClickListener {
            textViewOutputAct1.text = ""
            for (student in studentList) {
                val newStudentLine = "${textViewOutputAct1.text}$student\n"
                textViewOutputAct1.text = newStudentLine
            }

            buttonOutputAct1.hideKeyboard()

            Toast.makeText(
                this,
                String.format(getString(R.string.output_message_text_act1), studentList.size),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}