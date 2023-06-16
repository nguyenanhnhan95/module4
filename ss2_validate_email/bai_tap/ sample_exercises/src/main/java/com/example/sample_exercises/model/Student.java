package com.example.sample_exercises.model;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private String birth;
    private String nameClass;
    private String department;

    public Student(int id, String name, boolean gender,String birth, String nameClass, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth=birth;
        this.nameClass = nameClass;
        this.department = department;
    }
    public Student(){}

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
