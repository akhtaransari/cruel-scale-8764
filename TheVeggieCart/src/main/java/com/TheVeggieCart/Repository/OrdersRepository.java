package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
