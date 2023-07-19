package com.TheVeggieCart.Services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswordChangeRequest {	
	private Long userId;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String oldPassword;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String newPassword;
	
}
