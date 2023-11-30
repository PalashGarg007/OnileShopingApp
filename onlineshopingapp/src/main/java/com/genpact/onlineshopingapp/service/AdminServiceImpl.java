package com.genpact.onlineshopingapp.service;

import java.util.List;

import com.genpact.onlineshopingapp.entity.Customer;
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
	
	
}
