package com.TheVeggieCart.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billingId;
	private Integer orderid;
	private Integer customerid;
	
	@OneToMany
	private List<VegetableDTO> vegetableList;
	@NotNull
	private Double totalAmount;
	@NotNull
	private Double finalBillWithGST;
	
	@NotNull
	private String status;

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public void setVegetableList(List<VegetableDTO> vegetableList) {
		this.vegetableList = vegetableList;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = vegetableList.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();;
	}

	public void setFinalBillWithGST(Double finalBillWithGST) {
		this.finalBillWithGST = totalAmount * 0.18;;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
