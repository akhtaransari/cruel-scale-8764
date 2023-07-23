package com.TheVeggieCart.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordChangeRequest {	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String newPassword;
	
}
