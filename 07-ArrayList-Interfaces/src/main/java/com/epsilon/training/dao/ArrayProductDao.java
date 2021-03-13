package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

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
		
		if (index < MAX_PRODUCTS) {
			this.products[index++] = product;
		}
		else {
			throw new RuntimeException("Exceeded the maximum allowed products");
		}
	}

	@Override
	public Product getProduct(int id) {
		log.debug("Retrieving a product");
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		log.debug("Updating a product");
	}

	@Override
	public void deleteProduct(int id) {
		log.debug("Deleting a product");
	}

	@Override
	public List<Product> getAll() {
		log.debug("Getting all product");
		return null;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) {
		log.debug("Getting product by price range");
		return null;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		log.debug("Getting product by brand");
		return null;
	}

	@Override
	public List<Product> getByCategory(String category) {
		log.debug("Getting product by category");
		return null;
	}

}
