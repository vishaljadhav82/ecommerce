package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Product;

public interface AdminService {

	List<Product> getAllProducts();

	Product getProductById(Long id);

	List<Product> addProduct(long userId, Product product);

	Product updateProduct(Product product, long id);

	void deleteProduct(Long id);

}
