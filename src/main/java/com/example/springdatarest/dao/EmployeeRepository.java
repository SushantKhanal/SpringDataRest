package com.example.restcrud.dao;

import com.example.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's it .... n need to write any code LOL!

}
