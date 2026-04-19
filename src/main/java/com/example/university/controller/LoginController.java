package com.example.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/adminDashboard")
    public String adminDashboard(){
        return "admin-dashboard";
    }

    @GetMapping("/studentDashboard")
    public String studentDashboard(){
        return "student-dashboard";
    }

    @GetMapping("/teacherDashboard")
    public String teacherDashboard(){
        return "teacher-dashboard";
    }
}