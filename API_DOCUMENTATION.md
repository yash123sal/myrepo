# 📚 Complete API Documentation - Online University Management System

## 🎯 System Overview

### Modules Implemented:
1. **Admin Module** - Complete CRUD for Students, Teachers, Courses
2. **Student Module** - Course enrollment and viewing
3. **Teacher Module** - Add marks for students
4. **Authentication** - Role-based login system

---

## 🔐 Authentication

### Login Credentials:
| Role | Username | Password | Dashboard URL |
|------|----------|----------|---------------|
| Admin | admin | admin123 | /adminDashboard |
| Student | student | student123 | /studentDashboard |
| Teacher | teacher | teacher123 | /teacherDashboard |

### Login Endpoint:
- **URL:** `POST /login`
- **Form Data:**
  - username: string
  - password: string
- **Success:** Redirects to role-based dashboard
- **Failure:** Redirects to /login?error

---

## 📋 Admin APIs

### 1. Add Student
**Endpoint:** `POST /admin/addStudent`

**Request Body:**
```json
{
  "name": "Rahul Kumar",
  "email": "rahul@test.com",
  "phone": "9876543210",
  "password": "rahul123"
}
```

**Response:**
```json
{
  "studentId": 1,
  "name": "Rahul Kumar",
  "email": "rahul@test.com",
  "phone": "9876543210",
  "password": "rahul123"
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/admin/addStudent \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Rahul Kumar",
    "email": "rahul@test.com",
    "phone": "9876543210",
    "password": "rahul123"
  }'
```

---

### 2. Add Teacher
**Endpoint:** `POST /admin/addTeacher`

**Request Body:**
```json
{
  "name": "Priya Sharma",
  "email": "priya@test.com",
  "subject": "Mathematics",
  "password": "priya123"
}
```

**Response:**
```json
{
  "teacherId": 1,
  "name": "Priya Sharma",
  "email": "priya@test.com",
  "subject": "Mathematics",
  "password": "priya123"
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/admin/addTeacher \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Priya Sharma",
    "email": "priya@test.com",
    "subject": "Mathematics",
    "password": "priya123"
  }'
```

---

### 3. Add Course
**Endpoint:** `POST /admin/addCourse`

**Request Body:**
```json
{
  "courseName": "Java Full Stack",
  "duration": "6 Months",
  "fees": 25000
}
```

**Response:**
```json
{
  "courseId": 1,
  "courseName": "Java Full Stack",
  "duration": "6 Months",
  "fees": 25000.0
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/admin/addCourse \
  -H "Content-Type: application/json" \
  -d '{
    "courseName": "Java Full Stack",
    "duration": "6 Months",
    "fees": 25000
  }'
```

---

### 4. Get All Students
**Endpoint:** `GET /admin/students`

**Response:**
```json
[
  {
    "studentId": 1,
    "name": "Rahul Kumar",
    "email": "rahul@test.com",
    "phone": "9876543210",
    "password": "rahul123"
  },
  {
    "studentId": 2,
    "name": "Amit Singh",
    "email": "amit@test.com",
    "phone": "9876543211",
    "password": "amit123"
  }
]
```

**cURL Command:**
```bash
curl -X GET http://localhost:8080/admin/students
```

---

### 5. Get All Teachers
**Endpoint:** `GET /admin/teachers`

**Response:**
```json
[
  {
    "teacherId": 1,
    "name": "Priya Sharma",
    "email": "priya@test.com",
    "subject": "Mathematics",
    "password": "priya123"
  }
]
```

**cURL Command:**
```bash
curl -X GET http://localhost:8080/admin/teachers
```

---

### 6. Get All Courses
**Endpoint:** `GET /admin/courses`

**Response:**
```json
[
  {
    "courseId": 1,
    "courseName": "Java Full Stack",
    "duration": "6 Months",
    "fees": 25000.0
  },
  {
    "courseId": 2,
    "courseName": "Python Django",
    "duration": "4 Months",
    "fees": 20000.0
  }
]
```

**cURL Command:**
```bash
curl -X GET http://localhost:8080/admin/courses
```

---

## 🎓 Student APIs

### 1. Add/Register Student
**Endpoint:** `POST /students/add`

**Request Body:**
```json
{
  "name": "Neha Gupta",
  "email": "neha@test.com",
  "phone": "9876543212",
  "password": "neha123"
}
```

**Response:**
```json
{
  "studentId": 3,
  "name": "Neha Gupta",
  "email": "neha@test.com",
  "phone": "9876543212",
  "password": "neha123"
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/students/add \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Neha Gupta",
    "email": "neha@test.com",
    "phone": "9876543212",
    "password": "neha123"
  }'
```

---

### 2. Get All Students
**Endpoint:** `GET /students/all`

**Response:**
```json
[
  {
    "studentId": 1,
    "name": "Rahul Kumar",
    "email": "rahul@test.com",
    "phone": "9876543210",
    "password": "rahul123"
  }
]
```

**cURL Command:**
```bash
curl -X GET http://localhost:8080/students/all
```

---

### 3. Enroll in Course
**Endpoint:** `POST /students/enroll`

