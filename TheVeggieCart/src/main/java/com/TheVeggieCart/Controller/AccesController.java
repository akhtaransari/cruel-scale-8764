//package com.TheVeggieCart.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.TheVeggieCart.Model.User;
//import com.TheVeggieCart.ServiceImpl.LoginServiceImpl;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/acces")
//@Slf4j
//public class AccesController {
//	
//	@Autowired
//	LoginServiceImpl loginService;
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	
//	@PostMapping("/auth/login")
//    public ResponseEntity<User> validateLogin(@RequestBody Authentication auth) {
//			auth.setPassword(passwordEncoder.encode(auth.getPassword()));
//            log.info("Validated login for user with username: {}", auth.getUsername());
//            return new ResponseEntity<>(loginService.validateLogin(auth), HttpStatus.OK);
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<User> logout(@RequestBody User user) {
//    	log.info("User Logged Out with username: {}", user.getUsername());
//        return null;
//    }
//}
