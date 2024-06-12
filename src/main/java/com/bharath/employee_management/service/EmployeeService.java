package com.bharath.employee_management.service;

import com.bharath.employee_management.model.Employee;
import com.bharath.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) throws Exception {
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new Exception("Email is already in use");
        }
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}