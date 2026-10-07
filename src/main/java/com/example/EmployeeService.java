package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    // Add employee
    public boolean addEmployee(Employee employee) {

        // Check ID already exists
        if (searchEmployee(employee.getEmployeeId()) != null) {
            return false;
        }

        employees.add(employee);
        return true;
    }

    // View all employees
    public void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n========== Employee List ===========");
        System.out.printf(
                "%-8s %-20s %-30s %-15s %-12s%n",
                "ID", "Name", "Email", "Department", "Salary" );
        System.out.println("---------------------------------------------");
        for (Employee employee : employees) {

            System.out.printf("%-8d %-20s %-30s %-15s %.2f%n",
                    employee.getEmployeeId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getDepartment(),
                    employee.getSalary());
        }

        System.out.println("-------------------------------");
    }

    // Search employee by ID
    public Employee searchEmployee(int employeeId) {

        for (Employee employee : employees) {

            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    // Update employee
    public boolean updateEmployee(int employeeId, String name, String email,
                                  String department, double salary) {

        for (Employee employee : employees) {

            if (employee.getEmployeeId() == employeeId) {

                employee.setName(name);
                employee.setEmail(email);
                employee.setDepartment(department);
                employee.setSalary(salary);

                return true;
            }
        }
        return false;
    }

    // Delete employee
    public boolean deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {

            Employee employee = iterator.next();

            if (employee.getEmployeeId() == employeeId) {

                iterator.remove();
                return true;
            }
        }
        return false;
    }

    //sort employees by salary
    public void sortBySalary() {

        if (employees.isEmpty()) {
            System.out.println("No employees available to sort.");
            return;
        }
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Employees sorted by salary.");
    }
}