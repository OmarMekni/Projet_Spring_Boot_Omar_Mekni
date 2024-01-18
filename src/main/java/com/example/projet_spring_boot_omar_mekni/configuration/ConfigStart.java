package com.example.projet_spring_boot_omar_mekni.configuration;

import com.example.projet_spring_boot_omar_mekni.entity.Student;
import com.example.projet_spring_boot_omar_mekni.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ConfigStart implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.findAll().isEmpty())
        {
            createStudent();
        }
    }

    @Transactional
    public void createStudent() {

        // Creation des 10 étudiants -------------
        Student student1 = new Student("Marco", "De Biasi", "Programmation");
        Student student2 = new Student("Francesco", "Marchisio", "Biologie");
        Student student3 = new Student("Sofia", "Liati", "Informatique");
        Student student4 = new Student("Luca", "Panetto", "Physique");
        Student student5 = new Student("Martino", "Grande", "Mathématiques");
        Student student6 = new Student("Paolo", "De Luca", "Programmation");
        Student student7 = new Student("Giuseppe", "Patrizzi", "Physique");
        Student student8 = new Student("Franco", "Malincor", "Biologie");
        Student student9 = new Student("Nicola", "Mammelli", "Informatique");
        Student student10 = new Student("Tommaso", "Civali", "Programmation");

        // Sauvegarder tous les éléments avec confirmation -----
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityManager.persist(student6);
        entityManager.persist(student7);
        entityManager.persist(student8);
        entityManager.persist(student9);
        entityManager.persist(student10);
    }
}
