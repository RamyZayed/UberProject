package com.example.actualproject.repository;

import com.example.actualproject.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    @Query(value = "select e.id from car c, employee e, car_employee ce where color =:color1 and c.id = e.id and ce.car_id = c.id  ; ",nativeQuery = true)
    List<Object[]> findcarsbyColor(@Param("color1") String color);
}
