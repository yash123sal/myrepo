package com.example.university.controller;

import com.example.university.entity.Enrollment;
import com.example.university.entity.Result;
import com.example.university.entity.Student;
import com.example.university.repository.EnrollmentRepository;
import com.example.university.repository.ResultRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private ResultRepository resultRepository;
    
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getStudents(){
        return service.getAllStudents();
        
    }
    
    @GetMapping("/profile")
    public Student getProfile(Authentication authentication) {
        String email = authentication.getName();
        return studentRepository.findByEmail(email).orElse(null);
    }
    
    @GetMapping("/myResults")
    public List<Result> getMyResults(Authentication authentication) {
        String email = authentication.getName();
        Student student = studentRepository.findByEmail(email).orElse(null);
        if(student != null) {
            return resultRepository.findByStudentId(student.getStudentId());
        }
        return List.of();
    }
    
    @PostMapping("/enroll")
    public Enrollment enrollCourse(@RequestBody Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }
}