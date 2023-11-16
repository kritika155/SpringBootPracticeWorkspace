package com.product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Customer;
import com.product.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private  CustomerRepository customerRepository; 

	public CustomerService( 
			CustomerRepository customerRepository) 
	{ 
		this.customerRepository = customerRepository; 
	} 
public  Iterable<Customer> getAllCustomers(){
	return customerRepository.findAll();
}
public Customer getCustomer(Integer id) {
    return customerRepository.findById(id).get();
}
public Customer addNewCustomer(Customer newCustomer){
    Customer user = new Customer();
    user.setName(newCustomer.getName());
    user.setEmail(newCustomer.getEmail());
    customerRepository.save(user);
    return user; 
} 
public String update(Customer updateCustomer, Integer id) {
    return customerRepository.findById(id)
            .map(customer -> {
                  customer.setName(updateCustomer.getName());
                  customer.setEmail(updateCustomer.getEmail());
                  customerRepository.save(customer);
                  return "Customer details have been successfully updated!";
            }).orElseGet(() -> {
                  return "This customer doesn't exist";
            });
}
public String delete(Integer id) {
    customerRepository.deleteById(id); 
    return "Customer has been successfully deleted!";
}
}
