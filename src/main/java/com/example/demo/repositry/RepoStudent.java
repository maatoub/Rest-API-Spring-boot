package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Student;

public interface RepoStudent extends JpaRepository<Student, Integer> {

}
