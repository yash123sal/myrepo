package com.example.university.controller;

import com.example.university.entity.Result;
import com.example.university.entity.Teacher;
import com.example.university.repository.ResultRepository;
import com.example.university.repository.TeacherRepository;
import com.example.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/addMarks")
    public Result addMarks(@RequestBody Result result){
        return teacherService.addMarks(result);
    }
    
    @GetMapping("/profile")
    public Teacher getProfile(Authentication authentication) {
        String email = authentication.getName();
        return teacherRepository.findByEmail(email).orElse(null);
    }
    
    @GetMapping("/results")
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}