package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.entity.Product;
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
		System.out.print("Please select a Payment Method :");
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
	public void trackProducts(){
		List<String[]> productList=userRepositoryImpl.trackProducts();
		if(productList.size()>0){
			System.out.println(productList.size()+" records found")
			System.out.printf("%-10s %-10s %-5s %-5s","Name","Category","Quantity","Days Remaining")
			for(int i=0;i<productList.size();i++){
				System.out.printf("%-10s %-10s %-5s %-5s",productList.get(i)[0],productList.get(i)[1],
				productList.get(i)[2],productList.get(i)[3])
				System.out.println();
			}
		}else
			System.out.println("No record found");
	}

	@Override
	public void showAllProducts(){
		List<Product> productList=userRepositoryImpl.showAllProducts();
		if(productList.size()==0){
			System.out.println("No product found");
		} else{
			for(int i=0;i<productList.size();i++){
				System.out.println(productList.get(i));
			}
		}
	}

	@Override
	public void showProductsByCategory(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the category of product:");
		String category=sc.nextLine();
		List<Product> productList=userRepositoryImpl.showProductsByCategory(category);
		if(productList.size()==0){
			System.out.println("No product found");
		} else{
			for(int i=0;i<productList.size();i++){
				System.out.println(productList.get(i));
			}
		}
	}

	@Override
	public void showProductsByName(String name){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of product:");
		String name=sc.nextLine();
		List<Product> productList=userRepositoryImpl.showProductsByCategory(name);
		if(productList.size()==0){
			System.out.println("No product found");
		} else{
			for(int i=0;i<productList.size();i++){
				System.out.println(productList.get(i));
			}
		}
	}

	@Override
	public int createUser() {
		@SuppressWarnings("resource")
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

	@Override
	public void addReview() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		/*For getting unrated products */
		List<Product> productList = userRepositoryImpl.getAllUnratedProducts();
        for(int i=0; i<productList.size(); i++)
            System.out.printf("%d\t%-15s%-15s", i+1, productList.get(i).getName(), productList.get(i).getCategory());
		System.out.println("---------------------------------------");
		System.out.print("Please select the product to give rating and review: ");
		int productIndex = scanner.nextInt();
		while(productIndex < 0 || productIndex>=productList.size()){
			System.out.print("Please Enter an valid input: ");
            productIndex = scanner.nextInt();
        }
		Double rate=0.0;
		System.out.print("Please enter your rating on a scale of 0 to 5: ");
		rate = scanner.nextDouble();
		while(rate < 0.0 || rate>5.0){
			System.out.print("Please enter a valid rating: ");
			rate = scanner.nextDouble();
		}
		System.out.print("Please enter your review: ");
		String review = scanner.next();
		while (review.equals("")) {
			System.out.print("Please enter your review: ");
			review = scanner.next();
		}
		if(userRepositoryImpl.addReview(productIndex, rate, review)>0)
			System.out.println("Changes added successfully");
		else
			System.out.println("Changes not added");
	}
}
