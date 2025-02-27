package com.bridgelabz.employeepayrollapp.controller;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {


    @Autowired
    private EmployeePayrollService employeePayrollService;

    // Create Employee
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeePayrollService.createEmployee(employee);
        return ResponseEntity.ok("Employee created successfully");
    }

    // Get All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeePayrollService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeePayrollService.updateEmployee(id, updatedEmployee)
                .map(e -> ResponseEntity.ok("Employee updated successfully"))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (employeePayrollService.deleteEmployee(id)) {
            return ResponseEntity.ok("Employee deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}