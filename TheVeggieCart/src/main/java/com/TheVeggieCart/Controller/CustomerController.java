package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.ServiceImpl.CustomerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
            log.info("Added new customer with ID: {}", customer.getCustomerId());
            return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
            
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
            log.info("Updated customer with ID: {}", customer.getCustomerId());
            return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);
    }

    @DeleteMapping("/removeCustomer/{customerId}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable Integer customerId) {
            log.info("Removed customer with ID: {}", customerId);
            return new ResponseEntity<>(customerService.removeCustomer(customerId),HttpStatus.OK);
        
    }

    @GetMapping("/viewCustomerById/{customerId}")
    public ResponseEntity<Customer> viewCustomerById(@PathVariable Integer customerId) {
            log.info("Viewed customer details for ID: {}", customerId);
            return new ResponseEntity<>(customerService.viewCustomerById(customerId),HttpStatus.OK);   
    }

    @GetMapping("/viewCustomerList/{loc}")
    public ResponseEntity<List<Customer>> viewCustomerList(@PathVariable String loc) {        
          	log.info("Viewed customer list for location: {}", loc);	
          	return new ResponseEntity<>(customerService.viewCustomerList(loc),HttpStatus.OK);
    }

}
