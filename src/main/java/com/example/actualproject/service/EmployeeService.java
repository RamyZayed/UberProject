package com.example.actualproject.service;


import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.EmployeeDto;
import com.example.actualproject.entity.dto.EmployeeDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService  {
    List<EmployeeDto> getAllEmployees(int page , int size);
    EmployeeDto findById(int id );
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int id);

}
