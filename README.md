# Employee Management System

A console-based Employee Management System developed using Java 17 and Maven.

## Features

- Add Employee
- View All Employees
- Search Employee by ID
- Update Employee
- Delete Employee
- Duplicate Employee ID Validation
- Input Validation
- Exception Handling
- Empty Employee List Handling
- Sort Employees by Salary
- Menu-driven Console Interface

## Technologies Used

- Java 17
- Maven
- IntelliJ IDEA
- ArrayList
- Object-Oriented Programming

## OOP Concepts Used

### Encapsulation
Employee fields are private and accessed using getters and setters.

### Constructor
The Employee constructor initializes employee information.

### Classes and Objects
The project uses separate classes for employee data, business logic, and application execution.

### Collections
ArrayList is used to store employee objects.

### Exception Handling
Invalid numeric inputs are handled using try-catch blocks.

## Project Structure

```text
EmployeeManagement
│
├── src
│   └── main
│       └── java
│           └── com.example
│               ├── Employee.java
│               ├── EmployeeService.java
│               └── Main.java
│
├── pom.xml
└── README.md