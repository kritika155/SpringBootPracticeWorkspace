package com.product.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "product") 
public class Product { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 

	@Column(nullable = false) 
	private String name; 

	@Column(nullable = false) 
	private double price; 

	@Column(nullable = false) 
	private int quantity;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 

	// Constructors, getters and setters, and other methods... 
	
}
