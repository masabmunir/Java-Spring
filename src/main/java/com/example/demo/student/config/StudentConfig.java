package com.example.demo.student.config;

import com.example.demo.student.repository.StudentRepository;
import com.example.demo.student.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner CommandLineRunner(StudentRepository repository){

        return args -> {
         Student Masab = new Student(
                    Math.abs(UUID.randomUUID().getMostSignificantBits()),
                    "Masab",
                    "masabk214@gmail.com",
                    LocalDate.of(2005, Month.DECEMBER,12).toString(),
                   12
            );
            Student Ali = new Student(
                    Math.abs(UUID.randomUUID().getMostSignificantBits()),
                    "Ali",
                    "masabk214@gmail.com",
                    "12-03-2023",
                    24
            );

            repository.saveAll(
                 List.of(Masab,Ali)
            );
        };
    }
}
