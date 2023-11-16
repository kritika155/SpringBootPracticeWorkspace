package com.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.Service.CustomerService;
import com.product.entity.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
@Autowired
private CustomerService customerService;
public CustomerController( 
		CustomerService customerService) 
{ 
	this.customerService = customerService; 
} 
@PostMapping("/add")
public Customer addNewCustomer(@RequestBody Customer newCustomer){
    return customerService.addNewCustomer(newCustomer);
} 
// view all customers
@GetMapping("view/all")
public @ResponseBody Iterable<Customer> getAllCustomers(){
    return customerService.getAllCustomers();
}

// view specific customer
@GetMapping("view/{id}")
public Customer getCustomer(@PathVariable Integer id) {
    return customerService.getCustomer(id);
}

// update an existing customer
@PutMapping("/edit/{id}")
public String update( @RequestBody Customer updateCustomer, @PathVariable Integer id) {
    return customerService.update(updateCustomer,id);
}

// delete customer
@DeleteMapping("delete/{id}")
public String delete(@PathVariable("id")Integer id) {
	return customerService.delete(id); 
}
}
