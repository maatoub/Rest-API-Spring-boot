package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Student;
import com.example.demo.exceptions.StudentNotFound;

public interface StudentService {
    List<Student> getStudentList();

    Student getStudent(Long id) throws StudentNotFound;

    void deleteStudent(Long id) throws StudentNotFound;

    Student saveStudent(Student student);

    Student updateStudent(Student student) throws StudentNotFound;
}