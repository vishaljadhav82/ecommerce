package com.ecommerce.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@GetMapping("/getproducts")
	@PreAuthorize("hasRole('ADMIN')")
	private String getProducts() {
		// TODO Auto-generated method stub
		return "Success";
	}

}
