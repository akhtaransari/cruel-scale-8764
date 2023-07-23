
package com.TheVeggieCart.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.TheVeggieCart.Exception.OrderNotFoundException;
import com.TheVeggieCart.Exception.UserNotFoundException;
import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.Repository.CustomerRepository;
import com.TheVeggieCart.Service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if (!customerRepository.existsById(customer.getCustomerId())) {
            throw new UserNotFoundException("Customer not found with ID: " + customer.getCustomerId());
        }
		Optional<Customer> c = customerRepository.findById(customer.getCustomerId());
		
		Customer c1 = c.get();
		c1.setAddress(c1.getAddress());
		c1.setCustomerId(c1.getCustomerId());
		c1.setEmail(c1.getEmail());
		c1.setMobileNumber(c1.getMobileNumber());
		c1.setName(c1.getName());
		c1.setVegitableList(c1.getVegitableList());
        return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerById(Integer customerID) {
		
		Optional<Customer> cus = customerRepository.findById(customerID);
		Customer c = cus.get();
		if (c == null) {
			throw new OrderNotFoundException("order not found!");
		}
		return c;
	}

	@Override
	public List<Customer> viewCustomerList(String loc) {
		
		List<Customer> cl = customerRepository.findAll();
		if (cl.isEmpty()) {
			throw new OrderNotFoundException("order not found!");
		}
		return cl;
		
	}

	@Override
	public Customer removeCustomer(Integer customerId) {
		Optional<Customer> cus = customerRepository.findById(customerId);
		Customer c = cus.get();
		
		if (cus.isEmpty()) throw new UserNotFoundException("Customer not found!");
		customerRepository.delete(c);
		return c;
	}

}
