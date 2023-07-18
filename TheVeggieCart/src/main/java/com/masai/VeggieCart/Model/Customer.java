package com.masai.VeggieCart.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
