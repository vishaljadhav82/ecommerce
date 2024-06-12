package com.ecommerce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private long customerId;
	private double totalPrice;
	private Date createdDate;
	private Date updatedDate;
	@ManyToOne
	private Product products;
	

	// Getters, setters, and other methods
}
