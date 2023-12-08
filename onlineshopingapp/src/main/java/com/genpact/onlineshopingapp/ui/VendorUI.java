package com.genpact.onlineshopingapp.ui;

import java.util.Scanner;

import com.genpact.onlineshopingapp.service.VendorServiceImpl;

public class VendorUI {

	public static void main(String[] args) {
		VendorServiceImpl vendorServiceImpl = new VendorServiceImpl();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose an option:\n"+
			"\t1. Log in.\n"+
			"\t2. Create an account.\n");
		String first = scanner.nextLine();

		int result = 0;
		if(first.equals("1")){
			result = vendorServiceImpl.vendorLogin();
		} else{
			result = vendorServiceImpl.createVendor();
		}

		while (result>0){
			System.out.println("-----------------------------------");
			System.out.println("Please choose an option:\n"+
				"\t 1. Inventory."+ //1.addNewProduct 2.add 3.remove 4.addByFile 0.goBack
				"\t 2. Accept new orders."+ //default.seeAll(10atATime) 0.goBack
				"\t 0. Exit.");
			String option = scanner.nextLine();

			switch(option){
				case "1":
					vendorServiceImpl.inventory();
					continue;
				case "2":
					vendorServiceImpl.acceptOrders();
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
