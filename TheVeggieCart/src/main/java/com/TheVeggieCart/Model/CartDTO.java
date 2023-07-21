package com.TheVeggieCart.Model;

import java.util.List;

import lombok.Data;
@Data
public class CartDTO {
	private Integer cartId;
    private Customer customerId;
    private List<VegetableDTO> vegetableList;

}
