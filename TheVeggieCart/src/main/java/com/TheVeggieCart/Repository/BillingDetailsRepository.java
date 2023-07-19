package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.BillingDetails;

public interface BillingDetailsRepository extends JpaRepository<BillingDetails, Integer> {

}
