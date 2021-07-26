package com.example.actualproject.repository;

import com.example.actualproject.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update person \n" +
            " inner join customer\n" +
            " on person.id =:id\n" +
            " set person.name =:name ;",nativeQuery = true)
    void updatename(@Param("name") String name, @Param("id") int id );
}
