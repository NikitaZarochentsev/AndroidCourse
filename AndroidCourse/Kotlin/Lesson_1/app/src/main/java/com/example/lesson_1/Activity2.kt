package com.example.lesson_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*

class Activity2 : AppCompatActivity() {
    private var studentsHashMap: HashMap<Int, Student> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        editTextInputStudentAct2.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val inputStr = editTextInputStudentAct2.text.toString().trim()
                editTextInputStudentAct2.setText("")
                if (inputStr != "") {
                    val parts = inputStr.split(" ")
                    if (parts.size != 4) {
                        Toast.makeText(
                            this,
                            R.string.incorrect_input_toast_act2,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val id = System.currentTimeMillis().toInt()
                        val student =
                            Student(id, parts[0], parts[1], parts[2], parts[3].toIntOrNull() ?: -1)
                        studentsHashMap[id] = student

                        Toast.makeText(
                            this,
                            R.string.success_student_added_toast_act2,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this,
                        R.string.failure_student_added_toast_act2,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            true
        }

        buttonShowListOfStudentsAct2.setOnClickListener {
            if (studentsHashMap.isNotEmpty()) {
                for (studentHashMap in studentsHashMap) {
                    textViewListOfStudentsAct2.setText(
                        String.format(
                            getString(R.string.line_list_of_students_textView_act2),
                            textViewListOfStudentsAct2.text, studentHashMap.value
                        )
                    )
                }
            } else {
                Toast.makeText(this, R.string.empty_hashMap_toast_act2, Toast.LENGTH_SHORT).show()
            }

            buttonShowListOfStudentsAct2.hideKeyboard()
        }
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}