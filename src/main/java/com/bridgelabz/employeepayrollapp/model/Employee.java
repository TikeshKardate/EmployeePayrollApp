package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employeepayrolldata")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double salary;
    private String department;

    public Employee(String name,double salary,String department){
        this.name=name;
        this.salary=salary;
        this.department=department;
    }
}

