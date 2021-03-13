package com.epsilon.training.dao;

import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ArrayListProductDao implements ProductDao{

	List<Product> products=new ArrayList<>();
	int index = 0;
	static final int MAX_PRODUCTS = 100;
	
	public ArrayListProductDao() {
		log.debug("ArrayProductDao instantiated");
	}
	
	@Override
	public void addProduct(Product product) {
		log.debug("ArrayListProductDao.addProduct() called with {}", product);

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
			products.add(product);
			index++;
		} else {
			throw new RuntimeException("Exceeded the maximum allowed products");
		}

		
	}

	@Override
	public Product getProduct(int id) {

for (Product product : products) {
	if(product.getId()==id) {
		return product;
	}
}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		int pos = -1;
		pos=products.indexOf(product);
		String c = "yes";
		while (c.equalsIgnoreCase("yes")) {
			try {
			int num = KeyboardUtil.getInt("Enter a number between 1 and 9 to update the product details as shown:");
			
			switch (num) {
			case 1:
				int id = KeyboardUtil.getInt("Enter the new product ID: ");
				product.setId(id);
				break;
			case 2:
				String name = KeyboardUtil.getString("Enter the new product name: ");
				product.setName(name);
				break;
			case 3:
				String description = KeyboardUtil.getString("Enter the new product description: ");
				product.setDescription(description);
				break;
			case 4:
				String brand=KeyboardUtil.getString("Enter the new product Brand: ");
				product.setBrand(brand);
				break;
			case 5:
				String category=KeyboardUtil.getString("Enter the new product Category: "); 
				product.setCategory(category);
				break;
			case 6:
				String quantityPerUnit=KeyboardUtil.getString("Enter the new product Quantity Per Unit: ");
				product.setQuantityPerUnit(quantityPerUnit);
				break;
			case 7:
				double unitPrice=KeyboardUtil.getDouble("Enter the new product Unit Price: ");
				product.setUnitPrice(unitPrice);
				break;
			case 8:
				double discount=KeyboardUtil.getDouble("Enter the new product Discount: ");
				product.setDiscount(discount);
				break;
			case 9:
				String picture=KeyboardUtil.getString("Enter the new product picture: ");
				product.setPicture(picture);
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
		products.remove(pos);
		products.add(pos,product);
		
	}

	@Override
	public void deleteProduct(int id) {
		Product p=null;
		for (Product product : products) {
			if(product.getId()==id) {
				p=product;
				break;
			}
		
		}
		int i=products.indexOf(p);
		products.remove(i);
		
	}

	@Override
	public List<Product> getAll() {
		
		return products;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) {
	
		List<Product> p=new ArrayList<>();
	    for (Product product : products) {
	    	if(product.getUnitPrice()>=min && product.getUnitPrice()<=max) {
	    		p.add(product);
	    	}

		}
		return p;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> p=new ArrayList<>();
	    for (Product product : products) {
	    	if(product.getBrand().equalsIgnoreCase(brand)) {
	    		p.add(product);
	    	}

		}
		return p;
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> p=new ArrayList<>();
	    for (Product product : products) {
	    	if(product.getCategory().equalsIgnoreCase(category)) {
	    		p.add(product);
	    	}

		}
		return p;
	}

}
