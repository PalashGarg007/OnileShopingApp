package com.genpact.onlineshopingapp.repository;

import java.util.List;
import java.util.Map;

import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.entity.Product;

 public interface UserRepository {
	/* verify user by the given user-name and password. if successful 
	 * load user's cart. */
	int userLogin(String username, String password);
	
	/* checking inventory of cart automatically. */
	void init();

	/* create a new user and add his details in the database. */
	int createUser(String fullName, String dob, String contact, 
			String email, String address, String username, String password);
	
	/* modify user details with switch cases, and update database */
	int modifyUser(String feature, String modify);
	
	/* modify password by re-checking the current password. */
	int modifyPassword(String currentPassword, String newPassword);
	
	/* Add selected product to the list of cart and add it to the database. */
	int addToCart(Product product, int quantity);
	
	/* Remove selected product from the list of cart and remove it from 
	 * the database. */
	int removeFromCart(Product product, int quantity);
	
	/*Display all the available payment method. */
	List<Payment> getAllPayment();

	/*Should be able to place order from the cart on a selected payment method and 
	return total amount. */
	Double placeOrderByCart(Payment payment);

	/* Get user password as input */
	
	int checkPassword(String password );
	
	/*Change user password */
	int updateUserPassword(String password);
	 
	/*To get list of all unrated products */
	List<Product> getAllUnratedProducts();

	/*To add reviews */
	int addReview(Integer n, Double rating, String review);
	

	//should be able to track order
	String[][] trackProducts();

	//show all products
	List<Product> showAllProducts();

	//show products by category
	List<Product> showProductsByCategory(String category);

	//show products by Name
	List<Product> showProductsByName(String name);
    
	//customers should be able to view his/her details
	Customer viewDetails();

	//Check user password
	int checkUserPassword(String password);

	//list of all the products in the cart
	Map<Product, Integer> viewCart();

	//Remove product from the favorite
	int removeFromFavorite(Integer productId);

	//Add product to favorite
	int addToFavorite(Integer productId);
}
