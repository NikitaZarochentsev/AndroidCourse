package com.example.lesson_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var studentList: TreeSet<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.studentList = TreeSet()

        saveInArrayButton.setOnClickListener {
            if (this.editText.text.toString().trim().isNotEmpty()) {
                val name = editText.text.toString()
                this.studentList.add(name)

                Toast.makeText(this, "Имя $name сохранено", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Заполните поле ввода", Toast.LENGTH_SHORT).show()
            }
        }

        outputButton.setOnClickListener {
            this.textView.text = ""
            for (student in this.studentList) {
                val newStudentLine = textView.text.toString() + student + "\n"
                textView.setText(newStudentLine)
            }

            Toast.makeText(
                this,
                "Выведено ${this.studentList.size.toString()} элементов",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}