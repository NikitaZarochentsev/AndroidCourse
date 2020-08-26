package com.example.lesson_1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Map

class MainActivity : AppCompatActivity() {
    private var studentsHashMap: HashMap<Int, Student> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.setOnKeyListener(View.OnKeyListener {view, keyCode, event ->
            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                var inputStr = editText.text.toString().trim()
                if (!inputStr.equals("")) {
                    var parts = inputStr.split(" ")
                    var id = System.currentTimeMillis().toInt()
                    var student = Student(id, parts[0],parts[1], parts[2], parts[3].toInt())
                    studentsHashMap.put(id, student)

                    editText.setText("")
                    Toast.makeText(applicationContext, R.string.textStudentAdded, Toast.LENGTH_SHORT).show()

                    return@OnKeyListener true
                }
                else {
                    Toast.makeText(applicationContext, R.string.textStudentNotAdded, Toast.LENGTH_SHORT).show()
                }
            }

            return@OnKeyListener false
        })

        button.setOnClickListener{
            if (!studentsHashMap.isEmpty()) {
                for (studentHashMap in studentsHashMap) {
                    val outputText = textView.text.toString() + studentHashMap.value.toString() + "\n"
                    textView.setText(outputText)
                }
            }
            else {
                Toast.makeText(applicationContext, R.string.textEmpty, Toast.LENGTH_SHORT).show()
            }
        }
    }
}