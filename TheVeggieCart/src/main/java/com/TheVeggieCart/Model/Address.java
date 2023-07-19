package com.TheVeggieCart.Model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Address {

	@NotNull
	private String flatNo;
	
	@NotNull
	private String buildingName;
	
	@NotNull
	private String area;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	@Min(value=6)
	private String pincode;
	
	
}
