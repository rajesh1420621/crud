package com.example.crud.Student;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class Student_Service {

    public Student student;

    @Autowired
    public Student_Service(student_repository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final student_repository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();


    }

    public void addStudents(Student student) {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
boolean exists=studentRepository.existsById(studentId);
if(!exists){
    throw new IllegalStateException(
"student with id" +studentId+"does not exist"
    );
}
studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studnetId, String name, String email) {
        Student student= studentRepository.findById(studnetId).orElseThrow(()-> new IllegalStateException(
                "student with id "+ studnetId+"does not exist"
        ));
         if(name!=null && name.length()>0&&!Objects.equals(student.getName(),name)){
             student.setName(name);
         }
        if(email!=null && email.length()>0&&!Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setName(email);
        }
    }
}
