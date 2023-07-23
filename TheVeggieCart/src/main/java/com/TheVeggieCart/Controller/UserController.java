package com.TheVeggieCart.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> main
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.User;
<<<<<<< HEAD
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Service.IOrderService;
=======
>>>>>>> main
import com.TheVeggieCart.Service.PasswordChangeRequest;
import com.TheVeggieCart.ServiceImpl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
<<<<<<< HEAD
@CrossOrigin
public class UserController {
	
	@Autowired
	private IOrderService orderService;

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
        return new ResponseEntity<>(orderService.viewAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer orderId) {
    	return new ResponseEntity<>(null, HttpStatus.CREATED);
=======
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
            log.info("Added new User with ID: {}", user.getUsername());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        
            log.info("Updated User with ID: {}", user.getUsername());
            return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
>>>>>>> main
        
    }

    @DeleteMapping("/removeUser/{userId}")
    public ResponseEntity<User> removeUser(@PathVariable Long userId) {
        
            log.info("Removed User with ID: {}", userId);
            return new ResponseEntity<>(userService.removeUser(userId),HttpStatus.OK);
        
    }

    @GetMapping("/viewUser/{userId}")
    public ResponseEntity<User> viewUser(@PathVariable Long userId) {
            log.info("Viewed User with ID: {}", userId);
            return new ResponseEntity<>(userService.viewUser(userId),HttpStatus.OK);
    }
    @GetMapping("/viewAllUser")
    public ResponseEntity<List<User>> viewUsers() {
            log.info("Viewed Users list ");
            return new ResponseEntity<>(userService.viewUsers(),HttpStatus.OK);
    }
    
    
    @PostMapping("/updatePassword")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest , @PathVariable Long userId) {
            log.info("Password Chaned for  User with ID: {}", userId);
            passwordChangeRequest.setNewPassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));
            return new ResponseEntity<>(userService.changePassword(passwordChangeRequest,userId),HttpStatus.OK);
    }
    
}
