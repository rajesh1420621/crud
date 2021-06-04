package com.example.crud.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class student_configuration {

    @Bean
    CommandLineRunner commandLineRunner(student_repository repository) {
        return args -> {
            Student pani = new Student(
                    1l,
                    "pani",
                    "pani@pani.com",
                    LocalDate.of(2000, Month.JANUARY, 17)

            );
            Student grahi = new
                    Student(
                    "grahi",
                    "grahi@pani.com",
                    LocalDate.of(2001, Month.JANUARY, 17)

            );
            repository.saveAll(List.of(pani,grahi));
        };
    }
}
