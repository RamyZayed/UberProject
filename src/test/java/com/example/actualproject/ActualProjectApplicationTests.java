package com.example.actualproject;

import com.example.actualproject.entity.*;
import com.example.actualproject.repository.EmployeeRepository;
import com.example.actualproject.repository.PersonRepository;
import org.apache.catalina.util.CustomObjectInputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class ActualProjectApplicationTests {
/*
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void adding(){
        Customer customer = new Customer();
        customer.setAge(21);
        customer.setName("Masoud");
        Address address = new Address();
        address.setCity("Ramallah");
        address.setStreet("BATOOONIA");
        address.setCountry("Palestine");
        customer.setAddress(address);




        Employee employee = new Employee();
        employee.setAge(22);
        employee.setRanking("Bronze");
        employee.setName("Harithh");
      //  employee.setCarType("Nour_Alhuda");
        employee.setSalary(1500);
        employee.setAddress(address);

        personRepository.save(customer);
    }

    @Test
    public void testManyToManyAdding(){
        Employee e = new Employee();
        e.setName("Harith");
        e.setSalary(4000);
        e.setAge(21);
        e.setRanking("Challenger");
        Address address = new Address();
        address.setStreet("EKleem BAtonia");
        address.setCity("Ramallah");
        address.setCountry("Palestine");
        e.setAddress(address);

        Set<Car> cars = new HashSet<>();
        Car c1 = new Car();
        c1.setColor("Red");
        c1.setType("BMW");
        c1.setLicenseNumber(21312);
        cars.add(c1);

        Car c2 = new Car();
        c2.setColor("White");
        c2.setType("idk");
        c2.setLicenseNumber(67867);
        cars.add(c2);

        e.setCars(cars);

            employeeRepository.save(e);


    }

    @Test
    public void testFindEmployee(){
        Optional<Employee> e = employeeRepository.findById(1);
        if(e.isPresent()){
            System.out.println(e.get().toString());
            System.out.println(e.get().getCars());
        }

    }


    @Test
    public void FindRedCars(){
        List<Object[]> redcars =employeeRepository.findcarsbyColor("red");
        for(Object[] b:redcars)
        {
            System.out.println(b[0]);
        }
    }

    @Test
    public void addPersonWithNumber(){
        Customer c = new Customer();
        c.setAge(15);
        c.setName("Hashinshin");
        Address address = new Address();
        address.setStreet("Pedophile Strret");
        address.setCity("Little");
        address.setCountry("USA");

        PhoneNumber p1 = new PhoneNumber();
        p1.setNumber("0593211");
        p1.setType("Personal");

        PhoneNumber p2 = new PhoneNumber();
        p2.setNumber("0293123");
        p2.setType("Home");

        c.setAddress(address);
        c.addPhoneNumber(p1);
        c.addPhoneNumber(p2);

        personRepository.save(c);

    }

    @Test
    public void addLicense(){
        License license = new License();
        license.setValidFrom(new Date());
        license.setValidTo(new Date());

        Customer c = new Customer();
        c.setAge(25);
        c.setName("Anwar");
        Address address = new Address();
        address.setStreet("Tira");
        address.setCity("Ramallah");
        address.setCountry("Palestine");

        PhoneNumber p1 = new PhoneNumber();
        p1.setNumber("0597376491");
        p1.setType("Personal");

        license.setPerson(c);
        c.setAddress(address);
        c.addPhoneNumber(p1);
        c.setLicense(license);

        personRepository.save(c);


    }


    @Test
    public void testing(){
        List<Object[]> r = personRepository.Somethingidk();
        for (Object[] d : r)
        {
            System.out.println(d[0]);
        }
    }

    @Test
    public void testJpaProject(){
        PersonView personView = personRepository.getPersonByAge(25).get(1);
      //  System.out.println(personView.getName());

    }

    @Test
    public void testOpenProjection(){
        PersonView pp = personRepository.getPersonByAge(25).get(0);
        System.out.println(pp.getNameWithAge());

    }*/
}
