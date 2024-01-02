package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Student;

public interface StudentService {
    List<Student> getStudentList();

    Student getStudent(Long id);

    void deleteStudent(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);
}