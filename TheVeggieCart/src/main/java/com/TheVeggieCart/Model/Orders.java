package com.TheVeggieCart.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="orders_table")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	@ManyToOne
	@NotNull
	private Customer customerId;
	
	@OneToMany
	@NotNull
	private List<VegetableDTO> vegetableList;
	
	@NotNull
	private Double totalAmount;
	
	@NotNull
	private String status;
}
