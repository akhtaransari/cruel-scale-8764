package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.Cart;
import com.TheVeggieCart.Model.VegetableDTO;

public interface ICartService {

    VegetableDTO addToCart(VegetableDTO veg);
    Cart increaseVegQuantity(int vegid, int quantity);
    Cart decreaseVegQuantity(int vegid, int quantity);
    Cart removeVegetable(int id);
    Cart removeAllVegetables();
    List<VegetableDTO> viewAllItems();

}

