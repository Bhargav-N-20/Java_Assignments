package com.epsilon.training.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epsilon.training.entity.Product;

public class SerializedProductDao implements ProductDao {
	
	// for performance, keep all products in a map, and 
	// serialize/deserialize when required.
	private static final String FILENAME = "products.data";
	
	private Map<Integer, Product> products;
	
	public SerializedProductDao() {
		this.products = new HashMap<>();
		
		try (FileInputStream file = new FileInputStream(FILENAME);
				ObjectInputStream in = new ObjectInputStream(file);) {

			while (true) {
				try {
					Object obj = in.readObject();
					if (obj instanceof Product) {
						Product p = (Product) obj;
						products.put(p.getId(), p);
					}
				} catch (Exception e) {
					break;
				} 
			}

		} catch (IOException e1) {
			
			e1.printStackTrace();
		}

	}
	@Override
	public void addProduct(Product product) throws DaoException {
		products.put(product.getId(), product);
		// write the entire content of the map to the file.
		writeToFile();
	}

	private void writeToFile() throws DaoException {
		try(FileOutputStream file = new FileOutputStream(FILENAME);
				ObjectOutputStream out = new ObjectOutputStream(file);){
				
			for(Entry<Integer, Product> en:products.entrySet()) {
				out.writeObject(en.getValue());
			}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}
	@Override
	public Product getProduct(int id) throws DaoException {
		Product p = products.get(id);
		if (p == null) {
			throw new DaoException("No product found with id " + id);
		}
		return p;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		products.replace(product.getId(), product);
		writeToFile();
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		products.remove(id);
		writeToFile();
	}

	@Override
	public List<Product> getAll() throws DaoException {
		List<Product> list = new ArrayList<>();
		list.addAll(this.products.values());
		return list;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		List<Product> list = new ArrayList<>();
		for( Entry<Integer, Product> en:products.entrySet()) {
			if(en.getValue().getUnitPrice()>=min && en.getValue().getUnitPrice()<=max) {
				list.add(en.getValue());
			}
		}
		return list;
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		List<Product> list = new ArrayList<>();
		for( Entry<Integer, Product> en:products.entrySet()) {
			if(en.getValue().getBrand().equalsIgnoreCase(brand)) {
				list.add(en.getValue());
			}
		}
		return list;
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		List<Product> list = new ArrayList<>();
		for( Entry<Integer, Product> en:products.entrySet()) {
			if(en.getValue().getCategory().equalsIgnoreCase(category)) {
				list.add(en.getValue());
			}
		}
		return list;
	}

}
