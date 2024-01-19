package com.example.projet_spring_boot_omar_mekni.controleur;

import com.example.projet_spring_boot_omar_mekni.entity.Student;
import com.example.projet_spring_boot_omar_mekni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentControleur {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id)
    {
        boolean deleted = studentService.deleteStudentById(id);
        if(deleted)
        {
            return ResponseEntity.ok("L'étudiant avec l'Id " + id + " est supprimé!!!");
        }
        else
        {
            return ResponseEntity.badRequest().body("L'étudiant avec l'id " + id + " n'existe pas.");
        }
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/student-recherche/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = Optional.ofNullable(studentService.findStudentById(id));
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
