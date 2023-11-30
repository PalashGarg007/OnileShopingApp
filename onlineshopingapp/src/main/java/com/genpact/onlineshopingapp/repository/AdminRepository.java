package com.genpact.onlineshopingapp.repository;

import java.util.List;

import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Order;
import com.genpact.onlineshopingapp.entity.Product;
import com.genpact.onlineshopingapp.entity.Shopkeeper;

public interface AdminRepository {
	
	/* Get all the Customers details and return it. */
	List<Customer> getAllCustomer();
	
	/* Get all the Shopkeeper details and return it. */
	List<Shopkeeper> getAllShopkeeper();
	
	/* Get all the customer order history from Order table. */
	List<Order> getHistoryOfCustomer(String customerId);

	/* Get all the shopkeeper product history from Product table. */
	List<Product> getHystoryOfShopkeeper(String shopkeeperId);

}
