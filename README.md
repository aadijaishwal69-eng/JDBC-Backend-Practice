# JDBC Backend Practice 🚀

This repository contains hands-on practice programs built using **Java JDBC** to interact with a Microsoft SQL Server database.

The goal of this project is to understand and practice how Java applications communicate with relational databases and implement full CRUD operations.

---

## 📌 Concepts Covered

- JDBC connection setup using `DriverManager`
- Secure queries using `PreparedStatement`
- INSERT operation
- UPDATE operation
- DELETE operation
- SELECT operation using `ResultSet`
- Understanding auto-commit behavior and basic transaction handling
- Building a menu-driven console-based CRUD application

---

## 📂 Project Structure

All source files are located inside:

```
src/com/aditya/jdbc/
```

- `JDBCConnectionTest.java` → Tests and verifies database connectivity
- `Insert.java` → Adds new records to the database
- `Update.java` → Updates existing records
- `Delete.java` → Deletes records from the database
- `Select.java` → Fetches and displays records using ResultSet
- `CRUD.java` → Interactive menu-driven console application

---

## 🛠️ Tech Stack

- Java (JDK 22)
- Microsoft SQL Server (SQLEXPRESS)
- MS SQL JDBC Driver (mssql-jdbc-13.2.1.jre11)
- IntelliJ IDEA

---

## 🚀 How to Run

### 1️⃣ Clone the repository

```
git clone https://github.com/aadijaishwal69-eng/JDBC-Backend-Practice.git
```

### 2️⃣ Add the JDBC Driver
Add the MS SQL JDBC JAR file to your project libraries.

### 3️⃣ Configure Database
Update the `url`, `username`, and `password` inside the Java files according to your local SQL Server setup.

### 4️⃣ Run the Application
Run `CRUD.java` to start the interactive console application.

---

## 💻 Sample Console Menu

```
Enter your choice:
1. Insert
2. Update
3. Delete
4. Select
5. Exit
```

---

## 🎯 Learning Outcome

Through this project, I gained practical experience in:

- Connecting Java applications to relational databases
- Executing parameterized SQL queries safely
- Retrieving and processing data using `ResultSet`
- Understanding transaction behavior and auto-commit
- Structuring a clean backend-style console application

This repository represents my step-by-step learning journey into JDBC and backend database interaction.