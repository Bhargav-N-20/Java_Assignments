package com.epsilon.training.dao;

import java.util.List;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyProductDao implements ProductDao {

	@Override
	public void addProduct(Product product) {
		log.debug("DummyProductDao.addProduct() called");
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
