package com.TheVeggieCart.Exception;

public class VegetableNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public VegetableNotFoundException(String message) {
        super(message);
    }
}
