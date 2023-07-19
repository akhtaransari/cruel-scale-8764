package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
