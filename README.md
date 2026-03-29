# JDBC Backend Practice 🚀

This repository contains hands-on practice programs built using **Java JDBC** to interact with a Microsoft SQL Server database.

The goal of this project is to understand and practice how Java applications communicate with relational databases and implement full CRUD operations.

---

## 📌 Concepts Covered

- JDBC connection setup using `DriverManager`
- Secure queries using `PreparedStatement`
- INSERT, UPDATE, DELETE operations
- SELECT operation using `ResultSet`
- Understanding auto-commit behavior and basic transaction handling
- Building a menu-driven console-based CRUD application
- DAO (Data Access Object) pattern
- Layered application structure
- Separation of concerns

---

## 🧱 Architecture

The project follows a layered structure:

- **Main** → Entry point of the application
- **MenuService** → Handles user input and menu logic
- **CustomerDAO** → Handles database operations (CRUD)
- **DBConnection** → Provides database connection

This separation improves readability, maintainability, and follows basic backend design principles.

---

## 📂 Project Structure

All source files are located inside:

```
src/com/aditya/jdbc/
```

- `DBConnection.java` → Handles database connection setup
- `CustomerDAO.java` → Contains all CRUD operations
- `MenuService.java` → Handles menu and user interaction
- `Main.java` → Entry point of the application
- `Test.java` → Initial JDBC connection test

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
Run `Main.java` to start the interactive console application.

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
- Structuring a clean backend-style console application using DAO pattern

This repository represents my step-by-step learning journey into JDBC and backend database interaction.