package com.genpact.onlineshopingapp.ui;

import java.util.Scanner;

import com.genpact.onlineshopingapp.exception.OSAException;
import com.genpact.onlineshopingapp.service.AdminServiceImpl;

public class AdminUI {

	public static void main(String[] args) {
		AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			try{
				System.out.println("Choose an operation:\n"+
						"1. See the details of all users.\n"+
						"2. See the details of all Shopkeeper.\n"+
						"9. Exit.\n");
				
				String operation = scanner.next();
				
				switch(operation){
					case "1":
						adminServiceImpl.getAllCustomer();
						continue;
					case "2":
						adminServiceImpl.getAllShopkeeper();
						continue;
					default:
						System.out.println("Wrong Operation");
					case "9":
						System.out.println("Thank you for your hard work :)");
				break;
				}
			} catch(OSAException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
