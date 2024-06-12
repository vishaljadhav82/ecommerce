package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Orders;
import com.ecommerce.serviceImpl.OrderServiceImpl;

@RestController
@RequestMapping("/api/order")
public class OrdersController {

	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@GetMapping("/product/{productId}")
	public List<Orders> getAllOrderOfProduct(@PathVariable Long productId) {
		// TODO Auto-generated method stub
		return orderServiceImpl.getAllOrderOfProduct(productId);
	}

	@GetMapping("/customer/{customerId}")
	public List<Orders> getAllOrderOfCustomer(@PathVariable Long customerId) {
		// TODO Auto-generated method stub
		return orderServiceImpl.getAllOrderOfCustomer(customerId);
	}

	@PostMapping("/{productId}")
	public Orders saveNewOrder(@RequestBody Orders order,@PathVariable Long productId) {
		// TODO Auto-generated method stub
		return orderServiceImpl.saveNewOrder(order,productId);
	}

	@GetMapping("/{ordersId}")
	public Orders getOrderById(@PathVariable Long ordersId) {
		// TODO Auto-generated method stub
		return orderServiceImpl.getOrderById(ordersId);
	}

	@GetMapping
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderServiceImpl.getAllOrders();
	}
}
