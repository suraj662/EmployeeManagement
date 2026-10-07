package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();


        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }


            switch (choice) {
                case 1:
                    int employeeId;
                    while (true) {
                        System.out.print("Enter Employee ID: ");
                        try {
                            employeeId = Integer.parseInt(scanner.nextLine());
                            if (employeeId <= 0) {
                                System.out.println("Employee ID must be greater than 0.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a valid number.");
                        }
                    }

                    // Check duplicate ID
                    if (employeeService.searchEmployee(employeeId) != null) {
                        System.out.println("Employee with ID " + employeeId + " already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    while (name.trim().isEmpty()) {
                        System.out.print("Name cannot be empty. Enter Name: ");
                        name = scanner.nextLine();
                    }

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    while (email.trim().isEmpty()) {
                        System.out.print("Email cannot be empty. Enter Email: ");
                        email = scanner.nextLine();
                    }

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    while (department.trim().isEmpty()) {
                        System.out.print("Department cannot be empty. Enter Department: ");
                        department = scanner.nextLine();
                    }
                    double salary;
                    while (true) {
                        System.out.print("Enter Salary: ");
                        try {
                            salary = Double.parseDouble(scanner.nextLine());
                            if (salary < 0) {
                                System.out.println("Salary cannot be negative.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid salary. Please enter a number.");
                        }
                    }
                    Employee employee = new Employee(
                            employeeId,
                            name,
                            email,
                            department,
                            salary);

                    boolean added = employeeService.addEmployee(employee);
                    if (added) {
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Employee could not be added.");
                    }
                    break;


                case 2:
                    employeeService.viewEmployees();
                    break;


                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    try {
                        int searchId = Integer.parseInt(scanner.nextLine());
                        Employee foundEmployee = employeeService.searchEmployee(searchId);
                        if (foundEmployee != null) {
                            System.out.println("\nEmployee found:");
                            System.out.println("------------------------------------------");
                            System.out.println("ID         : " + foundEmployee.getEmployeeId());
                            System.out.println("Name       : " + foundEmployee.getName());
                            System.out.println("Email      : " + foundEmployee.getEmail());
                            System.out.println("Department : " + foundEmployee.getDepartment());
                            System.out.println("Salary     : " + foundEmployee.getSalary());
                            System.out.println("------------------------------------------");
                        } else {
                            System.out.println("Employee with ID " + searchId + " not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                    }
                    break;


                case 4:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                        break;
                    }

                    // Check employee exists before asking for new data
                    Employee employeeToUpdate = employeeService.searchEmployee(updateId);

                    if (employeeToUpdate == null) {
                        System.out.println("Employee with ID " + updateId + " not found.");
                        break;
                    }
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();


                    while (newName.trim().isEmpty()) {
                        System.out.print("Name cannot be empty. Enter New Name: ");
                        newName = scanner.nextLine();
                    }


                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();

                    while (newEmail.trim().isEmpty()) {
                        System.out.print("Email cannot be empty. Enter New Email: ");
                        newEmail = scanner.nextLine();
                    }

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();

                    while (newDepartment.trim().isEmpty()) {
                        System.out.print("Department cannot be empty. Enter New Department: ");
                        newDepartment = scanner.nextLine();
                    }
                    double newSalary;


                    while (true) {
                        System.out.print("Enter New Salary: ");
                        try {

                            newSalary = Double.parseDouble(scanner.nextLine());
                            if (newSalary < 0) {

                                System.out.println("Salary cannot be negative.");
                                continue;
                            }
                            break;

                        } catch (NumberFormatException e) {

                            System.out.println("Invalid salary. Please enter a number.");
                        }
                    }

                    boolean updated =
                            employeeService.updateEmployee(
                                    updateId,
                                    newName,
                                    newEmail,
                                    newDepartment,
                                    newSalary);
                    if (updated) {
                        System.out.println("Employee updated successfully.");
                    } else {

                        System.out.println("Employee could not be updated.");
                    }
                    break;



                case 5:
                    System.out.print("Enter Employee ID to delete: ");

                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        boolean deleted = employeeService.deleteEmployee(deleteId);

                        if (deleted) {
                            System.out.println("Employee deleted successfully.");

                        } else {
                            System.out.println("Employee with ID " + deleteId + " not found.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                    }
                    break;


                case 6:
                    employeeService.sortBySalary();
                    employeeService.viewEmployees();
                    break;



                case 7:
                    System.out.println("Thank you for using Employee Management System.");
                    scanner.close();
                    return;


                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}