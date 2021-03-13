package com.epsilon.training.programs;

import java.util.InputMismatchException;
import java.util.List;

import com.epsilon.training.dao.DaoFactory;
import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductManagerApplication {

	ProductDao dao;

	void start() {
		// tight coupling; must be avoided - Use a factory method (virtual constructor)
		// dao = new DummyProductDao();
		dao = DaoFactory.getProductDao();

		while (true) {
			menu();
			try {
				int choice = KeyboardUtil.getInt("Enter your choice: ");
				if (choice == 0) {
					System.out.println("Thank you and have a nice day.");
					break;
				}

				switch (choice) {
				case 1:
					acceptAndAddProductDetails();
					
					break;
				case 2:
					getProductDetails();
					break;
				case 3:
					updateProductDetails();
					break;
				case 4:
					deleteProductDetails();
					break;
				case 5:
					listAllProducts();
					break;
				case 6:
					listByPriceRange();
					break;
				case 7:
					listByBrand();
					break;
				case 8:
					listByCategory();
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	private void listByCategory() {
		String category=KeyboardUtil.getString("Enter the Category name: ");
		List<Product> products=dao.getByCategory(category);
		log.debug("{}",products.size());
		  for (Product product : products) {
				displayProductDetails(product);
			}
		
	}

	private void listByBrand() {
		String brand=KeyboardUtil.getString("Enter the Brand name: ");
		List<Product> products=dao.getByBrand(brand);
		  for (Product product : products) {
				displayProductDetails(product);
			}
	}

	private void listByPriceRange() {
		double min=KeyboardUtil.getDouble("Enter the minimum price:");
		double max=KeyboardUtil.getDouble("Enter the maximum price:");
		List<Product> products=dao.getByPriceRange(min, max);
	    for (Product product : products) {
			displayProductDetails(product);
		}
	}

	private void listAllProducts() {
		
    List<Product> products=dao.getAll();
    for (Product product : products) {
		displayProductDetails(product);
	}
		
	}

	private void deleteProductDetails() {
		try {
			System.out.println("Enter the product id to delete the product");
			int id = KeyboardUtil.getInt("Enter id: ");
			Product p=dao.getProduct(id);
			if(p!=null) {
			dao.deleteProduct(id);
			System.out.println("Product deleted succesfully!");
			}
			else {
				System.out.println("Product not found");
			}
		}catch(Exception e) {
			log.warn("Invalid id");
		}
	
		
	}

	private void updateProductDetails() {
		System.out.println("Product details Updation ");
		try {
			System.out.println("Enter the product id to update the details:");
			int id = KeyboardUtil.getInt("Enter id: ");
			Product p=dao.getProduct(id);
			if(p!=null) {
			System.out.println("		*****Present details of Product*****");
			displayProductDetails(p);
			dao.updateProduct(p);
			System.out.println("Product updated succesfully!");
			}
			else {
				System.out.println("Product not found");
			}
		}catch(Exception e) {
			log.warn("Invalid id");
		}
		
	}

	private void getProductDetails() {
		
		try {
			System.out.println("Enter the product id to retrieve the details:");
			int id = KeyboardUtil.getInt("Enter id: ");
			Product p=dao.getProduct(id);
			if(p!=null) {
				System.out.println("Getting product details......");
			displayProductDetails(p);
			}
			else {
				System.out.println("Product not found");
			}
		}catch(Exception e) {
			log.warn("Invalid id");
		}

		
	}

	private void displayProductDetails(Product p) {
		System.out.println("		------ Product Details -------");
		System.out.println("			1.Product Id: "+p.getId());
		System.out.println("			2.Product Name: "+p.getName());
		System.out.println("			3.Product Description: "+p.getDescription());
		System.out.println("			4.Product Brand: "+p.getBrand());
		System.out.println("			5.Product Category: "+p.getCategory());
		System.out.println("			6.Quantity Per Unit: "+p.getQuantityPerUnit());
		System.out.println("			7.Unit Price: "+p.getUnitPrice());
		System.out.println("			8.Discount: "+p.getDiscount());
		System.out.println("			9.Picture: "+p.getPicture());

		
	}

	void acceptAndAddProductDetails() {

		// create a product object
		// use the addProduct function in dao object

		try {
			// create variables for all product fields
			// accept value for each variable from the user
			int id = KeyboardUtil.getInt("Enter id: ");
			String name = KeyboardUtil.getString("Enter product name: ");
			String description = KeyboardUtil.getString("Enter product description: ");
			String brand=KeyboardUtil.getString("Enter product Brand: ");
			String category=KeyboardUtil.getString("Enter product Category: ");
			String quantityPerUnit=KeyboardUtil.getString("Enter product Quantity Per Unit: ");
			double unitPrice=KeyboardUtil.getDouble("Enter product Unit Price: ");
			double discount=KeyboardUtil.getDouble("Enter product Discount: ");
			String picture=KeyboardUtil.getString("Enter product picture: ");

			Product p = new Product();
			p.setId(id);
			p.setName(name);
			p.setDescription(description);
			p.setBrand(brand);
			p.setCategory(category);
			p.setQuantityPerUnit(quantityPerUnit);
			p.setUnitPrice(unitPrice);
			p.setDiscount(discount);
			p.setPicture(picture);
			

			// TODO do the same for rest of the fields

			dao.addProduct(p);
			System.out.println("New product details added  successfully!");
			
		} catch (Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}
	}

	void menu() {
		System.out.println("*** Main Menu ***");
		System.out.println("0. Exit");
		System.out.println("1. Add a new product");
		System.out.println("2. Retrieve a product by id");
		System.out.println("3. Modify details of a product");
		System.out.println("4. Remove product details");
		System.out.println("5. List all products");
		System.out.println("6. List products by price range");
		System.out.println("7. List products by brand");
		System.out.println("8. List products by category");
	}

	public static void main(String[] args) {
		new ProductManagerApplication().start();
	}


}
