package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Service.EmployeeService;
import com.product.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
@Autowired
private EmployeeService employeeService;
public EmployeeController( 
		EmployeeService employeeService) 
{ 
	this.employeeService = employeeService; 
} 

@GetMapping("/employees")
public List<Employee> getEmployees(){
	return employeeService.getEmployee();
}
@GetMapping("/employees/{Id}")
public Optional<Employee> getEmployeesById(@PathVariable(value = "Id")  Integer Id){
	return employeeService.getEmployeeById(Id);
}
@PostMapping("/employees")
public Employee saveEmployees(@RequestBody Employee employee){
	return employeeService.saveEmployee(employee);
}
@PutMapping("/employees/{Id}")
public Employee updateEmployees(@PathVariable(value = "Id") 
Integer Id,@RequestBody Employee employee){
	return employeeService.updateEmployee(Id,employee);
}
@DeleteMapping("/employees/{Id}")
public String deleteEmployees(@PathVariable(value = "Id") 
Integer Id){
	return employeeService.deleteEmployeeById(Id);
}

}
