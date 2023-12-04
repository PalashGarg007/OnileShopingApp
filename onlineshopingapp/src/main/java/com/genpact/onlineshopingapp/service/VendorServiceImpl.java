package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.repository.VendorRepositoryImpl;

public class VendorServiceImpl implements VendorService{
    static VendorRepositoryImpl vendorRepositoryImpl = new VendorRepositoryImpl();

    @Override
    public void confirmProductList() {
        List<Orders> pendingList = vendorRepositoryImpl.getPendingOrders();

        if(pendingList.size()==0){
            System.out.println("Their are no pending request available.");
            return;
        }
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Their are a total of "+pendingList.size()+" pending orders.");
        System.out.println("-----------------------------------------------");
        System.out.println("Product Name\tQuantity\tAccept(a)");
        System.out.println("-----------------------------------------------");
        for(Orders order:pendingList){
            System.out.printf("%-20s %-5s\t",vendorRepositoryImpl.getProductName(order.getPid()), order.getQuantity());
            String conformation = scanner.nextLine();
            if(conformation.equals("a")){
                order.setConfirmation(true);
                int availability = vendorRepositoryImpl.setConfirmation(order);
                if(availability!=0){
                    System.out.println("Conformed");
                } else{
                    System.out.println("You don't have enough inventory to accept this order.");
                }
            } else{
                System.out.println("Not Conformed");
            }
        }
    }

    @Override
	public void addProduct() {
		
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of the product: ");
        String name=sc.nextLine();
        System.out.println("Enter Category of the product: ");
        String category=sc.nextLine();
        System.out.println("Enter cost of the product: ");
        String cost=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter quantity of product in the Warehouse : ");
        String warehouse=sc.nextInteger();
        sc.nextLine();

        int result=vendorRepositoryImpl.addProduct(name,category,cost,warehouse);

        if(result==0){
            System.out.println("Sorry, product not added");
        }else{
            System.out.println("product got added");
        }
	}

    @Override
	public void removeProduct() {
		
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of the product: ");
        String name=sc.nextLine();
        System.out.println("Enter Category of the product: ");
        String category=sc.nextLine();
        System.out.println("Enter quantity of products you want to remove in the Warehouse : ");
        String warehouse=sc.nextInteger();
        sc.nextLine();

        int result=vendorRepositoryImpl.removeProduct(name,category,warehouse);

        if(result==0){
            System.out.println("Sorry, product not removed\n"+
                "\t1. quantity overflow");
        }else{
            System.out.println("product got removed.");
        }
	}

    @Override
	public void restock() {
		
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of the product: ");
        String name=sc.nextLine();
        System.out.println("Enter Category of the product: ");
        String category=sc.nextLine();
        System.out.println("Enter quantity of products you want to add in the Warehouse : ");
        String warehouse=sc.nextInteger();
        sc.nextLine();

        int result=vendorRepositoryImpl.restock(name,category,warehouse);

        if(result==0){
            System.out.println("Sorry, products not added\n"+
                "\t1. product does not exist");
        }else{
            System.out.println("products got added.");
        }
	}
}
