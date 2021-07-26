package com.example.actualproject.service;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(int page, int size){
        Pageable result= PageRequest.of(page,size);
        Page<Employee> mylist = employeeRepository.findAll(result);
        return mylist.toList();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

}
