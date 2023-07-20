package com.TheVeggieCart.Service;

import java.time.LocalDate;
import java.util.List;

import com.TheVeggieCart.Model.Orders;

public interface IOrderService {

	Orders addOrder(Orders order);

	Orders viewOrder(Orders order);

	Orders updateOrderDetails(Orders order);

	List<Orders> viewAllOrders(int custid);

	List<Orders> viewAllOrders(LocalDate date);

	List<Orders> viewOrderList();

	Orders cancelOrder(int orderid);

}
