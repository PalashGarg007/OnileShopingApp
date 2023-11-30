package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;
import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Order;
import com.genpact.onlineshopingapp.entity.Product;
import com.genpact.onlineshopingapp.entity.Shopkeeper;
import com.genpact.onlineshopingapp.repository.AdminRepositoryImpl;

public class AdminServiceImpl implements AdminService{

	@Override
	public void getAllCustomer() {
		AdminRepositoryImpl adminRepositoryImpl = new AdminRepositoryImpl();
		List<Customer> customerList= adminRepositoryImpl.getAllCustomer();

		if(customerList.size()==0)
			System.out.println("No data available.");
		else
			System.out.println("Total "+customerList.size()+" recourds found.");
		
		System.out.println("-------------------------------------------");
		for(Customer customer:customerList){
			System.out.println(customer);
		}
	}

	@Override
	public void getAllShopkeeper() {
		AdminRepositoryImpl adminRepositoryImpl = new AdminRepositoryImpl();
		List<Shopkeeper> shopkeeperList= adminRepositoryImpl.getAllShopkeeper();

		if(shopkeeperList.size()==0)
			System.out.println("No data available.");
		else
			System.out.println("Total "+shopkeeperList.size()+" recourds found.");

		
		System.out.println("-------------------------------------------");
		for(Shopkeeper shopkeeper:shopkeeperList){
			System.out.println(shopkeeper);
		}
		
	}

	@Override
	public void getHistoryOfCustomer() {
		AdminRepositoryImpl adminRepositoryImpl = new AdminRepositoryImpl();

		System.out.println("Please give the customer's Id to see his purchase history:\n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String customerId = scanner.nextLine();
		List<Order> orderList = adminRepositoryImpl.getHistoryOfCustomer(customerId);
		
		if(orderList.size()==0)
			System.out.println("No order made by the customer with ID: "+customerId);
		else
			System.out.println("Total "+orderList.size()+ " recourds found.");
		
		System.out.println("-------------------------------------------");
		for(Order order:orderList){
			System.out.println(order);
		}
	}

	@Override
	public void getHistoryOfShopkeeper() {
		AdminRepositoryImpl adminRepositoryImpl = new AdminRepositoryImpl();
		System.out.println("Give the vendor's id to see his warehouse:\n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String shopkeeperId = scanner.nextLine();
		List<Product> productList = adminRepositoryImpl.getHystoryOfShopkeeper(shopkeeperId);
		
		if(productList.size()==0)
			System.out.println("No products added by the shopkeeper with ID: "+shopkeeperId);
		else
			System.out.println("Total "+productList.size()+ " recourds found.");
		
		System.out.println("-------------------------------------------");
		for(Product product:productList){
			System.out.println(product);
		}
	}
	
	
}
