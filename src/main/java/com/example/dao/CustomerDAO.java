package com.example.dao;

import java.util.List;

import com.example.models.Customer;

public interface CustomerDAO {

	public Customer insertCustomer(String name);
	
	
	public List<Customer> selectAllCustomers();
	
	public Customer selectCustomerByName(String name);
	

	public void deleteCustomer(Customer p);
}
