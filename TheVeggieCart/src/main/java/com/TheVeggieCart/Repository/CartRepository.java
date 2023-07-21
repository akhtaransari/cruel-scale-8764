package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheVeggieCart.Model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
