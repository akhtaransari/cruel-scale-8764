package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.TheVeggieCart.Model.Orders;
import com.TheVeggieCart.ServiceImpl.OrderServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@Slf4j

public class OrderController {
	
	@Autowired
	OrderServiceImpl orderService;
	
	
	@PostMapping("/addOrder/{customerID}")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order, @PathVariable Integer customerID) {
        
            log.info("Added new order with ID: {} for customer ID: {}", customerID);
            return new ResponseEntity<>(orderService.addOrder(order, customerID),HttpStatus.OK);
        
    }

    @PutMapping("/updateOrderDetails")
    public ResponseEntity<Orders> updateOrderDetails(@RequestBody Orders order) {
        
            log.info("Updated order with ID: {}", order.getOrderId());
            return new ResponseEntity<>(orderService.updateOrderDetails(order),HttpStatus.OK);
    }

    @GetMapping("/viewAllOrders")
    public ResponseEntity<List<Orders>> viewAllOrders() {
        
            log.info("Viewed all orders.");
            return new ResponseEntity<>(orderService.viewAllOrders(),HttpStatus.OK);
    }

    @DeleteMapping("/cancelOrder/{orderid}")
    public ResponseEntity<Orders> cancelOrder(@PathVariable int orderid) {
        
            log.info("Canceled order with ID: {}", orderid);
            return new ResponseEntity<>(orderService.cancelOrder(orderid),HttpStatus.OK);
    }
}
