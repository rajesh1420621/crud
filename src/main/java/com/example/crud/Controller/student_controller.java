package com.example.crud.Controller;


import com.example.crud.Student.Student;
import com.example.crud.Student.Student_Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class student_controller {


    public student_controller(Student_Service student_service) {
        this.student_service = student_service;
    }

    private Student_Service student_service;


    @GetMapping
    public List<Student> getStudents() {
        return student_service.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        student_service.addStudents(student);
    }

@DeleteMapping(path = "{studentId}")
    public  void  deleteStudent(@PathVariable ("studentId")Long studnetId){
        student_service.deleteStudent(studnetId);

    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable ("studentId")Long studnetId,
                @RequestParam(required = false) String name,
                        @RequestParam(required = false) String email){
            student_service.updateStudent(studnetId,name,email);
        }

    }

