package com.TheVeggieCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.TheVeggieCart.Exception.VegetableNotFoundException;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Repository.VegetableDTORepository;

public class IVegetableServiceImpl implements IVegetableService {

	@Autowired
	private VegetableDTORepository vegetableDTORepository;

	@Override
	public VegetableDTO addVegetable(VegetableDTO veg) {
		if (veg == null) {
			throw new VegetableNotFoundException("No Vegetable found!");
		}

		return vegetableDTORepository.save(veg);
	}

	@Override
	public VegetableDTO updateVegetable(VegetableDTO veg) {
		Optional<VegetableDTO> vd = vegetableDTORepository.findById(veg.getVegId());

		VegetableDTO v = vd.get();

		if (v == null) {
			throw new VegetableNotFoundException("No Vegetable found!");
		}

		v.setName(veg.getName());
		v.setPrice(v.getPrice());
		v.setQuantity(v.getQuantity());
		v.setVegId(v.getVegId());
		// all

		return vegetableDTORepository.save(v);
	}

	@Override
	public VegetableDTO removeVegetable(VegetableDTO veg) {
		Optional<VegetableDTO> vd = vegetableDTORepository.findById(veg.getVegId());

		VegetableDTO v = vd.get();

		if (v == null) {
			throw new VegetableNotFoundException("No Vegetable found!");
		}
		vegetableDTORepository.delete(v);
		return v;
	}

	@Override
	public List<VegetableDTO> viewAllVegetables() {
		List<VegetableDTO> vl = vegetableDTORepository.findAll();
		if(vl.isEmpty()) {
			throw new VegetableNotFoundException("No Vegetable found!");
		}
		return vl;
	}

}
