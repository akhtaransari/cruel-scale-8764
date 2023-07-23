package com.TheVeggieCart.Service;

import com.TheVeggieCart.Model.VegetableDTO;

import java.util.List;

public interface IVegetableService {
	VegetableDTO addVegetable(VegetableDTO veg);

	VegetableDTO updateVegetable(VegetableDTO veg);

	VegetableDTO removeVegetable(VegetableDTO veg);

	String deleteVeg(Long id);
	List<VegetableDTO> viewAllVegetables();

}
