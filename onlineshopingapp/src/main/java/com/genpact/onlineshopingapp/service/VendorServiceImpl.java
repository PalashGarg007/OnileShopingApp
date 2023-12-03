package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.repository.VendorRepositoryImpl;

public class VendorServiceImpl implements VendorService{
    static VendorRepositoryImpl vendorRepositoryImpl = new VendorRepositoryImpl();

    @Override
    public void conformProductList() {
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
                order.setConformation(true);
                int availability = vendorRepositoryImpl.setConformation(order);
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

}
