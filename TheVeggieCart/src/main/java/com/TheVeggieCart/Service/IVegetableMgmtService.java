package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.VegetableDTO;

public interface IVegetableMgmtService {

    VegetableDTO addVegetable(VegetableDTO veg);
    VegetableDTO updateVegetable(VegetableDTO veg);
    VegetableDTO removeVegetable(VegetableDTO veg);
    List<VegetableDTO> viewAllVegetables();
    List<VegetableDTO> viewVegetableList(String category);
    List<VegetableDTO> viewVegetableByName(String name);

}

