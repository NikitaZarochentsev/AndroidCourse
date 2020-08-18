package com.example.lesson_1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var studentList: TreeSet<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.studentList = TreeSet<String>()

        saveInArrayButton.setOnClickListener(View.OnClickListener {
            if (editText.text.toString().trim().length != 0) {
                var name = editText.text.toString()
                this.studentList.add(name)
            }
        })

        outputButton.setOnClickListener(View.OnClickListener {
            textView.setText("")
            for (student in studentList) {
                var newStudentLine = textView.text.toString() + student + "\n"
                textView.setText(newStudentLine)
            }
        })
    }
}