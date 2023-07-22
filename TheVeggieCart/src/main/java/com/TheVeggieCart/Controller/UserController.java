package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.TheVeggieCart.ServiceImpl.AdminServiceImpl;
import com.TheVeggieCart.ServiceImpl.BillingServiceImpl;
import com.TheVeggieCart.ServiceImpl.CartServiceImpl;
import com.TheVeggieCart.ServiceImpl.CustomerServiceImpl;
import com.TheVeggieCart.ServiceImpl.IfeedbackServiceImpl;
import com.TheVeggieCart.ServiceImpl.LoginServiceImpl;
import com.TheVeggieCart.ServiceImpl.OrderServiceImpl;
import com.TheVeggieCart.ServiceImpl.VegetableServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	BillingServiceImpl billingService;
	@Autowired
	CartServiceImpl cartService;
	@Autowired
	CustomerServiceImpl customerService;
	@Autowired
	IfeedbackServiceImpl feebackService;
	@Autowired
	LoginServiceImpl loginService;
	@Autowired
	OrderServiceImpl orderService;
	@Autowired
	VegetableServiceImpl vegetableService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        log.info("Registering user: {}",user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));        
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/login/auth")
    public ResponseEntity<String> loginUser(@RequestBody Authentication auth) {
        log.info("User login attempt for username: {}", auth.getUsername());
              
        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
        log.info("Fetching user profile for ID: {}", userId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<String> updateUserProfile(@PathVariable Long userId, @RequestBody User updatedUser) {
        log.info("Updating user profile for ID: {}", userId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/password")
    public ResponseEntity<String> changeUserPassword(@PathVariable Long userId, @RequestBody PasswordChangeRequest request) {
        log.info("Changing password for user ID: {}", userId);
        return new ResponseEntity<>("User password changed successfully", HttpStatus.OK);
    }

    @GetMapping("/VegetableDTOs")
    public ResponseEntity<List<VegetableDTO>> getAllVegetableDTOs() {
        log.info("Fetching all VegetableDTOs");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/VegetableDTOs/{VegetableDTOId}")
    public ResponseEntity<VegetableDTO> getVegetableDTOById(@PathVariable Integer VegetableDTOId) {
        log.info("Fetching VegetableDTO with ID: {}", VegetableDTOId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable Integer customerId) {
        log.info("Fetching cart for customer with ID: {}", customerId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/cart/{VegetableDTOId}")
    public ResponseEntity<VegetableDTO> addVegetableDTOToCart(@PathVariable Integer VegetableDTOId) {
        log.info("Adding VegetableDTO with ID {} to cart", VegetableDTOId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{VegetableDTOId}")
    public ResponseEntity<VegetableDTO> removeVegetableDTOFromCart(@PathVariable Integer VegetableDTOId) {
        log.info("Removing VegetableDTO with ID {} from cart", VegetableDTOId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/cart/{VegetableDTOId}")
    public ResponseEntity<List<Cart>> updateCartItemQuantity(@PathVariable Integer VegetableDTOId, @RequestBody Cart cart) {
        log.info("Updating cart item quantity for VegetableDTO with ID: {}", VegetableDTOId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<Cart> clearCart(@PathVariable Integer cartId) {
        log.info("Clearing cart with ID: {}", cartId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> placeOrder(@RequestBody Orders order) {
    	
        log.info("Placing an order for user with ID: {}", order.getCustomer().getName());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getUserOrders() {
        log.info("Fetching all orders for the user");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer orderId) {
        log.info("Fetching order with ID: {}", orderId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Orders> cancelOrder(@PathVariable Integer orderId) {
        log.info("Canceling order with ID: {}", orderId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/orders/{orderId}/feedback")
    public ResponseEntity<Feedback> addFeedbackToOrder(@PathVariable Integer orderId, @RequestBody Feedback feedback) {
        log.info("Adding feedback to order with ID: {}", orderId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}/feedback")
    public ResponseEntity<Feedback> getFeedbackForOrder(@PathVariable Integer orderId) {
        log.info("Fetching feedback for order with ID: {}", orderId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
