package com.company.mongo.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order")
public class Order {

	@Id
	private String id;
	
	private final Double totalAmount;
	
	@DBRef
	private final Customer customer;
	
	

	public Order(Double totalAmount, Customer customer) {
		super();
		this.totalAmount = totalAmount;
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}
	
	public Customer getCustomer() {
		return customer;
	}

		
	
}
