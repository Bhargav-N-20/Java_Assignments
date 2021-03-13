package com.epsilon.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.DbUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcProductDao implements ProductDao {

public JdbcProductDao() {
		
	}
	
	@Override
	public void addProduct(Product product) throws DaoException {
		String sql = "insert into products values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, product.getCategory());
			stmt.setString(2, product.getName());
			stmt.setString(3, product.getBrand());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getQuantityPerUnit());
			stmt.setDouble(6, product.getUnitPrice());
			stmt.setString(7, product.getPicture());
			stmt.setInt(8, (int) product.getDiscount());
			
			stmt.execute();
			
			
			log.debug("New row inserted successfully!");
		}catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
		}
	}

	@Override
	public Product getProduct(int id) throws DaoException {
		String sql = "select * from products where id = ?";
		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return createProduct(rs);
				}
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}

	private Product createProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setBrand(rs.getString("brand"));
		p.setCategory(rs.getString("category"));
		p.setDescription(rs.getString("description"));
		p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
		p.setPicture(rs.getString("picture"));
		p.setDiscount(rs.getDouble("discount"));
		p.setUnitPrice(rs.getDouble("unit_price"));
		return p;
	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		// TODO Implement this method using JDBC
		// update products set name=?, brand=?,..... where id=?
		
		String sql = "update products set name=?, brand=?, category=?, description=?, quantity_per_unit=?,"
				+ " picture=?, unit_price=?, discount=? where id=?";
		
		try(Connection conn = DbUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getBrand());
			stmt.setString(3, p.getCategory());
			stmt.setString(4, p.getDescription());
			stmt.setString(5, p.getQuantityPerUnit());
			stmt.setString(6, p.getPicture());
			stmt.setDouble(7, p.getUnitPrice());
			stmt.setInt(8, (int) p.getDiscount());
			stmt.setInt(9, p.getId());
		
			
			stmt.execute();
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		String sql ="delete from products where id=?";
		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			stmt.executeUpdate();
			
				

		}catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public List<Product> getAll() throws DaoException {
		List<Product> products=new ArrayList<>();
		
		String sql = "select * from products";
		try(
				Connection conn=DbUtil.createConnection();
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);){
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
				p.setBrand(rs.getString("brand"));
				p.setDescription(rs.getString("description"));
				p.setCategory(rs.getString("category"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setDiscount(rs.getDouble("discount"));
				p.setPicture(rs.getString("picture"));
				products.add(p);
				
			}
			return products;
		
		} catch (Exception e) {
			log.warn("Error-{}",e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		List<Product> products=new ArrayList<>();
		
		String sql="select *from products where unit_price between ? and ? order by unit_price";
		try(
				Connection conn=DbUtil.createConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			try(ResultSet rs=stmt.executeQuery()){
				
			
				while(rs.next()) {
					Product p=new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setDescription(rs.getString("description"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setDiscount(rs.getDouble("discount"));
					p.setPicture(rs.getString("picture"));
					products.add(p);
			}
				return products;
			}
		} catch (Exception e) {
			log.warn("Error-{}",e.getMessage());
		}
		return null;
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		List<Product> products=new ArrayList<>();
		
		String sql="select *from products where brand=?";
		try(
				Connection conn=DbUtil.createConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			stmt.setString(1, brand);
		
			try(ResultSet rs=stmt.executeQuery()){
				
			
				while(rs.next()) {
					Product p=new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setDescription(rs.getString("description"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setDiscount(rs.getDouble("discount"));
					p.setPicture(rs.getString("picture"));
					products.add(p);
			}
				return products;
			}
		} catch (Exception e) {
			log.warn("Error-{}",e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		List<Product> products=new ArrayList<>();
		
		String sql="select *from products where category=?";
		try(
				Connection conn=DbUtil.createConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			stmt.setString(1, category);
		
			try(ResultSet rs=stmt.executeQuery()){
				
			
				while(rs.next()) {
					Product p=new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setDescription(rs.getString("description"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setDiscount(rs.getDouble("discount"));
					p.setPicture(rs.getString("picture"));
					products.add(p);
			}
				return products;
			}
		} catch (Exception e) {
			log.warn("Error-{}",e.getMessage());
		}
		return null;
	}

}
