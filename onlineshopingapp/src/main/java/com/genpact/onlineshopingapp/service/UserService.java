package com.genpact.onlineshopingapp.service;


public interface UserService {
	
	/*User will be able to login */
	public int userLogin();

	/*User will be able to create new account */
	public int createUser();
	
	/*User will be able to buy produduct from cart.*/
	void buyProductsFromCart();

	/*User will be able to add review to product*/
	public void addReview();
}
