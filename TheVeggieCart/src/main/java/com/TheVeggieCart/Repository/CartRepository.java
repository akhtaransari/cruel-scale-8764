package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.Cart;
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
