package com.example.lesson_1;

public class Student {
    private final int id;
    private final String name;
    private final String surname;
    private final String grade;
    private final int birthdayYear;

    public Student(int id, String name, String surname, String grade, int birthdayYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.birthdayYear = birthdayYear;
    }

    @Override
    public String toString() {
        return id +
                " " + name +
                " " + surname +
                " " + grade +
                " " + birthdayYear;
    }
}
