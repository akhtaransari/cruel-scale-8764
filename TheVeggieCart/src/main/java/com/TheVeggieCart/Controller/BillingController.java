package com.TheVeggieCart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.BillingDetails;
import com.TheVeggieCart.ServiceImpl.BillingServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing")
@Slf4j
public class BillingController {
	
	@Autowired
	BillingServiceImpl billingService;
	
	
	@PostMapping("/addBill")
    public ResponseEntity<BillingDetails> addBill(@RequestBody BillingDetails bill) {
            log.info("Added new bill with ID: {}", bill.getBillingId());
            return new ResponseEntity<>(billingService.addBill(bill),HttpStatus.OK);
    }

    @PutMapping("/updateBill")
    public ResponseEntity<BillingDetails> updateBill(@RequestBody BillingDetails bill) {
            log.info("Updated bill with ID: {}", bill.getBillingId());
            return new ResponseEntity<>(billingService.updateBill(bill),HttpStatus.OK);
    }

    @GetMapping("/viewBill/{id}")
    public ResponseEntity<BillingDetails> viewBill(@PathVariable int id) {
        
            log.info("Viewed bill with ID: {}", id);
            return new ResponseEntity<>(billingService.viewBill(id),HttpStatus.OK);
        
    }
}
