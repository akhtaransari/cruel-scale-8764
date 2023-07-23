package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.Admin;
import com.TheVeggieCart.ServiceImpl.AdminServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@Slf4j
public class BasicAdminController {
	
	AdminServiceImpl adminService;
	
	@PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        
            log.info("Added new admin with ID: {}", admin.getName());
            return new ResponseEntity<>(adminService.addAdmin(admin),HttpStatus.OK);
        
    }

    @PutMapping("/updateAdmin")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        
            log.info("Updated admin with ID: {}", admin.getName());
            return new ResponseEntity<>(adminService.updateAdmin(admin),HttpStatus.OK);
        
    }

    @DeleteMapping("/removeAdmin/{adminId}")
    public ResponseEntity<Admin> removeAdmin(@PathVariable Integer adminId) {
        
            log.info("Removed admin with ID: {}", adminId);
            return new ResponseEntity<>(adminService.removeAdmin(adminId),HttpStatus.OK);
        
    }

    @GetMapping("/viewAdmin")
    public ResponseEntity<Admin> viewAdmin(@RequestBody Admin admin) {
            log.info("Viewed admin with ID: {}", admin.getName());
            return new ResponseEntity<>(adminService.viewAdmin(admin),HttpStatus.OK);
    }
    @GetMapping("/viewAllAdmin")
    public ResponseEntity<List<Admin>> viewAdmin() {
            log.info("Viewed admins list ");
            return new ResponseEntity<>(adminService.viewAdmins(),HttpStatus.OK);
    }
    
	
}
