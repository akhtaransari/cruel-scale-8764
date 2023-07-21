package com.TheVeggieCart.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.TheVeggieCart.Exception.UserNotFoundException;
import com.TheVeggieCart.Exception.VegetableNotFoundException;
import com.TheVeggieCart.Model.CartDTO;
import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Repository.CartRepository;
import com.TheVeggieCart.Repository.CustomerRepository;
import com.TheVeggieCart.Repository.VegetableDTORepository;

public class CartService implements ICartService {
	@Autowired
	private VegetableDTORepository vegetableRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;

	private List<VegetableDTO> cartItems = new ArrayList<>();

	@Override
	public Customer addToCart(VegetableDTO veg, Integer customerId) {
		Optional<Customer> customers = customerRepository.findById(customerId);
		Customer custmer = customers.get();
		if (custmer == null) {
			new UserNotFoundException("");
		}
		custmer.getVegitableList().add(veg);

		return customerRepository.save(custmer);
	}

	@Override
	public VegetableDTO increaseVegQuantity(Long vegid, int quantity) {
		Optional<VegetableDTO> vegetables = vegetableRepository.findById(vegid);

		VegetableDTO vegetable = vegetables.get();

		if (vegetable == null) {
			new VegetableNotFoundException("Vegetable Not Found");
		}

		vegetable.setQuantity(vegetable.getQuantity() + quantity);

		return vegetableRepository.save(vegetable);
	}

	@Override
	public VegetableDTO decreaseVegQuantity(Long vegid, int quantity) {
		Optional<VegetableDTO> vegetables = vegetableRepository.findById(vegid);

		VegetableDTO vegetable = vegetables.get();

		if (vegetable == null) {
			new VegetableNotFoundException("Vegetable Not Found");
		}

		vegetable.setQuantity(vegetable.getQuantity() - quantity);
		return vegetableRepository.save(vegetable);
	}

	@Override
	public VegetableDTO removeVegetable(Long id) {
		Optional<VegetableDTO> vegetables = vegetableRepository.findById(id);

		VegetableDTO vegetable = vegetables.get();

		if (vegetable == null) {
			new VegetableNotFoundException("Vegetable Not Found");
		}
		vegetableRepository.delete(vegetable);
		return vegetable;
	}

	@Override
	public List<VegetableDTO> viewAllItems() {
		List<VegetableDTO> vlist = vegetableRepository.findAll();
		if (vlist.isEmpty()) {
			throw new VegetableNotFoundException("Vegetable Not Found");
		}
		return vlist;
	}

}
