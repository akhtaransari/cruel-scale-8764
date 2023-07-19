package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
