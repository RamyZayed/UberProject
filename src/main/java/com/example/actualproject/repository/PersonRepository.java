package com.example.actualproject.repository;

import com.example.actualproject.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {

    @Query(value = "select p.street from person p",nativeQuery = true)
    List<Object []> Somethingidk();

    @Query(value = "select p.id as PersonId , c.color, c.id \n" +
            "from person p , car c , car_employee ce\n" +
            "where  p.id =:pid and\n" +
            "p.id = ce.employee_id and\n" +
            "c.id = ce.car_id;",nativeQuery = true)
    List<Object[]> findcars(@Param("pid")int person_id);
}
