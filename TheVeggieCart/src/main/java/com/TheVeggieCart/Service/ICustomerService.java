package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.Customer;

public interface ICustomerService {

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer removeCustomer(Customer customer);
    Customer viewCustomer(Customer customer);
    List<Customer> viewCustomerList(String loc);

}

