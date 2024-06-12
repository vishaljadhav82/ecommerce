package com.ecommerce.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Orders;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Orders> getAllOrderOfProduct(Long productId) {
		// TODO Auto-generated method stub
		List<Orders> orders = orderRepository.findAll().stream().filter(e -> e.getProducts().getId() == productId).toList();
				return orders;
		//return orderRepository.findByProducts(productId);
	}

	@Override
	public List<Orders> getAllOrderOfCustomer(Long customerId) {
		// TODO Auto-generated method stub
		//List<Orders> orders = orderRepository.findAll().stream().filter(e -> e.getCustomerId() == customerId).toList();
		//return orders;
		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public Orders saveNewOrder(Orders order,Long productId) {
		// TODO Auto-generated method stub
		order.setProducts(productRepository.findById(productId).get());
		order.setCreatedDate(new Date());
		order.setUpdatedDate(new Date());
		return orderRepository.save(order);
	}

	@Override
	public Orders getOrderById(Long ordersId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(ordersId).get();
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

}
