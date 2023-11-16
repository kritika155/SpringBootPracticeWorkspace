package com.product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entity.Employee;
import com.product.entity.Product;
import com.product.repository.EmployeeRepository;
import com.product.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private  EmployeeRepository employeeRepository; 

	public EmployeeService( 
			EmployeeRepository employeeRepository) 
	{ 
		this.employeeRepository = employeeRepository; 
	} 
public List<Employee> getEmployee(){
	return (List<Employee>) employeeRepository.findAll();
}
public Optional<Employee> getEmployeeById(Integer Id){
	return  employeeRepository.findById(Id);
}
public Employee saveEmployee(Employee employee){
	return  employeeRepository.save(employee);
}
public Employee updateEmployee(Integer Id,Employee updatedEmployee){
	Employee existingEmployee 
	= employeeRepository.findById(Id).orElseThrow( 
		() 
			-> new EntityNotFoundException( 
				String.valueOf(Id)));
	existingEmployee.setName(updatedEmployee.getName());
	return employeeRepository.save(existingEmployee); 
}
public String deleteEmployeeById(Integer Id){
	 employeeRepository.deleteById(Id);
	return "deleted";
}
}
