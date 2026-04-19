# ❓ Frequently Asked Questions (FAQ)

## 1. Database mein save kiye students/teachers login kar sakte hain?

### ❌ Current System: NO

**Reason:**
- Login credentials **hardcoded** hain `SecurityConfig.java` mein
- Database ke students/teachers sirf **records** ke liye hain
- Login system aur database system **separate** hain

**Current Login Credentials (Fixed):**
```
Admin:   admin / admin123
Student: student / student123
Teacher: teacher / teacher123
```

**Database Records:**
- Admin dashboard se jo students/teachers add karte ho
- Wo sirf **data management** ke liye hain
- Unka password database mein save hota hai
- Par wo login nahi kar sakte

### ✅ Solution (If Needed):

Agar aapko chahiye ki database ke users login kar sakein, to ye changes karne padenge:

**Option 1: Simple Fix (Recommended for BCA Project)**
```
Keep current system as-is:
- Fixed login credentials for demo
- Database for student/teacher records
- Explain in documentation that it's a prototype
```

**Option 2: Dynamic Login (Advanced)**
```java
// SecurityConfig.java mein changes
// UserDetailsService ko database se load karna padega
// Password encryption add karna padega
// Complex implementation - BCA project ke liye overkill
```

---

## 2. Application Restart Pe Data Delete Kyu Ho Jata Hai?

### 🔍 Possible Reasons:

#### Reason 1: Database File Path Issue
**Check:**
```bash
# Data folder exist karta hai?
dir data

# Database file exist karti hai?
dir data\universitydb.mv.db
```

**Fix:**
```properties
# application.properties mein absolute path use karo
spring.datasource.url=jdbc:h2:file:f:/GIT/Online-University-Management-System/data/universitydb
```

#### Reason 2: ddl-auto Setting
**Current Setting:**
```properties
spring.jpa.hibernate.ddl-auto=update
```

**Agar `create` ya `create-drop` hai to change karo:**
```properties
# WRONG - Har baar tables recreate hote hain
spring.jpa.hibernate.ddl-auto=create

# CORRECT - Tables update hote hain, data safe rahta hai
spring.jpa.hibernate.ddl-auto=update
```

#### Reason 3: Multiple Application Instances
**Problem:** Agar multiple terminals mein application run kar rahe ho

**Fix:**
```bash
# Pehle saare instances band karo
netstat -ano | findstr :8080
taskkill /F /PID <PID>

# Phir ek hi instance run karo
mvnw spring-boot:run
```

#### Reason 4: Database File Locked
**Problem:** Database file kisi aur process ne lock kar rakhi hai

**Fix:**
```bash
# Application band karo
# H2 console band karo
# Phir restart karo
```

---

## 3. Data Permanent Kaise Save Karein?

### ✅ Step-by-Step Guide:

**Step 1: Application Start Karo**
```bash
mvnw spring-boot:run
```

**Step 2: Data Add Karo**
```bash
# Browser mein jao
http://localhost:8080

# Admin login karo
admin / admin123

# Student add karo
Name: Test Student
Email: test@test.com
Phone: 1234567890
Password: test123
```

**Step 3: Verify Data Saved**
```bash
# H2 Console kholo
http://localhost:8080/h2-console

# Settings:
JDBC URL: jdbc:h2:file:./data/universitydb
Username: sa
Password: admin123

# Query run karo:
SELECT * FROM STUDENT;
```

**Step 4: Application Band Karo**
```bash
# Terminal mein Ctrl+C press karo
```

**Step 5: Database File Check Karo**
```bash
# File exist karti hai?
dir data\universitydb.mv.db

# File size > 0 KB honi chahiye
```

**Step 6: Application Restart Karo**
```bash
mvnw spring-boot:run
```

**Step 7: Data Verify Karo**
```bash
# Browser mein jao
http://localhost:8080

# Admin login karo
# View Students tab mein dekho
# Test Student dikhna chahiye ✅
```

---

## 4. Database Backup Kaise Karein?

### 📦 Manual Backup:

**Method 1: File Copy**
```bash
# Application band karo
# Data folder copy karo
xcopy data data_backup /E /I

# Restore karne ke liye:
xcopy data_backup data /E /I /Y
```

**Method 2: H2 Console Se**
```sql
-- H2 Console mein jao
-- Ye query run karo:
SCRIPT TO 'backup.sql';

-- Restore karne ke liye:
RUNSCRIPT FROM 'backup.sql';
```

---

## 5. Kya Students Apne Password Se Login Kar Sakte Hain?

### Current System: ❌ NO

**Explanation:**

```
┌─────────────────────────────────────┐
│   LOGIN SYSTEM (SecurityConfig)    │
│   - admin / admin123                │
│   - student / student123            │
│   - teacher / teacher123            │
│   (Hardcoded - Fixed)               │
└─────────────────────────────────────┘
           ↓
    Authentication
           ↓
┌─────────────────────────────────────┐
│   DATABASE SYSTEM (H2)              │
│   - Student records                 │
│   - Teacher records                 │
│   - Passwords stored but not used   │
│   (For record keeping only)         │
└─────────────────────────────────────┘
```

