package com.TheVeggieCart.Service;

import com.TheVeggieCart.Model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer removeCustomer(Integer customerid);
    Customer viewCustomerById(Integer customerID);
    List<Customer> viewCustomerList(String loc);
}

