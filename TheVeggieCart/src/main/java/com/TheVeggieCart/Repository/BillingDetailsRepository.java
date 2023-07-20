package com.TheVeggieCart.Repository;

import com.TheVeggieCart.Model.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails, Integer> {

}
