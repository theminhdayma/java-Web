package com.data.session04.Bai6;

public class Student {
    private int id;
    private String name;
    private int age;
    private double gpa;

    public Student(int id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
}

