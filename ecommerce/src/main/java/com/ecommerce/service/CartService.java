package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Cart;

public interface CartService {

	List<Cart> getCartByUserId(Long userId);

	Cart getCartById(long id);

	void addProductToCart(Long userId, Long productId);

	void removeProductFromCart(Long userId, Long productId);

	void clearCart(Long userId);
	void createNewCart(Long userId);
}
