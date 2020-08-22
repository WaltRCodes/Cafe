package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.util.ConnectionFactory;

public class OrderProductsImpl implements OrderProducts {

	@Override
	public void insertOrderProduct(int prdt_id, int order_id, int qty) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO order_products (product_id,order_id,qty) values "
				+ "(?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, prdt_id);
			ps.setInt(2, order_id);
			ps.setInt(3, qty);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateOrderProduct(int prdt_id, int order_id, int qty) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "UPDATE order_products SET qty = ? WHERE product_id = ? and order_id = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setInt(2, prdt_id);
			ps.setInt(3, order_id);
			
			ps.execute();
			
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<HashMap> selectAllOrderProducts() {
		// TODO Auto-generated method stub
		List<HashMap> orderitems = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM order_products";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				orderitems.add(new HashMap<Integer,Integer>(){{put(rs.getInt(2),rs.getInt(4));}});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderitems;
	}

	
	@Override
	public List<HashMap> selectOrderProductByOrder(int id){
		
		List<HashMap> orderitems  = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			String sql = "SELECT * FROM order_products WHERE order_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				orderitems.add(new HashMap<Integer,Integer>(){{put(rs.getInt(2),rs.getInt(4));}});
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderitems;
	}

	@Override
	public void deleteOrderProduct(int prdt_id, int order_id) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM order_products WHERE product_id = ? and order_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, prdt_id);
			ps.setInt(1, order_id);
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
