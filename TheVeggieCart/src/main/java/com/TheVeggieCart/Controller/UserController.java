package com.TheVeggieCart.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.User;
import com.TheVeggieCart.Service.PasswordChangeRequest;
import com.TheVeggieCart.ServiceImpl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
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
