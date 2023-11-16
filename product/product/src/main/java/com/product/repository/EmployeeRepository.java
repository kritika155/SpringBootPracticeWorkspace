package com.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
