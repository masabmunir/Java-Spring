package com.example.demo.student;
import com.example.demo.student.dto.StudentDTO;
import com.example.demo.student.model.Student;
import com.example.demo.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class studentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO addNewStudent(StudentDTO studentDTO) {
        studentDTO.setId(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        Student student = convertDTOToModel(studentDTO);
        studentRepository.save(student);
        return convertModelToDTO(student);
    }



    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    private static Student convertDTOToModel(StudentDTO studentDTO) {
        Student student = new Student();
        student.setAge(studentDTO.getAge());
        student.setName(studentDTO.getName());
        student.setDob(studentDTO.getDob());
        student.setEmail(studentDTO.getEmail());
        return student;
    }

    public static StudentDTO convertModelToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setAge(student.getAge());
        studentDTO.setName(student.getName());
        studentDTO.setDob(student.getDob());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setId(studentDTO.getId());
        return studentDTO;
    }

    public void deleteStudent(Long studentId) {
       boolean exists = studentRepository.existsById(studentId);
       if(!exists){
           throw new IllegalStateException("Student with Id " + studentId + "does not exists");
       }
       studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("Student with id" + studentId + "does not exists"));

        if(name !=null &&
                         !name.isEmpty() &&
                         !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email !=null &&
                         !email.isEmpty() &&
                         !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.
        }
    }
}
