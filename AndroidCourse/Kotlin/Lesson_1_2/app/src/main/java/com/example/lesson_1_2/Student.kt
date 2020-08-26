package com.example.lesson_1_2

class Student (val id: Int, val name: String, val surname: String, val grade: String, val birthdayYear: Int) {
    override fun toString(): String {
        val outputString = "$id $name $surname $grade $birthdayYear"
        return outputString
    }
}