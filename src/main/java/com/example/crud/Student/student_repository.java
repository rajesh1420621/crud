package com.example.crud.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface student_repository extends JpaRepository<Student,Long> {

//        @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student>findStudentByEmail(String email);
}
