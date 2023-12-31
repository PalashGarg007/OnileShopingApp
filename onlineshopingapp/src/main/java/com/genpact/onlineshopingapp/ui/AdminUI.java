package com.genpact.onlineshopingapp.ui;

import java.util.Scanner;

import com.genpact.onlineshopingapp.service.AdminServiceImpl;

public class AdminUI {

	public static void main(String[] args) {
		AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			try{
				System.out.println("-------------------------------------------");
				System.out.println("Choose an operation:\n"+
						"\t1. See the details of all users.\n"+
						"\t2. See the details of all vendors.\n"+
						"\t3. See the history of a user.\n"+
						"\t4. See the product repository of a vendor.\n"+
						"\t5. Add a new Payment method.\n"+
						"\t6. Change the discount on the existing payment method.\n"+
						"\t0. Exit.\n");
				
				String operation = scanner.next();
				System.out.println("___________________________________________");
				switch(operation){
					case "1":
						adminServiceImpl.getAllCustomer();
						continue;
					case "2":
						adminServiceImpl.getAllShopkeeper();
						continue;
					case "3":
						adminServiceImpl.getHistoryOfCustomer();
						continue;
					case "4":
						adminServiceImpl.getHistoryOfShopkeeper();
						continue;
					case "5":
						adminServiceImpl.addPaymentMethod();
						continue;
					case "6":
						adminServiceImpl.changeDiscountOfPayment();
						continue;
					default:
						System.out.println("Wrong Operation");
					case "0":
						System.out.println("Thank you for your hard work :)");
				}
				break;
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		

	}

}
