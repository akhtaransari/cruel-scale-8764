package com.TheVeggieCart.Model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends User{

	@Column(unique = true)
	private Integer customerId;

	@NotNull
	@Size(min=3)
	private String name;

	@NotNull
	@Size(min = 10)
	private String mobileNumber;

	@Embedded
	@NotNull
	private Address Address;

	@NotNull
	@Email
	private String email;

	@NotNull
	@ValidPassword
	private String password;

	@NotNull
	@Transient
	@ValidPassword
	private String confirmPassword;
	
	@OneToMany
	private List<VegetableDTO> vegitableList=new ArrayList<>();
	

}
