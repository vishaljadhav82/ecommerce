package com.ecommerce.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Cart> getCartByUserId(Long userId) {
		return userRepository.findById(userId).get().getCart();
	}

	@Override
	@Transactional
	public void addProductToCart(Long cartId, Long productId) {
		Cart cart = getCartById(cartId);
		
		Product product =	cart.getCartItems().stream().filter(e -> e.getId() == productId).findFirst().orElse(null);
		if(product == null) {
			cart.getCartItems().add(productRepository.findById(productId).get());
		cart.setUpdatedAt(LocalDateTime.now());
		cartRepository.save(cart);
		}

	}

	@Override
	@Transactional
	public void removeProductFromCart(Long userId, Long productId) {
		Cart cart = getCartById(userId);
		cart.getCartItems().removeIf(item -> item.getId() == productId);
		cart.setUpdatedAt(LocalDateTime.now());
		cartRepository.save(cart);

	}

	@Override
	@Transactional
	public void clearCart(Long cartId) {
		Cart cart = getCartById(cartId);
		if (cart != null) {
			cart.getCartItems().clear();
			cart.setUpdatedAt(LocalDateTime.now());
			cartRepository.save(cart);
		}
	}

	public List<Cart> getAllOrCreateCart(Long userId) {
		User user = userRepository.findById(userId).get();

		if (user.getCart() == null) {
			Cart newCart = new Cart();
			// Set user (assuming you have a User entity and UserService)
			// cart.setUser(userService.getUserById(userId));
			newCart.setCreatedAt(LocalDateTime.now());
			newCart.setUpdatedAt(LocalDateTime.now());
			user.getCart().add(newCart);
			return userRepository.save(user).getCart();
		}
		return user.getCart();
	}

	@Override
	public Cart getCartById(long id) {
		// TODO Auto-generated method stub
		return cartRepository.findById(id).get();
	}

	@Override
	public void createNewCart(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).get();

			Cart newCart = new Cart();
			
			newCart.setCreatedAt(LocalDateTime.now());
			newCart.setUpdatedAt(LocalDateTime.now());
			user.getCart().add(newCart);
			userRepository.save(user);
		
	}
}
