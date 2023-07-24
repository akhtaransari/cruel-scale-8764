package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.ServiceImpl.VegetableServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vegetabales")
@CrossOrigin
@Slf4j
public class VegetableController {
	@Autowired
	VegetableServiceImpl vegetableService;
	
	
	@PostMapping("/addVegetable")
    public ResponseEntity<VegetableDTO> addVegetable(@RequestBody VegetableDTO veg) {
       
            log.info("Added new vegetable with ID: {}", veg.getVegId());
            return new ResponseEntity<>(vegetableService.addVegetable(veg),HttpStatus.OK);
    }

    @PutMapping("/updateVegetable")
    public ResponseEntity<VegetableDTO> updateVegetable(@RequestBody VegetableDTO veg) {
        
            log.info("Updated vegetable with ID: {}", veg.getVegId());
            return new ResponseEntity<>(vegetableService.updateVegetable(veg),HttpStatus.OK);
    }

    @DeleteMapping("/removeVegetable/{vegId}")
    public ResponseEntity<VegetableDTO> removeVegetable(@PathVariable Long vegId) {
        
            log.info("Removed vegetable with ID: {}", vegId);
            return new ResponseEntity<>(vegetableService.removeVegetable(vegId),HttpStatus.OK);
    }

    @GetMapping("/viewAllVegetables")
    public ResponseEntity<List<VegetableDTO>> viewAllVegetables() {
        
            log.info("Viewed all vegetables.");
            return new ResponseEntity<>(vegetableService.viewAllVegetables(),HttpStatus.OK);
        
    }
}
