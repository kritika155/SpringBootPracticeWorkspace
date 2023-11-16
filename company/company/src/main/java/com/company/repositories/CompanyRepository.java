package com.company.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.models.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer>{
	 Company findById(int id); 
	    List<Company> findAll(); 
	    void deleteById(int id); 
}
