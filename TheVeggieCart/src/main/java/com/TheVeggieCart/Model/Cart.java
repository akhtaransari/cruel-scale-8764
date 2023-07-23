
package com.TheVeggieCart.Model;

<<<<<<< HEAD
import java.util.List;

import jakarta.persistence.CascadeType;
=======
import java.util.Set;

>>>>>>> main
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;

<<<<<<< HEAD
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private List<VegetableDTO> vegetables;
	
	
	
=======
	@OneToOne
	@NotNull
	private Customer customerId;
	
	@OneToMany
	private Set<VegetableDTO> vegitableList;

>>>>>>> main
}
