package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.models.Customer;


public interface OrderDAO {

	
	public HashMap insertOrder(Customer c);
	
	
	
	//Read
	public List<HashMap> selectAllOrders();
	
	public List<HashMap> selectOrderByCustomer(Customer c);
	
	public HashMap selectOrderById(int id);
	
	//Delete
	public void deleteOrder(int id);
}
