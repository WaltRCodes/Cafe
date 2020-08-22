package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Customer;
import com.example.models.Product;
import com.example.util.ConnectionFactory;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer insertCustomer(String name) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO cafe_customer (cafe_customer_name) values "
				+ "(?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.selectCustomerByName(name);
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM cafe_customer";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				customers.add(new Customer(rs.getInt(1),rs.getString(2)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public Customer selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		List<Customer> customers  = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection()){ 
			String sql = "SELECT * FROM cafe_customer WHERE cafe_customer_name = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				customers.add(new Customer(
				rs.getInt(1),
				rs.getString(2)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers.get(0);
	}

	@Override
	public void deleteCustomer(Customer p) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM cafe_customer WHERE cafe_customer_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getCustomer_id());
			
			ps.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
