package com.example.university.config;

import com.example.university.entity.Student;
import com.example.university.entity.Teacher;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // Check if admin
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{noop}admin123")
                    .roles("ADMIN")
                    .build();
        }
        
        // Check in students by email
        Student student = studentRepository.findByEmail(username).orElse(null);
        if (student != null) {
            return User.builder()
                    .username(student.getEmail())
                    .password("{noop}" + student.getPassword())
                    .roles("STUDENT")
                    .build();
        }
        
        // Check in teachers by email
        Teacher teacher = teacherRepository.findByEmail(username).orElse(null);
        if (teacher != null) {
            return User.builder()
                    .username(teacher.getEmail())
                    .password("{noop}" + teacher.getPassword())
                    .roles("TEACHER")
                    .build();
        }
        
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
