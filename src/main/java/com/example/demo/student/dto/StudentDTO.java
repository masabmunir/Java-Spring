package com.example.demo.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private String dob;
    private Integer age;


}
