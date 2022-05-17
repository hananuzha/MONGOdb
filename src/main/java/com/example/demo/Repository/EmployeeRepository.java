package com.example.demo.Repository;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{firstName:'?0'}")
    public Employee findByFirstName(String firstName);

    List<Employee> findByHireDateGreaterThan(Date hireDate);

    public List<Employee> findByLastName(String lastName);

    @Query(value="{email:'?0'}", fields="{'firstName' : 1, 'lastName' : 1}")
    public Optional<Employee> findByEmail(String email);


    @Query("{salary : {$gte : ?0} }")
    public List<Employee> findWithCondition(int salary);


//    @Query(value="{'email' : $0}", delete = true)
    public void deleteByEmail(String email);

    public long count();


}
