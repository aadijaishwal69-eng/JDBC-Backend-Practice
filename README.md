# JDBC Backend Practice 🚀

This repository contains hands-on backend development practice using **Java JDBC** and **Microsoft SQL Server**.

The project started as a CRUD-based customer management application and has gradually expanded to include **transaction management**, **DAO pattern implementation**, and backend programming concepts commonly used in real-world applications.

---

## 📌 Concepts Covered

### JDBC Fundamentals
- JDBC connection setup using `DriverManager`
- Database connectivity with Microsoft SQL Server
- Using `PreparedStatement` for parameterized queries
- Executing `INSERT`, `UPDATE`, `DELETE`, and `SELECT` operations
- Processing query results using `ResultSet`

### Backend Design
- DAO (Data Access Object) pattern
- Layered application structure
- Separation of concerns
- Menu-driven console application

### Transaction Management
- Manual transaction control using `setAutoCommit(false)`
- `commit()` and `rollback()`
- Multi-step database operations
- Account transfer simulation
- Transaction failure handling
- Input validation and account verification

---

## 🧱 Architecture

### CRUD Application

```text
Main
 └── MenuService
      └── CustomerDAO
            └── DBConnection
```

- **Main** → Application entry point
- **MenuService** → Handles menu flow and user interaction
- **CustomerDAO** → Performs CRUD operations
- **DBConnection** → Creates database connections

---

## 📂 Project Structure

```text
src/
└── com/aditya/jdbc
    ├── app
    │   ├── Main.java
    │   ├── MenuService.java
    │   ├── CustomerDAO.java
    │   ├── DBConnection.java
    │   └── Test.java
    │
    └── practice
        └── transaction
            ├── TransactionDemo.java
            └── TransactionDemo2.java
```

### app
Contains the DAO-based CRUD application.

### practice/transaction
Contains transaction management practice programs demonstrating:

- Account balance verification
- Money transfer simulation
- Commit and rollback handling
- Transaction validation logic

---

## 🛠️ Tech Stack

- Java (JDK 22)
- Microsoft SQL Server Express (SQLEXPRESS)
- Microsoft JDBC Driver for SQL Server
- IntelliJ IDEA

---

## 🚀 How to Run

### 1. Clone Repository

```bash
git clone https://github.com/aadijaishwal69-eng/JDBC-Backend-Practice.git
```

### 2. Add JDBC Driver

Add the Microsoft SQL Server JDBC Driver JAR file to your project libraries.

### 3. Configure Database

Update the database URL, username, and password according to your local SQL Server setup.

### 4. Run

For CRUD application:

```text
Main.java
```

For transaction practice:

```text
TransactionDemo.java
TransactionDemo2.java
```

---

## 💻 Features Implemented

### CRUD Operations
- Add customer
- Update customer
- Delete customer
- View customer records

### Transaction Practice
- Verify sender account
- Verify receiver account
- Validate transfer amount
- Check available balance
- Commit successful transfers
- Rollback failed transactions

---

## 🎯 Learning Outcomes

Through this repository, I gained practical experience in:

- JDBC database programming
- SQL Server integration with Java
- Secure SQL execution using PreparedStatement
- CRUD application development
- DAO pattern implementation
- Transaction management with commit and rollback
- Input validation and error handling
- Building backend-style console applications

---

## 📈 Next Steps

- Refactor transaction logic using DAO classes
- Introduce service layer for business logic
- Use BigDecimal for monetary values
- Improve exception handling
- Build a complete console-based banking system
- Learn and implement Spring Boot

---

This repository represents my step-by-step learning journey into Java backend development, JDBC, database interaction, and transaction management.