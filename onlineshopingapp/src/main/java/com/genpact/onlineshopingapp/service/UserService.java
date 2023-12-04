package com.genpact.onlineshopingapp.service;

public interface UserService {
	
	public int userLogin();
	
	/*User will be able to buy produduct from cart.*/
	void buyProductsFromCart();

	//track products
	void trackProducts();
	
}
