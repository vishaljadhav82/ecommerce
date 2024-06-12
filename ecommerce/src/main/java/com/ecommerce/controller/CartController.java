package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Cart;
import com.ecommerce.serviceImpl.CartServiceImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@GetMapping("/getallcart/{userId}")
	public List<Cart> getCartByUserId(@PathVariable Long userId) {
		return cartServiceImpl.getAllOrCreateCart(userId);
	}

	@PostMapping("/addproductincart/{cartId}/{productId}")
	public String addProductToCart(@PathVariable Long cartId,@PathVariable Long productId) {
		 cartServiceImpl.addProductToCart(cartId, productId);
		 return "Product in cart added successfully";
	}
	
	@DeleteMapping("/removeproductincart/{cartId}/{productId}")
	public String removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
		// TODO Auto-generated method stub
		cartServiceImpl.removeProductFromCart(cartId, productId);
     return "Product removed";
	}
	
	@DeleteMapping("/clearcart/{cartId}")
	public String clearCart(@PathVariable Long cartId) {
		// TODO Auto-generated method stub
		cartServiceImpl.clearCart(cartId);
    return "Cart Cleared";
	}

	@GetMapping("/getcartbyid/{id}")
	public Cart getCartById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return cartServiceImpl.getCartById(id);
	}

	@PostMapping("createnewcart/{userId}")
	public String createNewCart(@PathVariable Long userId) {
		// TODO Auto-generated method stub
		cartServiceImpl.createNewCart(userId);
		return "New Cart created";
	}
}
