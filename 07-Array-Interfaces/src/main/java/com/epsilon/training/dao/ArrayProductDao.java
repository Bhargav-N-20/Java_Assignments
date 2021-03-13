package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayProductDao implements ProductDao {

	Product[] products;
	int index = 0;
	static final int MAX_PRODUCTS = 100;

	public ArrayProductDao() {
		log.debug("ArrayProductDao instantiated");
		this.products = new Product[MAX_PRODUCTS]; // this is the accepted boundary
	}

	@Override
	public void addProduct(Product product) {
		log.debug("ArrayProductDao.addProduct() called with {}", product);

		// TODO validate the product before proceeding further
		int quantity = 0;
		try {
			quantity = Integer.parseInt(product.getQuantityPerUnit());
		} catch (Exception e) {
			log.debug("quantity should be a number");
		}
		if (quantity <= 0) {
			throw new RuntimeException("The quantity should be a number greater than 0");
		} else if (product.getDiscount() < 0 && product.getDiscount() > 100) {
			throw new RuntimeException("Discount should be in the range 0<=discount<=100");
		} else if (product.getUnitPrice() < 0) {
			throw new RuntimeException("The unit price of the product should be greater than 0");
		}

		if (index < MAX_PRODUCTS - 1) {
			this.products[index++] = product;
		} else {
			throw new RuntimeException("Exceeded the maximum allowed products");
		}
	}

	@Override
	public Product getProduct(int id) {
		
		for (int i = 0; i < index; i++) {
			Product p = products[i];
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		int pos = -1;
		for (int i = 0; i < index; i++) {
			if (product.getId() == products[i].getId()) {
				pos = i; // Store the index of the product initially before updating
			}
		}
		String c = "yes";
		while (c.equalsIgnoreCase("yes")) {
			try {
			int num = KeyboardUtil.getInt("Enter a number between 1 and 9 to update the product details as shown:");
			
			switch (num) {
			case 1:
				int id = KeyboardUtil.getInt("Enter the new product ID: ");
				products[pos].setId(id);
				break;
			case 2:
				String name = KeyboardUtil.getString("Enter the new product name: ");
				products[pos].setName(name);
				break;
			case 3:
				String description = KeyboardUtil.getString("Enter the new product description: ");
				products[pos].setDescription(description);
				break;
			case 4:
				String brand=KeyboardUtil.getString("Enter the new product Brand: ");
				products[pos].setBrand(brand);
				break;
			case 5:
				String category=KeyboardUtil.getString("Enter the new product Category: "); 
				products[pos].setCategory(category);
				break;
			case 6:
				String quantityPerUnit=KeyboardUtil.getString("Enter the new product Quantity Per Unit: ");
				products[pos].setQuantityPerUnit(quantityPerUnit);
				break;
			case 7:
				double unitPrice=KeyboardUtil.getDouble("Enter the new product Unit Price: ");
				products[pos].setUnitPrice(unitPrice);
				break;
			case 8:
				double discount=KeyboardUtil.getDouble("Enter the new product Discount: ");
				products[pos].setDiscount(discount);
				break;
			case 9:
				String picture=KeyboardUtil.getString("Enter the new product picture: ");
				products[pos].setPicture(picture);
				break;
			default:
System.out.println("Please enter only number between 1-9");
				break;
			}
			}
			catch(Exception e) {
				log.warn("Enter only a number");
			}
			
			c=KeyboardUtil.getString("Do you want to continue updating the product (yes/no) ?");
		}
	}

	@Override
	public void deleteProduct(int id) {
		for (int i = 0; i < index; i++) {
			if (products[i].getId()==id) {
				products[i]=null; 
				index--;
			}
		}
	}

}
