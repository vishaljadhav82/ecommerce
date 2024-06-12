package com.ecommerce.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.serviceImpl.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl service;
	
	@GetMapping("/getallproducts")
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return service.getAllProducts();
	}

	@GetMapping("getproduct/{id}")
	public Product getProductById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return service.getProductById(id);
	}

	@PostMapping("/addproduct/{id}")
	public List<Product> addProduct(@PathVariable int id, @RequestBody Product product) {
		// TODO Auto-generated method stub
       		return service.addProduct(id,product);
	}

	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable long id) {
        return service.updateProduct(product, id);
	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable Long id) {
		// TODO Auto-generated method stub
		service.deleteProduct(id);
		return "Product deleted successfully";
	}

}
