package com.TheVeggieCart.Service;

import com.TheVeggieCart.Model.Orders;
import java.util.List;

public interface IOrderService {
	Orders addOrder(Orders order, Integer customerID);

	//Orders viewOrder(Orders order);

	Orders updateOrderDetails(Orders order);

	List<Orders> viewAllOrders();

	Orders cancelOrder(int orderid);
}
