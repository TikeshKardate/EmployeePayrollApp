package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name is required cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\\\s]+$", message = "Name must start with an uppercase letter and does not having any special character")
    private String name;
    private double Salary;
    private String department;

}

