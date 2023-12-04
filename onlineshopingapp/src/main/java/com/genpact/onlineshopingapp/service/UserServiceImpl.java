package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	static UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

	@Override
	public int userLogin() {
		@SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        String username = scanner.next();
        System.out.print("Please enter your password: ");
        String password = scanner.next();
        int valid = userRepositoryImpl.userLogin(username, password);
        if(valid==1)
            System.out.println("Login Successful");
        else
            System.out.println("Login Failed");
		return valid;
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

	@Override
	public int createUser() {
		Scanner scanner = new Scanner("System.in");
		System.out.print("Please enter your full name: ");
		String fullName = scanner.next();
		System.out.print("Please enter your date of birth: ");
		String dob = scanner.next();
		System.out.print("Please enter your contact number: ");
		String contact = scanner.next();
		System.out.print("Please enter your email: ");	
		String email = scanner.next();
		System.out.print("Please enter your address: ");
		String address = scanner.next();
		System.out.print("Please enter your username: ");
		String username = scanner.next();
		System.out.print("Please enter your password: ");
		String password = scanner.next();
		int valid = userRepositoryImpl.createUser(fullName, dob, contact, email, address, username, password);
		if(valid == 1) {
			System.out.println("User created successfully");
		}
		else{
			System.out.println("User creation failed.\n"+
			"Please check:\n"+
			"\t1. This contact has already been used"+
			"\t2. This email has already been used"+
			"\t3. This username has already been used");

		}
		return valid;
	}

}
