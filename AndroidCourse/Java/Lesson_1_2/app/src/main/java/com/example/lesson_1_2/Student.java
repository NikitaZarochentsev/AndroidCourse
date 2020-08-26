package com.example.lesson_1_2;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String grade;
    private int birthdayYear;

    public Student(int id, String name, String surname, String grade, int birthdayYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.birthdayYear = birthdayYear;
    }

    @Override
    public String toString() {
        String textStudent = String.valueOf(this.id) + " " + this.name + " " + this.surname + " " +
                this.grade + " " + String.valueOf(this.birthdayYear);

        return textStudent;
    }
}
