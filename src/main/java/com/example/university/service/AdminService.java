package com.example.university.service;

import com.example.university.entity.Course;
import com.example.university.entity.Student;
import com.example.university.entity.Teacher;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    
    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }
    
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}