package com.masai.VeggieCart.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VegetableDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long vegId;
	
	@NotNull
	@Size(min=3)
	private String name;
	
	@NotNull
	private String type; 
	
	@NotNull
	@Min(value=20)
	private Double price;
	
	@NotNull
	@Min(value=1)
	private Double quantity;
	
	
}
