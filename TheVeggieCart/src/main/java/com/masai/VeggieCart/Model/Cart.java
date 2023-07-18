package com.masai.VeggieCart.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

	@OneToOne
	@NotNull
	private Customer customerId;
	
	@OneToMany
	private List<VegetableDTO> vegitableList=new ArrayList<>();

	
}
