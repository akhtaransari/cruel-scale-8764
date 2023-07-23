package com.TheVeggieCart.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheVeggieCart.Exception.VegetableNotFoundException;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Repository.VegetableDTORepository;
import com.TheVeggieCart.Service.IVegetableService;

@Service
<<<<<<< HEAD:TheVeggieCart/src/main/java/com/TheVeggieCart/Service/IVegetableServiceImpl.java
public class IVegetableServiceImpl implements IVegetableService {
=======
public class VegetableServiceImpl implements IVegetableService {
>>>>>>> main:TheVeggieCart/src/main/java/com/TheVeggieCart/ServiceImpl/VegetableServiceImpl.java

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
	public VegetableDTO removeVegetable(Long vegId) {
		Optional<VegetableDTO> vd = vegetableDTORepository.findById(vegId);
		

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

	@Override
	public String deleteVeg(Long id) {
		// TODO Auto-generated method stub
		vegetableDTORepository.deleteById(id);
		return "Deleted";
	}

}
