package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.ServiceImpl.CartServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {
	@Autowired
	CartServiceImpl cartService;

	
	@PostMapping("/addToCart")
    public ResponseEntity<Customer> addToCart(@RequestBody VegetableDTO veg, @RequestParam Integer customerId) {
            log.info("Added vegetable to cart for customer with ID: {}", customerId);
        return new ResponseEntity<>(cartService.addToCart(veg, customerId),HttpStatus.OK);
    }

    @PutMapping("/increaseVegQuantity/{vegid}")
    public ResponseEntity<VegetableDTO> increaseVegQuantity(@PathVariable Long vegid, @RequestParam int quantity) {
            log.info("Increased quantity for vegetable with ID: {}", vegid);
            return new ResponseEntity<>(cartService.increaseVegQuantity(vegid, quantity),HttpStatus.OK);
    }

    @PutMapping("/decreaseVegQuantity/{vegid}")
    public ResponseEntity<VegetableDTO> decreaseVegQuantity(@PathVariable Long vegid, @RequestParam int quantity) {
        
            log.info("Decreased quantity for vegetable with ID: {}", vegid);
            return new ResponseEntity<>(cartService.decreaseVegQuantity(vegid, quantity),HttpStatus.OK);
        
    }

    @DeleteMapping("/removeVegetable/{id}")
    public ResponseEntity<VegetableDTO> removeVegetable(@PathVariable Long id) {
            log.info("Removed vegetable with ID: {}", id);
            return new ResponseEntity<>(cartService.removeVegetable(id),HttpStatus.OK);
    }

    @GetMapping("/viewAllItems")
    public ResponseEntity<List<VegetableDTO>> viewAllItems() {
            log.info("Viewed all items in the cart");
            return new ResponseEntity<>(cartService.viewAllItems(),HttpStatus.OK);
    }
}
