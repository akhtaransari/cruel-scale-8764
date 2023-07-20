package com.TheVeggieCart.Repository;

import com.TheVeggieCart.Model.VegetableDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableDTORepository extends JpaRepository<VegetableDTO, Long> {
    
}
