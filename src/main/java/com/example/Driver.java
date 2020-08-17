package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean engagement = true;
		double total = 0;
		ArrayList<HashMap> orders = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Double> menu = new HashMap<>();
		menu.put("Coffee",2.99);
		menu.put("Tea",1.99);
		menu.put("Brownie",3.99);
		menu.put("Bagel",4.99);
		menu.put("Muffin",4.99);
		//String [] menu = {"Coffee","Tea","Brownie","Bagel","Muffin"};
		while(engagement) {
			System.out.println("Are you an employee? (Y/n)");
			boolean employee = false;
			String input = scanner.nextLine();
			if(input.equals("Y")||input.equals("y")) {
				employee = true;
			}
			if(employee) {
				System.out.println("Here are all the orders so far");
				//System.out.println(orders);
				for(HashMap order: orders) {
					System.out.println(order);
					
					System.out.println("--------------------------------------");
				}
				System.out.println("Do you want to close for the day? (Y/n");
				input = scanner.nextLine();
				if(input.equals("Y")||input.equals("y")) {
					 engagement = false;
				}
			} else {
				HashMap<String, HashMap<String, Double>> order = new HashMap<>(); 
				System.out.println("Please enter your name");
				String name = scanner.nextLine();
				order.put(name,new HashMap<>());
				boolean orderTaking= true;
				while(orderTaking) {
					System.out.println("Please place your order from the following items by typing the item name:");
					for(String i: menu.keySet()) {
						System.out.println(i + " $"+menu.get(i));
					}
					input = scanner.nextLine();
					if(menu.containsKey(input)) {
						System.out.println("How many of this item would you like");
						double qty = Double.parseDouble(scanner.nextLine());
						System.out.println(qty+" of "+input+" is being added to your cart");
						if(order.get(name).containsKey(input)) {
							double newQty = order.get(name).get(input)+qty;
							order.get(name).put(input, newQty);
						} else {
							order.get(name).put(input, qty);
						}
						System.out.println("You're current cart is as follows:");
						//for loop of cart
						for(String i: order.get(name).keySet()) {
							System.out.println("Item: "+i +" Price:" + menu.get(i) + " Qty: "+order.get(name).get(i));
						}
						System.out.println("Would you like to add more?");
						input = scanner.nextLine();
						if(input.equals("Y")||input.equals("y")) {
							continue;
						}
						System.out.println("Would you like to edit your cart?");
						input = scanner.nextLine();
						if(input.equals("Y")||input.equals("y")) {
							boolean editLoop = true;
							while(editLoop){
								System.out.println("Please type the name of the item you wish to edit");
								input = scanner.nextLine();
								if(order.get(name).containsKey(input)) {
									System.out.println("Please enter the new qty of the item");
									qty = Integer.parseInt(scanner.nextLine());
									System.out.println(qty+" of "+menu.get(input)+" is being added to your cart");									
									order.get(name).put(input, qty);									
									System.out.println("You're current cart is as follows:");
									//for loop of cart
									for(String i: order.get(name).keySet()) {
										System.out.println("Item: "+i +" Price:" + menu.get(i) + " Qty: "+order.get(name).get(i));
									}
									System.out.println("Would you to make any more edits? (Y/n)");
									input = scanner.nextLine();
									if(input.equals("Y")||input.equals("y")) {
										continue;
									} else {
										editLoop = false;//break also works here
									}
								} else {
									System.out.println("No item was found with that name");
									//for loop of cart
									for(String i: order.get(name).keySet()) {
										System.out.println("Item: "+i +" Price:" + menu.get(i) + " Qty: "+order.get(name).get(i));
									}
								}
								
							}
							
						}
					} else {
						System.out.println("That is not a valid item name");
						continue;
					
					}
				
				
					System.out.println("Are your sure you are done?");
					input = scanner.nextLine();
					if(input.equals("Y")||input.equals("y")) {
						orders.add(order);
						for(String i: order.get(name).keySet()) {
							total+= menu.get(i) *order.get(name).get(i);
						}
						
						orderTaking=false;
					}
				}
				//calculate order here: show item name quantity and total cost
				System.out.println("Your total is $"+total+". Thank you for your patronage");
				order.get(name).put("total", total);
				total=0;
			}
		}
		
	}

}
