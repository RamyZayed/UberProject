package com.example.actualproject.service;

import com.example.actualproject.entity.Employee;
import com.example.actualproject.entity.Person;
import com.example.actualproject.entity.dto.EmployeeDto;
import com.example.actualproject.entity.dto.EmployeeDtoMapper;
import com.example.actualproject.entity.dto.PersonAddressMapper;
import com.example.actualproject.entity.dto.PersonAdressDTO;
import com.example.actualproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees(int page, int size){
        Pageable result= PageRequest.of(page,size);
        Page<Employee> mylist = employeeRepository.findAll(result);
        List<EmployeeDto> listoo = new ArrayList<>();
        mylist.forEach(emp -> listoo.add(EmployeeDtoMapper.Instance.toDto(emp)));
        return listoo;
    }

    @Override
    public EmployeeDto findById(int id) {
        EmployeeDto someone = EmployeeDtoMapper.Instance.toDto(employeeRepository.findById(id).get());
        return someone;
    }


    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeRepository.updatename(employee.getName(), employee.getId());
        return employeeRepository.findById(employee.getId()).get();
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);

    }

}
