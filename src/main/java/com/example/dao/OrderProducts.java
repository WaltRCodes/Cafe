package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.models.Customer;


public interface OrderProducts {

	public void insertOrderProduct(int prdt_id, int order_id, int qty);
	
	//update
	public void updateOrderProduct(int id, int order_id, int qty);
	
	//Read
	public List<HashMap> selectAllOrderProducts();
	

	
	public List<HashMap> selectOrderProductByOrder(int id);
	
	//Delete
	public void deleteOrderProduct(int prdt_id, int order_id);
	
}
