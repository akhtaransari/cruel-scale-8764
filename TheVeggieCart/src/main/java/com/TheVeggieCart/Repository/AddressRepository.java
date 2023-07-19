package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	

}
