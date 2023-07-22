package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.Cart;
import com.TheVeggieCart.Model.Feedback;
import com.TheVeggieCart.Model.Orders;
import com.TheVeggieCart.Model.User;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Service.PasswordChangeRequest;

@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login/auth")
    public ResponseEntity<String> loginUser(@RequestBody Authentication auth) {
        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<String> updateUserProfile(@PathVariable Long userId, @RequestBody User updatedUser) {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/password")
    public ResponseEntity<String> changeUserPassword(@PathVariable Long userId, @RequestBody PasswordChangeRequest request) {
        return new ResponseEntity<>("User password changed successfully", HttpStatus.OK);
    }
    
    @GetMapping("/VegetableDTOs")
    public ResponseEntity<List<VegetableDTO>> getAllVegetableDTOs() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/VegetableDTOs/{VegetableDTOId}")
    public ResponseEntity<VegetableDTO> getVegetableDTOById(@PathVariable Integer VegetableDTOId) {        
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable Integer customerId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/cart/{VegetableDTOId}")
    public ResponseEntity<VegetableDTO> addVegetableDTOToCart(@PathVariable Integer VegetableDTOId) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{VegetableDTOId}")
    public ResponseEntity<VegetableDTO> removeVegetableDTOFromCart(@PathVariable Integer VegetableDTOId) {
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/cart/{VegetableDTOId}")
    public ResponseEntity<List<Cart>> updateCartItemQuantity(@PathVariable Integer VegetableDTOId, @RequestBody Cart cart) {
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<Cart> clearCart(@PathVariable Integer cartId) {
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> placeOrder(@RequestBody Orders order) {

        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getUserOrders() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer orderId) {
    	return new ResponseEntity<>(null, HttpStatus.CREATED);
        
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Orders> cancelOrder(@PathVariable Integer orderId) {
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PostMapping("/orders/{orderId}/feedback")
    public ResponseEntity<Feedback> addFeedbackToOrder(@PathVariable Integer orderId, @RequestBody Feedback feedback) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}/feedback")
    public ResponseEntity<Feedback> getFeedbackForOrder(@PathVariable Integer orderId) {
    	return new ResponseEntity<>(null, HttpStatus.OK);        
    }
}
