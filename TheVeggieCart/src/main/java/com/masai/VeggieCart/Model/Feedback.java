package com.masai.VeggieCart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;
	
	@NotNull
	@OneToOne
	private Customer customerId;
	
	@NotNull
	@OneToOne
	private VegetableDTO vegetableId;
	
	@NotNull
	private Integer rating;
	
	@NotNull
	private String comments;
	
}
