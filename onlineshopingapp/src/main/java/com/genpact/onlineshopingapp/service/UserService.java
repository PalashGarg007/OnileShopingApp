package com.genpact.onlineshopingapp.service;

import com.genpact.onlineshopingapp.entity.Product;

public interface UserService {
	
	/*User will be able to login */
	public int userLogin();

	/*User will be able to create new account */
	public int createUser();
	
	/*User will be able to buy produduct from cart.*/
	void buyProductsFromCart();

	/*User will be able to add review to product*/
	public void addReview();

	//should be able to track order
	void trackProducts();

	//show all projects
	void showAllProducts();

	//show products by category
	void showProductsByCategory();

	//show products by Name
	void showProductsByName();
	
	//add to cart
	void addToCart(Product product);

	//remove from cart
	void removeFromCart(Product product);

	void account();

	void shoping();

	void cart();

	void favorite();
}
