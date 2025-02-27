package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class EmployeePayrollService {

    private final List<Employee> employeeList = new ArrayList<>();
    private Long employeeIdCounter = 1L;

    // Create Employee in the list format
    public Employee createEmployee(Employee employee) {
        employee.setId(employeeIdCounter++); //Manually set unique ID
        employeeList.add(employee);
        return employee;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    // Update Employee
    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return employee;
        });
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
    return employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}
