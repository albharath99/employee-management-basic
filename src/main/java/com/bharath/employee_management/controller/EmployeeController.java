package com.bharath.employee_management.controller;

import com.bharath.employee_management.model.Employee;
import com.bharath.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveEmployee(employee);
            return "Employee created successfully";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/email/{email}")
    public Optional<Employee> getEmployee(@PathVariable String email) {
        return employeeService.getEmployeeByEmail(email);
    }
}