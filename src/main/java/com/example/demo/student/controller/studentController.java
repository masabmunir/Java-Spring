package com.example.demo.student.controller;

import com.example.demo.student.dto.StudentDTO;
import com.example.demo.student.model.Student;
import com.example.demo.student.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class studentController {

    @Autowired
    private studentService StudentService;

    @GetMapping
    public List<Student> getStudents() {
        return StudentService.getStudents();
    }

    @PostMapping
    public StudentDTO registerNewStudent(@RequestBody StudentDTO Student) {
        return StudentService.addNewStudent(Student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable ("studentId") Long studentId,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String email) {

        StudentService.updateStudent(studentId,name,email);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        StudentService.deleteStudent(studentId);
    }
}
