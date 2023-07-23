package com.TheVeggieCart.Model;

<<<<<<< HEAD



=======
>>>>>>> main
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.Min;
>>>>>>> main
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
	private Double price;
	
	@NotNull
	private Double quantity;

  
		
}
