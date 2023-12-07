package com.genpact.onlineshopingapp.ui;

import java.util.Scanner;
import com.genpact.onlineshopingapp.service.UserServiceImpl;

public class UserUI {

	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose an option:\n"+
			"\t1. Log in.\n"+
			"\t2. Create an account.\n");
		int first = scanner.nextInt();

		int result = 0;
		if(first==1){
			result = userServiceImpl.userLogin();
		} else{
			result = userServiceImpl.createUser(); //take user details and create a customer object.
		}

		while(result>0){
			System.out.println("-----------------------------------");
			System.out.println("Please choose an option:\n"+
				"\t 1. Account."+ //1.seeDetails 2.cahngeDetails 3.changePassword 0.goBack
				"\t 2. Shopping."+ //1.seeAll(10atATime) 2.searchByName,category 3.addToCart 0.goBack
				"\t 3. Cart."+//default.seeAll(10AtATime) 1.remove 2.buy 0.goBack
				"\t 4. Favorite."+//default.seeAll(10AtATime) 1.remove 0.goBack
				"\t 0. Exit.");
			String option = scanner.nextLine();

			switch(option){
				case "1":
					userServiceImpl.account();
					continue;
				case "2":
					userServiceImpl.shoping();
					continue;
				case "3":
					userServiceImpl.cart();
					continue;
				case "4":
					userServiceImpl.favorite();
					continue;
				default:
					System.out.println("Please input an correct option...");
					continue;
				case "0":
					System.out.println("Thank you shopping with us :)");
					break;
			}
		}
	}
	
}
