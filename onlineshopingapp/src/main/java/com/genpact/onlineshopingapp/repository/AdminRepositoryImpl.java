package com.genpact.onlineshopingapp.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Shopkeeper;

public class AdminRepositoryImpl implements AdminRepository {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	CartRepository cartRepository = (CartRepository)context.getBean("cartRepository");
	CustomerRepository customerRepository = (CustomerRepository)context.getBean("customerRepository");
	FavoriteRepository favoriteRepository = (FavoriteRepository)context.getBean("favoriteRepository");
	ProductRepository productRepository = (ProductRepository)context.getBean("productRepository");
	ReviewRepository reviewRepository = (ReviewRepository)context.getBean("reviewRepository");
	ShopkeeperRepository shopkeeperRepository = (ShopkeeperRepository)context.getBean("shopkeeperRepository");
	OrderRepository orderRepository = (OrderRepository)context.getBean("orderRepository");
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.getAll();
		return customers;
	}

	@Override
	public List<Shopkeeper> getAllShopkeeper() {
		List<Shopkeeper> shopkeepers = shopkeeperRepository.getAll();
		return shopkeepers;
	}
	
	
}
