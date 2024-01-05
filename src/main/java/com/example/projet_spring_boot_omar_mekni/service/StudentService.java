package com.example.projet_spring_boot_omar_mekni.service;

import com.example.projet_spring_boot_omar_mekni.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    Student findStudentById(int id);
    boolean deleteStudentById(int id);
    List<Student> findAll();
}
