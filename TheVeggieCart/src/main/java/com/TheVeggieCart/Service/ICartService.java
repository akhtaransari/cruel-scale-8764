package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.Model.VegetableDTO;

public interface ICartService {
	Customer addToCart(VegetableDTO veg, Integer customerId);

	VegetableDTO increaseVegQuantity(Long vegid, int quantity);

	VegetableDTO decreaseVegQuantity(Long vegid, int quantity);

	VegetableDTO removeVegetable(Long id);

	List<VegetableDTO> viewAllItems();
}
