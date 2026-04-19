package com.example.university.controller;

import com.example.university.entity.Course;
import com.example.university.entity.Result;
import com.example.university.entity.Student;
import com.example.university.entity.Teacher;
import com.example.university.repository.ResultRepository;
import com.example.university.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return adminService.addStudent(student);
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return adminService.addTeacher(teacher);
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return adminService.addCourse(course);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return adminService.getStudents();
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(){
        return adminService.getTeachers();
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return adminService.getCourses();
    }
    
    @GetMapping("/results")
    public List<Result> getResults(){
        return resultRepository.findAll();
    }
    
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        adminService.deleteStudent(id);
    }
    
    @DeleteMapping("/deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable Long id){
        adminService.deleteTeacher(id);
    }
    
    @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourse(@PathVariable Long id){
        adminService.deleteCourse(id);
    }
}