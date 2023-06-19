package com.example.sample_exercises.service;

import com.example.sample_exercises.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getList();
    void addStudent(Student student);
    Student findStudent(int id);
    void delete(int id);
}
