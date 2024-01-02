package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Student;
import com.example.demo.repositry.RepoStudent;

@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private RepoStudent repoStudent;

    @Override
    public List<Student> getStudentList() {
        return repoStudent.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = repoStudent.findById(id);
        if (student.isPresent()) {
            Student s = student.get();
            return s;
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        repoStudent.deleteById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        repoStudent.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        repoStudent.save(student);
        return student;
    }
}
