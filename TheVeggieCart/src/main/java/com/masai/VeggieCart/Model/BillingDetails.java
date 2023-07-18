package com.masai.VeggieCart.Model;

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
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billingId;
	
	@OneToOne
	private Orders orderid;
	
	@OneToOne
	private Customer customerid;
	
	@OneToMany
	private List<VegetableDTO> vegetableList;
	
	@NotNull
	private Double totalAmount;
	
	@NotNull
	private String status;
	
}
