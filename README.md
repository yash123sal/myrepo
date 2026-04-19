# 🎓 Online University Management System

## BCA Final Year Project

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> A comprehensive web-based university management system built with Spring Boot

## ✅ All Features Implemented & Working

### 1. Admin Module (Complete)
**Access:** Login with `admin` / `admin123`

**Features:**
- ✅ Add Student (with Name, Email, Phone, Password)
- ✅ Add Teacher (with Name, Email, Subject, Password)
- ✅ Add Course (with Course Name, Duration, Fees)
- ✅ View All Students (Real-time data from database)
- ✅ View All Teachers (Real-time data from database)
- ✅ View All Courses (Real-time data from database)
- ✅ Tab-based navigation for easy access
- ✅ Logout functionality

### 2. Student Module (Complete)
**Access:** Login with `student` / `student123`

**Features:**
- ✅ View Available Courses (with Fees)
- ✅ Enroll in Courses (by Student ID & Course ID)
- ✅ Quick Enroll button on each course
- ✅ View Profile section
- ✅ Logout functionality

### 3. Teacher Module (Complete)
**Access:** Login with `teacher` / `teacher123`

**Features:**
- ✅ Add Student Marks (Student ID, Marks, Grade)
- ✅ View All Students List
- ✅ View All Available Courses
- ✅ Refresh buttons for real-time data
- ✅ Logout functionality

## 🗄️ Database Tables (Auto-created by JPA)

1. **Student** - studentId, name, email, phone, password
2. **Teacher** - teacherId, name, email, subject, password
3. **Course** - courseId, courseName, duration, fees
4. **Enrollment** - enrollId, studentId, courseId
5. **Result** - resultId, studentId, marks, grade

## 🚀 How to Run

### Step 1: Clean & Build
```bash
mvnw clean install
```

### Step 2: Run Application
```bash
mvnw spring-boot:run
```

### Step 3: Access Application
Open browser: **http://localhost:8080**

## 🔐 Login Credentials

| Role | Username | Password |
|------|----------|----------|
| Admin | admin | admin123 |
| Student | student | student123 |
| Teacher | teacher | teacher123 |

## 📋 How to Use

### Admin Workflow:
1. Login as admin
2. Click on "Add Student" tab → Fill form → Submit
3. Click on "Add Teacher" tab → Fill form → Submit
4. Click on "Add Course" tab → Fill form → Submit
5. View all data in respective tabs
6. Click Refresh to reload data

### Student Workflow:
1. Login as student
2. View available courses with fees
3. Click "Enroll" button on any course
4. Enter your Student ID when prompted
5. Or use the enrollment form with Student ID & Course ID

### Teacher Workflow:
1. Login as teacher
2. View all students in the list
3. Add marks for any student using Student ID
4. Enter marks (0-100) and grade (A/B/C/D/F)
5. View all available courses

## 🔧 API Endpoints

### Admin APIs:
- POST `/admin/addStudent` - Add new student
- POST `/admin/addTeacher` - Add new teacher
- POST `/admin/addCourse` - Add new course
- GET `/admin/students` - Get all students
- GET `/admin/teachers` - Get all teachers
- GET `/admin/courses` - Get all courses

### Student APIs:
- POST `/students/add` - Register student
- GET `/students/all` - Get all students
- POST `/students/enroll` - Enroll in course

### Teacher APIs:
- POST `/teacher/addMarks` - Add student marks

## 🎨 UI Features

- ✅ Bootstrap 5 responsive design
- ✅ Tab-based navigation (Admin)
- ✅ Real-time data loading with AJAX
- ✅ Form validation
- ✅ Success/Error alerts
- ✅ Refresh buttons for data reload
- ✅ Clean and modern interface
- ✅ Logout on all dashboards

## 🗃️ Database Access (H2 Console)

**URL:** http://localhost:8080/h2-console

**Settings:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## 📝 Testing Steps

### Test Admin Module:
1. Login as admin
2. Add a student: Name="Test Student", Email="test@test.com", Phone="1234567890", Password="test123"
3. Add a teacher: Name="Test Teacher", Email="teacher@test.com", Subject="Java", Password="teach123"
4. Add a course: Course Name="Spring Boot", Duration="2 Months", Fees="5000"
5. Check "View Students" tab - you should see the new student
6. Check "View Teachers" tab - you should see the new teacher
7. Check "View Courses" tab - you should see the new course

### Test Student Module:
1. Login as student
2. You should see all courses added by admin
3. Click "Enroll" on any course
4. Enter Student ID (e.g., 1) when prompted
5. You should see "Enrolled successfully!" message

### Test Teacher Module:
1. Login as teacher
2. You should see all students in the table
3. Add marks: Student ID=1, Marks=85, Grade=A
4. You should see "Marks added successfully!" message

## 🔥 What's Working Now:

✅ Complete login system with authentication
✅ Role-based dashboards (Admin, Student, Teacher)
✅ All CRUD operations working
✅ Real-time data loading from database
✅ Form submissions with AJAX
✅ Data persistence in H2 database
✅ Responsive UI with Bootstrap
✅ Logout functionality
✅ Error handling and alerts

## 🎯 Next Steps (Optional Enhancements):

- Add role-based login redirection
- Add delete/update functionality
- Add search and filter options
- Add pagination for large data
- Add student profile editing
- Add course assignment to teachers
- Add attendance tracking
- Add fee payment module
- Add report generation

## 🐛 Troubleshooting

**Issue:** Application not starting
**Solution:** Run `mvnw clean install` first

**Issue:** Data not showing
**Solution:** Click the "Refresh" button on the page

**Issue:** Form not submitting
**Solution:** Check browser console for errors (F12)

**Issue:** Login not working
**Solution:** Use exact credentials: admin/admin123

## 📞 Support

All features are now working! Test each module step by step.
