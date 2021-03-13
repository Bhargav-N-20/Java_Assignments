package com.epsilon.training.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2700956839592047638L;
	private int id;
	private String name;
	private String description;
	private String brand;
	private String category;
	private String quantityPerUnit;
	private double unitPrice;
	private double discount;
	private String picture;
}
