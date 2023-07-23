package com.TheVeggieCart.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheVeggieCart.Exception.BillNotFoundException;
import com.TheVeggieCart.Model.BillingDetails;
import com.TheVeggieCart.Repository.BillingDetailsRepository;
import com.TheVeggieCart.Service.IBillingService;
@Service
public class BillingServiceImpl implements IBillingService {
	
	   
    @Autowired
    private  BillingDetailsRepository billingRepository;

	@Override
	public BillingDetails addBill(BillingDetails bill) {
		if(bill == null) {
			throw new BillNotFoundException("Bill not found");
		}
		return billingRepository.save(bill);
	}

	@Override
	public BillingDetails updateBill(BillingDetails bill) {
		 if (!billingRepository.existsById(bill.getBillingId())) {
	            throw new BillNotFoundException("Bill not found with ID: " + bill.getBillingId());
	        }
	        return billingRepository.save(bill);
	}

	@Override
	public BillingDetails viewBill(int id) {
		Optional<BillingDetails> findById = billingRepository.findById(id);
		if(!findById.isPresent()) {
			throw new BillNotFoundException("Bill not found with ID: " + id);
		}
		return findById.get();
	}



}
