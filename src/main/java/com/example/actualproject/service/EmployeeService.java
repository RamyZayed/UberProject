package com.example.actualproject.service;


import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService  {
    List<Employee> getAllEmployees(int page , int size);
    Employee findById(int id );
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int id);

}
