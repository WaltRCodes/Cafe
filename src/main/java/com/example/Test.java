package com.example;

import java.util.List;

import com.example.dao.ProductsDAOImpl;
import com.example.dao.CustomerDAOImpl;
import com.example.models.Customer;
import com.example.models.Product;



public class Test {

	public static void main(String [] args) {
//		ProductsDAOImpl pdao = new ProductsDAOImpl();
//		
//		//pDao.insertPlanet(new Planet(0, "Test","Test", false, 100));
//		pdao.insertProduct("Brownie",3.99);
//		Product tea = pdao.selectProductByName("Tea");
//		tea.setPrice(2.99);
//		pdao.updateProduct(tea);
//		System.out.println(pdao.selectAllProducts());
//		System.out.println(pdao.selectProductById(2));
//		
//		pdao.deleteProduct(tea);
//		System.out.println(pdao.selectAllProducts());
		
		CustomerDAOImpl cdao = new CustomerDAOImpl();
		System.out.println(cdao.insertCustomer("Walter"));
		Customer c = cdao.selectCustomerByName("Walter");
		System.out.println(cdao.selectAllCustomers());
		cdao.deleteCustomer(c);
		System.out.println(cdao.selectAllCustomers());
	}
}