**Why Separate?**
1. **Simplicity** - Easy to demo and test
2. **Security** - No need to encrypt passwords
3. **BCA Project** - Sufficient for college submission
4. **Fixed Users** - Predictable behavior

**Database Password Ka Use:**
- Record keeping
- Future enhancement
- Show complete student/teacher data
- Documentation purpose

---

## 6. Data Kahan Save Hota Hai?

### 📁 File Location:

```
Online-University-Management-System/
├── data/
│   ├── universitydb.mv.db      ← Main database file (Yahan data hai)
│   └── universitydb.trace.db   ← Log file
```

**File Details:**
- **universitydb.mv.db** - Binary file with all data
- Size increases as you add data
- Portable - Copy kar sakte ho
- Backup easy hai

**Access Methods:**
1. **Application** - http://localhost:8080
2. **H2 Console** - http://localhost:8080/h2-console
3. **Direct File** - data/universitydb.mv.db

---

## 7. Testing Checklist

### ✅ Data Persistence Test:

**Test 1: Add and Verify**
```
1. Start application
2. Add 1 student
3. View Students tab - should show 1 student ✅
4. Stop application
5. Start application again
6. View Students tab - should still show 1 student ✅
```

**Test 2: Multiple Records**
```
1. Add 3 students
2. Add 2 teachers
3. Add 2 courses
4. Restart application
5. All data should be there ✅
```

**Test 3: Database File**
```
1. Add some data
2. Stop application
3. Check: dir data\universitydb.mv.db
4. File size should be > 100 KB ✅
5. Copy file to backup location
6. Delete original file
7. Copy backup back
8. Start application
9. Data should be restored ✅
```

---

## 8. Common Issues & Solutions

### Issue 1: Data Not Saving
**Symptoms:** Data disappears after restart

**Solutions:**
```bash
# Check 1: Database path
# application.properties mein dekho
spring.datasource.url=jdbc:h2:file:./data/universitydb

# Check 2: ddl-auto setting
spring.jpa.hibernate.ddl-auto=update  # Should be 'update'

# Check 3: File permissions
# Data folder writable hai?

# Check 4: Disk space
# Enough space available hai?
```

### Issue 2: Login Not Working
**Symptoms:** Invalid username/password

**Solutions:**
```
Use exact credentials:
- admin / admin123 (lowercase)
- student / student123
- teacher / teacher123

NOT:
- Admin / Admin123 (wrong case)
- test@test.com / test123 (database user - won't work)
```

### Issue 3: H2 Console Not Opening
**Symptoms:** 404 error on /h2-console

**Solutions:**
```properties
# application.properties mein check karo
spring.h2.console.enabled=true
spring.h2.console.path=/h2

# URL:
http://localhost:8080/h2-console (NOT /h2)
```

---

## 9. Project Explanation (For Viva/Demo)

### Question: "Database ke students login kyu nahi kar sakte?"

**Answer:**
```
"Sir, current implementation mein humne authentication aur 
data management ko separate rakha hai. Ye ek prototype hai 
jisme fixed demo credentials hain testing ke liye.

Real-world application mein hum Spring Security ko database 
se integrate karenge aur dynamic login implement karenge.

Abhi ke liye:
- Login: Fixed credentials (admin/student/teacher)
- Database: Student/Teacher records management

Future enhancement mein hum:
- Database-based authentication add karenge
- Password encryption implement karenge
- Role-based dynamic login karenge"
```

### Question: "Data permanent kaise save hota hai?"

**Answer:**
```
"Sir, humne H2 file-based database use kiya hai. Data 
'data/universitydb.mv.db' file mein save hota hai.

Configuration:
- spring.datasource.url=jdbc:h2:file:./data/universitydb
- spring.jpa.hibernate.ddl-auto=update

Application restart ke baad bhi data safe rahta hai kyunki:
1. File-based storage hai (not in-memory)
2. ddl-auto=update hai (not create)
3. Database file persist karti hai

Demo: (Show data folder and file size)"
```

---

## 10. Summary

### ✅ What Works:
- Fixed login credentials (admin/student/teacher)
- Data saves in database file
- Data persists after restart
- CRUD operations working
- H2 console accessible

### ⚠️ Limitations:
- Database users can't login (by design)
- Fixed credentials only
- No dynamic user registration for login

### 🎯 For BCA Project:
- Current implementation is sufficient
- Explain as prototype/demo system
- Mention future enhancements
- Show working features
- Demonstrate data persistence

---

## Need Help?

**Check These Files:**
1. `application.properties` - Database config
2. `SecurityConfig.java` - Login credentials
3. `data/universitydb.mv.db` - Database file
4. Console logs - Error messages

**Test Commands:**
```bash
# Check if application running
netstat -ano | findstr :8080

# Check database file
dir data\universitydb.mv.db

# Start application
mvnw spring-boot:run

# Access application
http://localhost:8080
```

---

**Last Updated:** March 2026
**Project:** Online University Management System
**Course:** BCA Final Year
