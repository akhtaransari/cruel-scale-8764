package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.VegetableDTO;

public interface VegetableDTORepository extends JpaRepository<VegetableDTO, Long> {

}
