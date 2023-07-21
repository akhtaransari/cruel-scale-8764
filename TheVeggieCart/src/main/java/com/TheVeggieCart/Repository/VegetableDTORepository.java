package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TheVeggieCart.Model.VegetableDTO;

@Repository
public interface VegetableDTORepository extends JpaRepository<VegetableDTO, Long> {

}
