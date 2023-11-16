package com.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
