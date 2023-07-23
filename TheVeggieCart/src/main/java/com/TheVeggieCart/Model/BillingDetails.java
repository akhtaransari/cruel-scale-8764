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
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class BillingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billingId;

	
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_id")
    private List<VegetableDTO> vegetables;
	
	@NotNull
	private Double totalAmount;

	@NotNull
	private Double finalBillWithGST;
	
	@NotNull
	private String status;

	

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = vegetables.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();;
	}

	public void setFinalBillWithGST(Double finalBillWithGST) {
		this.finalBillWithGST = totalAmount * 0.18;;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
