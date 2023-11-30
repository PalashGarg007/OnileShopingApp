package com.genpact.onlineshopingapp.repository;

import java.util.List;
import java.util.Map;

import com.genpact.onlineshopingapp.entity.*;

public interface UserRepository {
	/* verify user by the given user-name and password. if successful 
	 * load user's cart. */
	public int verifyUser(String username, String password);
	
	/* create a new user object and add his details in the database. */
	public int createUser(String fullName, String dob, String contact, 
			String email, String address, String username, String password);
	
	/* modify user details with switch cases, and update database */
	public int modifyUser(String feature, String modify);
	
	/* modify password by re-checking the current password. */
	public int modifyPassword(String currentPassword, String newPassword);
	
	/* display the distinct name of the products with their rating. */
	public Map<Product, Integer> searchProductByName(String productName);
	
	/* Add selected product to the list of cart and add it to the database. */
	public int addToCart(String productName, int quantity);
	
	/* Remove selected product from the list of cart and remove it from 
	 * the database. */
	public int removeFromCart(String productName, int quantity);
	
	/* Select payment method from the list of payment methods and apply
	 *  discount, return amount to be payed. */
	public int selectPaymentMethod(String paymentMethod, Cart cart);
	
	
	
}
