package com.example.lesson_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var studentList: TreeSet<String> = TreeSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSaveInArray.setOnClickListener {
            if (editTextInputStudent.text.toString().trim().isNotEmpty()) {
                val name = editTextInputStudent.text.toString()
                studentList.add(name)

                Toast.makeText(
                    this,
                    String.format(getString(R.string.save_student_text), name),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, R.string.not_save_student_text, Toast.LENGTH_SHORT).show()
            }
        }

        buttonOutput.setOnClickListener {
            textViewOutput.text = ""
            for (student in this.studentList) {
                val newStudentLine = "${textViewOutput.text.toString()}$student\n"
                textViewOutput.text = newStudentLine
            }

            Toast.makeText(
                this,
                String.format(getString(R.string.output_message_text), studentList.size),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}