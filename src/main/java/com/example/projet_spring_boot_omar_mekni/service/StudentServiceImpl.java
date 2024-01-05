package com.example.projet_spring_boot_omar_mekni.service;

import com.example.projet_spring_boot_omar_mekni.entity.Student;
import com.example.projet_spring_boot_omar_mekni.exeption.NotFoundException;
import com.example.projet_spring_boot_omar_mekni.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //construttore
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // SALVARE STUDENTE ///////////////////////////////////////////////////////////////
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // CERCARE PER ID ///////////////////////////////////////////////////////////////
    @Override
    public Student findStudentById(int id) {
        Student student = null;
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
        {
            student = optionalStudent.get();
        }
        else
        {
            throw new NotFoundException("L'étudiant avec l'Id " + id + " n'existe pas.");
        }
        return student;
    }

    // CANCELLARE PER ID ///////////////////////////////////////////////////////////////
    @Override
    public boolean deleteStudentById(int id) {
        Student student = null;
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
        {
            studentRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }

    }

    // VISUALIZZARE LA LISTA DI STUDENTI ///////////////////////////////////////////////////////////////
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
