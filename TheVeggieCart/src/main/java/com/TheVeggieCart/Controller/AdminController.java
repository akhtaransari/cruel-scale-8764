package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.Feedback;
import com.TheVeggieCart.Model.Orders;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Service.IFeedbackService;
import com.TheVeggieCart.Service.IOrderService;
import com.TheVeggieCart.Service.IVegetableService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping
@Slf4j
public class AdminController {

	@Autowired
	private IOrderService orderService;
	
//	@Autowired
//	private ICustomerService customerService;
//	
	@Autowired
	private IFeedbackService feedbackService;
//	
	@Autowired
	private IVegetableService vegService;
	
	
	@GetMapping("/Orders/admin")
	public ResponseEntity<List<Orders>> getAllOrder(){
		return new ResponseEntity<>(orderService.viewAllOrders(), HttpStatus.OK);
	}
	
	@PutMapping("/Orders/update/admin")
	public ResponseEntity<Orders> updateOrders(@RequestBody Orders order){
		return new ResponseEntity<>(orderService.updateOrderDetails(order), HttpStatus.OK);
	}
	
	@DeleteMapping("/CancelOrder/admin/{id}")
	public ResponseEntity<String> cancelOrder(@PathVariable int id){
		orderService.cancelOrder(id);
		return new ResponseEntity<>("Cancelled", HttpStatus.OK);
	}
	@PostMapping("/VegetablesAdd/admin")
	public ResponseEntity<VegetableDTO> createVegetable(@RequestBody VegetableDTO veg){
		return new ResponseEntity<>(vegService.addVegetable(veg), HttpStatus.OK);
	}
	@GetMapping("/Vegetables/admin")
	public ResponseEntity<List<VegetableDTO>> getVegetable(){
		return new ResponseEntity<>(vegService.viewAllVegetables(), HttpStatus.OK);
	}
	
	@PatchMapping("/VegetablesUpdate/admin")
	public ResponseEntity<VegetableDTO> updateVeg(@RequestBody VegetableDTO veg){
		return new ResponseEntity<>(vegService.updateVegetable(veg),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/VegetableDelete/admin/{id}")
	public ResponseEntity<String> deleteVeg(@PathVariable Long id){
		return new ResponseEntity<>(vegService.deleteVeg(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Feedback/admin")
	public ResponseEntity<List<Feedback>> feedback(){
		return new ResponseEntity<>(feedbackService.viewFeedbackAll(),HttpStatus.ACCEPTED);
	}

	
}