**Request Body:**
```json
{
  "studentId": 1,
  "courseId": 1
}
```

**Response:**
```json
{
  "enrollId": 1,
  "studentId": 1,
  "courseId": 1
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/students/enroll \
  -H "Content-Type: application/json" \
  -d '{
    "studentId": 1,
    "courseId": 1
  }'
```

---

## 👨‍🏫 Teacher APIs

### 1. Add Student Marks
**Endpoint:** `POST /teacher/addMarks`

**Request Body:**
```json
{
  "studentId": 1,
  "marks": 85,
  "grade": "A"
}
```

**Response:**
```json
{
  "resultId": 1,
  "studentId": 1,
  "marks": 85,
  "grade": "A"
}
```

**cURL Command:**
```bash
curl -X POST http://localhost:8080/teacher/addMarks \
  -H "Content-Type: application/json" \
  -d '{
    "studentId": 1,
    "marks": 85,
    "grade": "A"
  }'
```

---

## 🗄️ Database Tables

### 1. STUDENT Table
| Column | Type | Description |
|--------|------|-------------|
| student_id | BIGINT (PK) | Auto-generated ID |
| name | VARCHAR | Student name |
| email | VARCHAR | Student email |
| phone | VARCHAR | Phone number |
| password | VARCHAR | Password |

### 2. TEACHER Table
| Column | Type | Description |
|--------|------|-------------|
| teacher_id | BIGINT (PK) | Auto-generated ID |
| name | VARCHAR | Teacher name |
| email | VARCHAR | Teacher email |
| subject | VARCHAR | Subject taught |
| password | VARCHAR | Password |

### 3. COURSE Table
| Column | Type | Description |
|--------|------|-------------|
| course_id | BIGINT (PK) | Auto-generated ID |
| course_name | VARCHAR | Course name |
| duration | VARCHAR | Course duration |
| fees | DOUBLE | Course fees |

### 4. ENROLLMENT Table
| Column | Type | Description |
|--------|------|-------------|
| enroll_id | BIGINT (PK) | Auto-generated ID |
| student_id | BIGINT | Student ID (FK) |
| course_id | BIGINT | Course ID (FK) |

### 5. RESULT Table
| Column | Type | Description |
|--------|------|-------------|
| result_id | BIGINT (PK) | Auto-generated ID |
| student_id | BIGINT | Student ID (FK) |
| marks | INT | Marks obtained |
| grade | VARCHAR | Grade (A/B/C/D/F) |

---

## 🧪 Complete Testing Workflow

### Step 1: Start Application
```bash
mvnw spring-boot:run
```

### Step 2: Test Admin Module

#### 2.1 Add Students
```bash
# Student 1
curl -X POST http://localhost:8080/admin/addStudent \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul Kumar","email":"rahul@test.com","phone":"9876543210","password":"rahul123"}'

# Student 2
curl -X POST http://localhost:8080/admin/addStudent \
  -H "Content-Type: application/json" \
  -d '{"name":"Amit Singh","email":"amit@test.com","phone":"9876543211","password":"amit123"}'

# Student 3
curl -X POST http://localhost:8080/admin/addStudent \
  -H "Content-Type: application/json" \
  -d '{"name":"Priya Verma","email":"priya@test.com","phone":"9876543212","password":"priya123"}'
```

#### 2.2 Add Teachers
```bash
# Teacher 1
curl -X POST http://localhost:8080/admin/addTeacher \
  -H "Content-Type: application/json" \
  -d '{"name":"Dr. Sharma","email":"sharma@test.com","subject":"Mathematics","password":"sharma123"}'

# Teacher 2
curl -X POST http://localhost:8080/admin/addTeacher \
  -H "Content-Type: application/json" \
  -d '{"name":"Prof. Gupta","email":"gupta@test.com","subject":"Physics","password":"gupta123"}'
```

#### 2.3 Add Courses
```bash
# Course 1
curl -X POST http://localhost:8080/admin/addCourse \
  -H "Content-Type: application/json" \
  -d '{"courseName":"Java Full Stack","duration":"6 Months","fees":25000}'

# Course 2
curl -X POST http://localhost:8080/admin/addCourse \
  -H "Content-Type: application/json" \
  -d '{"courseName":"Python Django","duration":"4 Months","fees":20000}'

# Course 3
curl -X POST http://localhost:8080/admin/addCourse \
  -H "Content-Type: application/json" \
  -d '{"courseName":"React JS","duration":"3 Months","fees":15000}'
```

#### 2.4 View All Data
```bash
# Get all students
curl -X GET http://localhost:8080/admin/students

# Get all teachers
curl -X GET http://localhost:8080/admin/teachers

# Get all courses
curl -X GET http://localhost:8080/admin/courses
```

### Step 3: Test Student Module

#### 3.1 Enroll Students in Courses
```bash
# Student 1 enrolls in Course 1
curl -X POST http://localhost:8080/students/enroll \
  -H "Content-Type: application/json" \
  -d '{"studentId":1,"courseId":1}'

# Student 1 enrolls in Course 2
curl -X POST http://localhost:8080/students/enroll \
  -H "Content-Type: application/json" \
  -d '{"studentId":1,"courseId":2}'

# Student 2 enrolls in Course 1
curl -X POST http://localhost:8080/students/enroll \
  -H "Content-Type: application/json" \
  -d '{"studentId":2,"courseId":1}'
```

