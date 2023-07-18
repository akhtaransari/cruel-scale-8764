package com.masai.VeggieCart.Model;

import jakarta.validation.Payload;

public @interface ValidPassword {

	String message() default "Invalid Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
