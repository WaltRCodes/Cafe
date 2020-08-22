package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.models.Customer;
import com.example.models.Product;
import com.example.util.ConnectionFactory;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public HashMap insertOrder(Customer c) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO orders (customer_id) values "
				+ "(?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getCustomer_id());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.selectAllOrders().get(this.selectAllOrders().size()-1);
	}


	@Override
	public List<HashMap> selectAllOrders() {
		// TODO Auto-generated method stub
		List<HashMap> orders = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM orders";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				orders.add(new HashMap<Integer,Integer>(){{put(rs.getInt(1),rs.getInt(2));}});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public List<HashMap> selectOrderByCustomer(Customer c) {
		// TODO Auto-generated method stub
		List<HashMap> orders  = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			String sql = "SELECT * FROM orders WHERE customer_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, c.getCustomer_id());
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				orders.add(new HashMap<Integer,Integer>(){{put(rs.getInt(1),rs.getInt(2));}});
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public HashMap selectOrderById(int id) {
		// TODO Auto-generated method stub
		List<HashMap> orders  = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			String sql = "SELECT * FROM orders WHERE order_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				orders.add(new HashMap<Integer,Integer>(){{put(rs.getInt(1),rs.getInt(2));}});
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders.get(0);
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM orders WHERE order_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
