package com.ecommerce.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	UserRepository user;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		User  p=user.findById(id).get();
		return repository.findById(id).get();
	}

	@Override
	public List<Product> addProduct(long id,Product product) {
		// TODO Auto-generated method stub
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
		User  dbUser=user.findById(id).get();
		dbUser.getProducts().add(product);
		return user.save(dbUser).getProducts();
	}

	@Override
	public Product updateProduct(Product product,long id) {
        Product existingProduct = repository.findById(id).get();
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantityAvailable(product.getQuantityAvailable());
            existingProduct.setImageUrl(product.getImageUrl());
            existingProduct.setUpdatedAt(LocalDateTime.now());
            return repository.save(existingProduct);
        }
        return null; // Handle not found scenario

	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	

}
