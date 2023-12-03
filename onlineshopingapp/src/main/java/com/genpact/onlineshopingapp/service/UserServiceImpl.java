package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	static UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

	@Override
	public void verifyUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyProductsFromCart() {
		System.out.println("-------------------------------");
		List<Payment> paymentList = userRepositoryImpl.getAllPayment();
		for(Payment payment: paymentList)
			System.out.println(payment);
			@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Plese select a Payment Method :");
		Integer payId = scanner.nextInt();
		if(payId > 0 & payId<=paymentList.size()){
			System.out.println("Please Enter an valid input: ");
			payId = scanner.nextInt();
		}
		Double cost = 0.0d;
		for(Payment payment: paymentList){
			if(payId==payment.getId()){
				cost = userRepositoryImpl.placeOrderByCart(payment);
				break;
			}
		}
		if(cost==0.0d)
			System.out.println("Please add some products to the cart");
		else
			System.out.printf("Order Placed With the total amount ₹%.2d", cost);
	}

}
