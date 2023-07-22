package com.TheVeggieCart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
