package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;
import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.entity.Product;
import com.genpact.onlineshopingapp.entity.Shopkeeper;
import com.genpact.onlineshopingapp.repository.AdminRepositoryImpl;

public class AdminServiceImpl implements AdminService{
	
	static AdminRepositoryImpl adminRepositoryImpl = new AdminRepositoryImpl();

	@Override
	public void getAllCustomer() {
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
		System.out.println("Please give the customer's Id to see his purchase history:\n");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String customerId = scanner.nextLine();
		List<Orders> orderList = adminRepositoryImpl.getHistoryOfCustomer(customerId);
		
		if(orderList.size()==0)
			System.out.println("No order made by the customer with ID: "+customerId);
		else
			System.out.println("Total "+orderList.size()+ " recourds found.");
		
		System.out.println("-------------------------------------------");
		for(Orders order:orderList){
			System.out.println(order);
		}
	}

	@Override
	public void getHistoryOfShopkeeper() {
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

	@Override
	public void addPaymentMethod() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give new Payment name:");
		String paymentMethod = scanner.nextLine();
		System.out.println("Set the discount:");
		Double discount = scanner.nextDouble();
		int result = adminRepositoryImpl.addPaymentMethod(paymentMethod, discount);
		System.out.println("-------------------------------------------");
		
		if(result==0)
			System.out.println(paymentMethod+" can't be added successfully.\n"+
			"\tPlease check the following:\n"+
			"\t\t1. This payment method is already given.\n"+
			"\t\t2. Discount should not be negative and more then 100.");
		else
			System.out.println(paymentMethod+" is added successfully with "+
			discount+ "% discount");
	}

	@Override
	public void changeDiscountOfPayment() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give new Payment name:");
		String paymentMethod = scanner.nextLine();
		System.out.println("Set the discount:");
		Double discount = scanner.nextDouble();
		int result = adminRepositoryImpl.changeDiscountOfPayment(paymentMethod, discount);
		System.out.println("-------------------------------------------");

		if(result==0)
			System.out.println("Discount on "+paymentMethod+" can't be changed successfully.\n"+
			"\tPlease check the following:\n"+
			"\t\t1. This payment method is not available.\n"+
			"\t\t2. Discount should not be negative and more then 100.");
		else
			System.out.println("Discount on "+paymentMethod+" is changed to "+discount+"%");
	}
	
	
}
