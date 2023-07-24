package com.TheVeggieCart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VegetableDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long vegId;

	@Size(min=3)
	private String name;
	

	private String type; 

	private Double price;
	

	private Double quantity;

  
		
}
