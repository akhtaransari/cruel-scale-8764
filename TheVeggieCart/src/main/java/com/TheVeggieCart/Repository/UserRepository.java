package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
