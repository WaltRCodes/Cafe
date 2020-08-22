package com.example.dao;

import java.util.List;

import com.example.models.Product;


public interface ProductsDAO {
	
	public Product insertProduct(String name, double price);
	
	//update
	public void updateProduct(Product p);
	
	//Read
	public List<Product> selectAllProducts();
	
	public Product selectProductByName(String name);
	
	public Product selectProductById(int id);
	
	//Delete
	public void deleteProduct(Product p);

}
