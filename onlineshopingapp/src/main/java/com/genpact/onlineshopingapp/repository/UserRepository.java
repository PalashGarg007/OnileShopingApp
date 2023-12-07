package com.genpact.onlineshopingapp.repository;

import java.util.List;

import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.entity.Product;

public interface UserRepository {
	/* verify user by the given user-name and password. if successful 
	 * load user's cart. */
	public int userLogin(String username, String password);
	
	/* checking inventory of cart automatically. */
	public String init(Customer customer);

	/* create a new user and add his details in the database. */
	public int createUser(String fullName, String dob, String contact, 
			String email, String address, String username, String password);
	
	/* modify user details with switch cases, and update database */
	public int modifyUser(String feature, String modify);
	
	/* modify password by re-checking the current password. */
	public int modifyPassword(String currentPassword, String newPassword);
	
	/* Add selected product to the list of cart and add it to the database. */
	public int addToCart(Product product, int quantity);
	
	/* Remove selected product from the list of cart and remove it from 
	 * the database. */
	public int removeFromCart(Product product, int quantity);
	
	/*Display all the available payment method. */
	public List<Payment> getAllPayment();

	/*Should be able to place order from the cart on a selected payment method and 
	return total amount. */
	public Double placeOrderByCart(Payment payment);

	/* Get user password as input */
	
	public int checkPassword(String password );
	
	/*Change user password */
	public int updateUserPassword(String password);
	 
	/*To get list of all unrated products */
	public List<Product> getAllUnratedProducts();

	/*To add reviews */
	public int addReview(Integer n, Double rating, String review);
	

	//should be able to track order
	public String[][] trackProducts();

	//show all products
	public List<Product> showAllProducts();

	//show products by category
	public List<Product> showProductsByCategory(String category);

	//show products by Name
	public List<Product> showProductsByName(String name);
    
	//Check user password
	public int checkUserPassword(String password);
	
	//Update user password
	public int updateUserPassword(String password);
}
