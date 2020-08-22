package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Product;
import com.example.util.ConnectionFactory;

public class ProductsDAOImpl implements ProductsDAO{

	@Override
	public Product insertProduct(String name, double price) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO products (product_name, product_price) values "
				+ "(?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.selectProductByName(name);
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getId());
			
			ps.execute();
			
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM products";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product selectProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> products  = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			String sql = "SELECT * FROM products WHERE product_name = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			//System.out.println(rs);
			
			while(rs.next()) {
				products.add(new Product(
				rs.getInt(1),
				rs.getString(2),
				rs.getDouble(3)));
				//System.out.println(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products.get(0);
	}

	@Override
	public Product selectProductById(int id) {
		// TODO Auto-generated method stub
		List<Product> products  = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			String sql = "SELECT * FROM products WHERE product_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			//System.out.println(rs);
			
			while(rs.next()) {
				products.add(new Product(
				rs.getInt(1),
				rs.getString(2),
				rs.getDouble(3)));
				//System.out.println(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products.get(0);
	}

	@Override
	public void deleteProduct(Product p) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM products WHERE product_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
