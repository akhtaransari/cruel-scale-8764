package com.TheVeggieCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheVeggieCart.Exception.OrderNotFoundException;
import com.TheVeggieCart.Exception.UserNotFoundException;
import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.Model.Orders;
import com.TheVeggieCart.Repository.CartRepository;
import com.TheVeggieCart.Repository.CustomerRepository;
import com.TheVeggieCart.Repository.OrdersRepository;
import com.TheVeggieCart.Repository.VegetableDTORepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private VegetableDTORepository vegetableRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders addOrder(Orders order, Integer customerID) {
		// TODO Auto-generated method stub
		Optional<Customer> customers = customerRepository.findById(customerID);
		Customer custmer = customers.get();
		if (custmer == null) {
			new UserNotFoundException("User Not Found");
		}
		order.setCustomer(custmer);
		return ordersRepository.save(order);
	}

	@Override
	public Orders updateOrderDetails(Orders order) {
		Optional<Orders> orders = ordersRepository.findById(order.getOrderId());

		Orders o = orders.get();

		if (o == null) {
			throw new OrderNotFoundException("order not found!");
		}

		return ordersRepository.save(o);
	}

	@Override
	public List<Orders> viewAllOrders() {
		List<Orders> ol = ordersRepository.findAll();
		if (ol.isEmpty()) {
			throw new OrderNotFoundException("order not found!");
		}
		return ol;
	}

	@Override
	public Orders cancelOrder(int orderid) {
		Optional<Orders> orders = ordersRepository.findById(orderid);

		Orders o = orders.get();

		if (o == null) {
			throw new OrderNotFoundException("order not found!");
		}

		ordersRepository.delete(o);
		return o;
	}

}
