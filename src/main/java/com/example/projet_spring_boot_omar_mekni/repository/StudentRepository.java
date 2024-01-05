package com.example.projet_spring_boot_omar_mekni.repository;

import com.example.projet_spring_boot_omar_mekni.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
