/**
 * 
 */
package com.TheVeggieCart.Exception;

/**
 * @author ACCESS INFO
 *
 */
public class BillNotFoundException extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public BillNotFoundException(String message) {
        super(message);
    
	}
}
