package com.genpact.onlineshopingapp.service;

public class VendorServiceImpl implements VendorService{
    VendorRepositoryImpl vendorRepositoryImpl = new VendorRepositoryImpl();
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
}
