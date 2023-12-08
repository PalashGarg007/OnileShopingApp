package com.genpact.onlineshopingapp.service;

import java.util.List;

import com.genpact.onlineshopingapp.entity.Product;

public interface UserService {
	
	/*User will be able to login */
	int userLogin();

	/*User will be able to create new account */
	int createUser();
	
	/*User will be able to buy produduct from cart.*/
	void buyProductsFromCart();

	/*User will be able to add review to product*/
	void addReview();

	//should be able to track order
	void trackProducts();

	//show the details of all the products from start to 
	//stop in product list.
	void showProduct(Integer start, Integer stop, 
		List<Product> productList);

	//show products by category
	void showProductsByCategory(String category);

	//show the last 3 reviews by customers.
	void showLastThreeReview();

	//show products by Name
	void showProductsByName(String name);
	
	// Take input between 1 to n
	int checkInput(int n);

	//add to cart
	void addToCart(Product product);

	//remove from cart
	void removeFromCart(Product product);

	//ckeck old password and then change password.
	void checkAndUpdateUser();

	void removeFromFavorite(Integer productId);

	void addToFavorite(Product product);

	//customers should be able to view his/her details
	void viewDetails();

	void account();

	void shopping();

	void openCart();

	void favorite();
}
