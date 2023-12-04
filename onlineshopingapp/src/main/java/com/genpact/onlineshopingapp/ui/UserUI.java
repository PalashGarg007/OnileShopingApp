package com.genpact.onlineshopingapp.ui;

import java.util.Scanner;

import com.genpact.onlineshopingapp.service.UserServiceImpl;

public class UserUI {

	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		/*Should be able to buy products of the cart. 
		 * userServiceImpl.buyProductsFromCart()
		*/

		/* Log in with user name and password. */

		System.out.println("Please choose an option:\n"+
			"\t1. Log in.\n"+
			"\t2. Create an account.\n");
		int first = scanner.nextInt();

		int result = 0;
		if(first==1){
			//result = userServiceImpl. //take username and password. and create an object.
		} else{
			//result = userServiceImpl. //take user details and create a customer object.
		}

		while(result>0){
			System.out.println("-----------------------------------");
			System.out.println("Please choose an option:\n"+
				"\t 1. "+
				"\t 2. "+
				"\t 3. "+
				"\t 4. ");
			String option = scanner.nextLine();

			switch(option){
				case "1":
					continue;
				case "2":
					continue;
				case "3":
					continue;
				case "4":
					continue;
				default:
					System.out.println("Please input an correct option...");
					continue;
				case "0":
					System.out.println("Thank you shoping with us :)");
					break;
			}
		}
	}

}
