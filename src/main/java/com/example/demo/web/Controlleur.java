package com.example.demo.web;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

import java.util.List;

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
@RequestMapping("/students")
public class Controlleur {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> allStudents() {
        return studentService.getStudentList();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setCode(id);
        studentService.updateStudent(student);
        return student;
    }
}
