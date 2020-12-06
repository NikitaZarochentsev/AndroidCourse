package com.example.lesson_1

class Student(
    private val id: Int,
    private val name: String,
    private val surname: String,
    private val grade: String,
    private val birthdayYear: Int
) {
    override fun toString(): String = "$id $name $surname $grade $birthdayYear"
}