### Step 4: Test Teacher Module

#### 4.1 Add Marks for Students
```bash
# Add marks for Student 1
curl -X POST http://localhost:8080/teacher/addMarks \
  -H "Content-Type: application/json" \
  -d '{"studentId":1,"marks":85,"grade":"A"}'

# Add marks for Student 2
curl -X POST http://localhost:8080/teacher/addMarks \
  -H "Content-Type: application/json" \
  -d '{"studentId":2,"marks":78,"grade":"B"}'

# Add marks for Student 3
curl -X POST http://localhost:8080/teacher/addMarks \
  -H "Content-Type: application/json" \
  -d '{"studentId":3,"marks":92,"grade":"A"}'
```

---

## 🌐 UI Testing (Browser)

### Admin Dashboard Testing:
1. Open: http://localhost:8080
2. Login: admin / admin123
3. Click "Add Student" tab → Fill form → Submit
4. Click "Add Teacher" tab → Fill form → Submit
5. Click "Add Course" tab → Fill form → Submit
6. Click "View Students" tab → See all students
7. Click "View Teachers" tab → See all teachers
8. Click "View Courses" tab → See all courses

### Student Dashboard Testing:
1. Logout from admin
2. Login: student / student123
3. View all available courses
4. Click "Enroll" button on any course
5. Enter Student ID when prompted
6. See success message

### Teacher Dashboard Testing:
1. Logout from student
2. Login: teacher / teacher123
3. View all students in table
4. Fill "Add Marks" form with Student ID, Marks, Grade
5. Click Submit
6. See success message

---

## 🔍 H2 Database Console

**URL:** http://localhost:8080/h2-console

**Settings:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

**SQL Queries to Test:**
```sql
-- View all students
SELECT * FROM STUDENT;

-- View all teachers
SELECT * FROM TEACHER;

-- View all courses
SELECT * FROM COURSE;

-- View all enrollments
SELECT * FROM ENROLLMENT;

-- View all results
SELECT * FROM RESULT;

-- Join query: Students with their enrollments
SELECT s.name, c.course_name 
FROM STUDENT s 
JOIN ENROLLMENT e ON s.student_id = e.student_id 
JOIN COURSE c ON e.course_id = c.course_id;

-- Join query: Students with their marks
SELECT s.name, r.marks, r.grade 
FROM STUDENT s 
JOIN RESULT r ON s.student_id = r.student_id;
```

---

## 📊 Postman Collection

### Import this JSON in Postman:

```json
{
  "info": {
    "name": "University Management System",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Admin - Add Student",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\"name\":\"Test Student\",\"email\":\"test@test.com\",\"phone\":\"1234567890\",\"password\":\"test123\"}"
        },
        "url": "http://localhost:8080/admin/addStudent"
      }
    },
    {
      "name": "Admin - Get Students",
      "request": {
        "method": "GET",
        "url": "http://localhost:8080/admin/students"
      }
    },
    {
      "name": "Student - Enroll",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\"studentId\":1,\"courseId\":1}"
        },
        "url": "http://localhost:8080/students/enroll"
      }
    },
    {
      "name": "Teacher - Add Marks",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\"studentId\":1,\"marks\":85,\"grade\":\"A\"}"
        },
        "url": "http://localhost:8080/teacher/addMarks"
      }
    }
  ]
}
```

---

## ✅ Complete Feature List

### Admin Features:
- ✅ Add Student
- ✅ Add Teacher
- ✅ Add Course
- ✅ View All Students
- ✅ View All Teachers
- ✅ View All Courses
- ✅ Tab-based navigation
- ✅ Real-time data refresh
- ✅ Logout

### Student Features:
- ✅ View Available Courses
- ✅ Enroll in Courses (2 methods)
- ✅ View Profile
- ✅ Logout

### Teacher Features:
- ✅ Add Student Marks
- ✅ View All Students
- ✅ View All Courses
- ✅ Logout

### System Features:
- ✅ Role-based authentication
- ✅ Role-based dashboard redirection
- ✅ CSRF protection
- ✅ Password encryption (BCrypt)
- ✅ H2 in-memory database
- ✅ JPA/Hibernate ORM
- ✅ RESTful APIs
- ✅ Bootstrap UI
- ✅ AJAX form submissions
- ✅ Real-time data loading

---

## 🎯 Summary

**Total APIs:** 10
- Admin APIs: 6
- Student APIs: 3
- Teacher APIs: 1

**Total Tables:** 5
- Student, Teacher, Course, Enrollment, Result

**Total Dashboards:** 3
- Admin, Student, Teacher

**Authentication:** Spring Security with BCrypt

**Database:** H2 (In-memory)

**Frontend:** Thymeleaf + Bootstrap 5 + jQuery

**Backend:** Spring Boot 3.2.0 + JPA

---

Sab kuch ready hai! Testing ke liye upar diye gaye cURL commands use karo! 🚀
