package com.genpact.onlineshopingapp.repository;

import java.util.Map;

import com.genpact.onlineshopingapp.entity.Cart;
import com.genpact.onlineshopingapp.entity.Product;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public int verifyUser(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createUser(String fullName, String dob, String contact, String email, String address, String username,
			String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyUser(String feature, String modify) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyPassword(String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Product, Integer> searchProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addToCart(String productName, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFromCart(String productName, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectPaymentMethod(String paymentMethod, Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

}
