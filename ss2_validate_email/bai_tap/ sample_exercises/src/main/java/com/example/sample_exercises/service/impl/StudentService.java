package com.example.sample_exercises.service.impl;
import com.example.sample_exercises.model.Student;
import com.example.sample_exercises.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService implements IStudentService {
    private static List<Student> students=new ArrayList<>();
    static {
        students.add(new Student(1,"Nguyễn Anh Nhàn",true ,"1995-07-29","15DT1","Khoa Điện"));
        students.add(new Student(2,"Nguyễn Long Vũ",true,"1997-03-15","14H1","Khoa Hóa"));
        students.add(new Student(3,"Nguyễn Long Uyên",false,"1996-09-27","16KT1","Khoa Kỹ Thuật"));
    }

    @Override
    public List<Student> getList() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }
}
