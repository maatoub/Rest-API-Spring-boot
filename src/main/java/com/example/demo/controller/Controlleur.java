package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repositry.RepoStudent;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class Controlleur {
    @Autowired
    RepoStudent repoStudent;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        repoStudent.save(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> allStudents() {
        List<Student> students = repoStudent.findAll();
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Optional<Student> student = repoStudent.findById(id);
        if (student.isPresent()) {
            Student s = student.get();
            return s;
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delStudent(@PathVariable("id") int id) {
        repoStudent.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        Optional<Student> delStudent = repoStudent.findById(id);

        Student s = delStudent.get();
        s.setNom(student.getNom());
        s.setPrenom(student.getPrenom());
        repoStudent.save(s);
        return s;
    }
}
