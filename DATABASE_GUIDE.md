# 🗄️ Database Configuration Guide

## ✅ Ab Database File-Based Hai (Data Permanent Rahega!)

### 📍 Data Kahan Save Hoga?

**Location:** `f:\GIT\Online-University-Management-System\data\`

**Files:**
- `universitydb.mv.db` - Main database file
- `universitydb.trace.db` - Log file

### 🔍 Kaise Check Karein?

1. **Application run karo:**
   ```bash
   mvnw spring-boot:run
   ```

2. **Data folder automatically create hoga:**
   ```
   Online-University-Management-System/
   ├── data/
   │   ├── universitydb.mv.db  ← Yahan sab data save hai
   │   └── universitydb.trace.db
   ```

3. **Data add karo** (Admin dashboard se ya API se)

4. **Application band karo** (Ctrl+C)

5. **Phir se start karo** - Data wahi rahega! ✅

---

## 🔐 Password Kahan Save Hota Hai?

### 1. Login Passwords (Admin/Student/Teacher)
**Location:** Memory (SecurityConfig.java)
```java
// Yeh hardcoded hain - change nahi hote
admin / admin123
student / student123
teacher / teacher123
```

**File:** `src/main/java/com/example/university/config/SecurityConfig.java`

**Encryption:** BCrypt (Secure hash)

### 2. Student/Teacher Passwords (Database mein)
**Location:** Database file (`data/universitydb.mv.db`)

**Tables:**
- `STUDENT` table → `password` column
- `TEACHER` table → `password` column

**Format:** Plain text (abhi encrypt nahi hai)

**Example:**
```sql
-- Student table
student_id | name        | email           | phone      | password
1          | Rahul Kumar | rahul@test.com  | 9876543210 | rahul123

-- Teacher table
teacher_id | name         | email          | subject     | password
1          | Priya Sharma | priya@test.com | Mathematics | priya123
```

---

## 🗃️ Database Tables Structure

### 1. STUDENT Table
```sql
CREATE TABLE STUDENT (
    student_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    password VARCHAR(255)
);
```

### 2. TEACHER Table
```sql
CREATE TABLE TEACHER (
    teacher_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    subject VARCHAR(255),
    password VARCHAR(255)
);
```

### 3. COURSE Table
```sql
CREATE TABLE COURSE (
    course_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(255),
    duration VARCHAR(255),
    fees DOUBLE
);
```

### 4. ENROLLMENT Table
```sql
CREATE TABLE ENROLLMENT (
    enroll_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    course_id BIGINT
);
```

### 5. RESULT Table
```sql
CREATE TABLE RESULT (
    result_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT,
    marks INT,
    grade VARCHAR(10)
);
```

---

## 🔍 H2 Console Se Database Dekho

### Step 1: Application Start Karo
```bash
mvnw spring-boot:run
```

### Step 2: Browser Mein H2 Console Kholo
```
http://localhost:8080/h2-console
```

### Step 3: Login Settings
```
JDBC URL: jdbc:h2:file:./data/universitydb
Username: sa
Password: admin123
```

### Step 4: Click "Connect"

### Step 5: SQL Queries Run Karo
```sql
-- Saare students dekho
SELECT * FROM STUDENT;

-- Saare teachers dekho
SELECT * FROM TEACHER;

-- Saare courses dekho
SELECT * FROM COURSE;

-- Enrollments dekho
SELECT * FROM ENROLLMENT;

-- Results dekho
SELECT * FROM RESULT;

-- Student count
SELECT COUNT(*) FROM STUDENT;

-- Specific student search
SELECT * FROM STUDENT WHERE email = 'rahul@test.com';

-- Students with their enrollments
SELECT s.name, c.course_name 
FROM STUDENT s 
JOIN ENROLLMENT e ON s.student_id = e.student_id 
JOIN COURSE c ON e.course_id = c.course_id;
```

---

## 📊 Data Flow

### Add Student Flow:
```
Admin Dashboard Form
    ↓
POST /admin/addStudent
    ↓
AdminController.addStudent()
    ↓
AdminService.addStudent()
    ↓
StudentRepository.save()
    ↓
JPA/Hibernate
    ↓
H2 Database File (data/universitydb.mv.db)
    ↓
Data Saved! ✅
```

### Retrieve Students Flow:
```
Admin Dashboard "View Students" Tab
    ↓
GET /admin/students
    ↓
AdminController.getStudents()
    ↓
AdminService.getStudents()
    ↓
StudentRepository.findAll()
    ↓
JPA/Hibernate
    ↓
H2 Database File (data/universitydb.mv.db)
    ↓
Data Retrieved! ✅
```

---

## 🧪 Testing Data Persistence

### Test 1: Add Data
```bash
# Start application
mvnw spring-boot:run

# Add a student via API
curl -X POST http://localhost:8080/admin/addStudent \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@test.com","phone":"1234567890","password":"test123"}'

# Response: {"studentId":1,"name":"Test User",...}
```

### Test 2: Stop Application
```bash
# Press Ctrl+C to stop
```

### Test 3: Check Database File
```bash
# Check if file exists
dir data\universitydb.mv.db

# File size should be > 0 KB
```

### Test 4: Restart Application
```bash
# Start again
mvnw spring-boot:run
```

### Test 5: Verify Data Still Exists
```bash
# Get all students
curl -X GET http://localhost:8080/admin/students

# Response should show "Test User" ✅
```

---

## 🔒 Security Considerations

### Current Setup:
- ❌ Student/Teacher passwords are **plain text** in database
- ✅ Login passwords (admin/student/teacher) are **BCrypt encrypted**

### Recommended: Encrypt Database Passwords

Add this to Student/Teacher entities:
```java
@PrePersist
@PreUpdate
private void encryptPassword() {
    if (password != null && !password.startsWith("$2a$")) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
```

---

## 📁 File Structure

```
Online-University-Management-System/
├── data/                          ← Database files yahan
│   ├── universitydb.mv.db        ← Main database
│   └── universitydb.trace.db     ← Logs
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/university/
│   │   │       ├── entity/       ← Database tables
│   │   │       ├── repository/   ← Database access
│   │   │       ├── service/      ← Business logic
│   │   │       └── controller/   ← APIs
│   │   └── resources/
│   │       ├── application.properties  ← Database config
│   │       └── templates/              ← HTML pages
```

---

## 🎯 Summary

### ✅ Data Storage:
- **Location:** `data/universitydb.mv.db` file
- **Type:** H2 file-based database
- **Persistence:** Permanent (application restart ke baad bhi rahega)

### ✅ Password Storage:
- **Login passwords:** Memory (SecurityConfig) - BCrypt encrypted
- **Database passwords:** Database file - Plain text (encrypt karna recommended)

### ✅ Access Methods:
1. **UI:** Admin/Student/Teacher dashboards
2. **API:** REST endpoints
3. **H2 Console:** http://localhost:8080/h2-console
4. **Direct File:** `data/universitydb.mv.db`

### ✅ Backup:
```bash
# Backup database
copy data\universitydb.mv.db data\backup\universitydb_backup.mv.db

# Restore database
copy data\backup\universitydb_backup.mv.db data\universitydb.mv.db
```

---

## 🚀 Next Steps

1. **Start application** - Database file automatically create hoga
2. **Add data** - Admin dashboard se ya API se
3. **Check H2 console** - Data verify karo
4. **Stop & restart** - Data permanent hai confirm karo
5. **Backup regularly** - Important data ko backup rakho

Ab data permanent save hoga! 🎉
