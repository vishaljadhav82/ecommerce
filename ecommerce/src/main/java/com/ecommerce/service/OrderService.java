package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Orders;

public interface OrderService {
	
	List<Orders> getAllOrderOfProduct(Long productId);
	List<Orders> getAllOrderOfCustomer(Long customerId);
	Orders saveNewOrder(Orders order,Long productId);
	Orders getOrderById(Long ordersId);
	List<Orders> getAllOrders();
	

}
