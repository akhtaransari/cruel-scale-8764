package com.TheVeggieCart.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
<<<<<<< HEAD
import jakarta.persistence.criteria.Order;
=======
>>>>>>> main
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
<<<<<<< HEAD
	
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "customer_id_customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_id")
    private List<VegetableDTO> vegetables;
	
=======
	private Integer orderid;
	private Integer customerid;
	
	@OneToMany
	private List<VegetableDTO> vegetableList;
>>>>>>> main
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
