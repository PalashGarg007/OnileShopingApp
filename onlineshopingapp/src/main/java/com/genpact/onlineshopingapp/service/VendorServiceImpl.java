package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.repository.VendorRepositoryImpl;

public class VendorServiceImpl implements VendorService{
    static VendorRepositoryImpl vendorRepositoryImpl = new VendorRepositoryImpl();

    /*For vendor login  */
    @Override
    public int vendorLogin() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        String username = scanner.next();
        System.out.print("Please enter your password: ");
        String password = scanner.next();
        int valid = vendorRepositoryImpl.vendorLogin(username, password);
        if(valid==1)
            System.out.println("Login Successful");
        else
            System.out.println("Login Failed");
		return valid;
    }

    //vendors should be able to view his/her details
    @Override
	public void viewDetails(){
        Shopkeeper vendor=vendorRepositoryImpl.viewDetails();
		if(vendor==null){
			System.out.println("No Details found");
		}else{
			System.out.println("{\n" +
            "\tName = " + getName() + "\n" +
            "\tContact = " + getContact() + "\n" +
            "\tEmail = " + getEmail() + "\n" +
            "}")
		}
    }

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
                System.out.println((availability!=0) ? "Confirmed" : 
                    "You don't have enough inventory to accept this order.");
            } else
                System.out.println("Not Conformed");
        }
    }

    /*add and remove products */
    @Override
	public void addProduct() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of the product: ");
        String name=sc.nextLine();
        System.out.println("Enter Category of the product: ");
        String category=sc.nextLine();
        System.out.println("Enter cost of the product: ");
        Double cost=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter quantity of product in the Warehouse : ");
        Integer warehouse=sc.nextInt();
        sc.nextLine();

        int result=vendorRepositoryImpl.addProduct(name,category,cost,warehouse);

        System.out.println((result==0) ? "Sorry, product not added" : 
            "product got added");
	}

    @Override
	public void removeProduct() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the product: ");
        String name=sc.nextLine();
        System.out.print("Enter Category of the product: ");
        String category=sc.nextLine();
        System.out.print("Enter quantity of products you want to remove in the Warehouse : ");
        Integer warehouse=sc.nextInt();
        sc.nextLine();

        int result=vendorRepositoryImpl.removeProduct(name,category,warehouse);

        System.out.println((result==0) ? "Sorry, product not removed\n"+
            "\t1. quantity overflow" : "product got removed.");
	}

    /*restock the amount of product. */
    @Override
	public void restock() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        System.out.print("Enter name of the product: ");
        String name=sc.nextLine();
        System.out.print("Enter Category of the product: ");
        String category=sc.nextLine();
        System.out.print("Enter quantity of products you want to add in the Warehouse: ");
        Integer warehouse=sc.nextInt();
        sc.nextLine();

        int result=vendorRepositoryImpl.restock(name,category,warehouse);
        System.out.println((result==0) ? "Sorry, products not added\n"+
            "\t1. product does not exist" : "products got added.");
	}

    /*For vendor creation. */
    @Override
    public int createVendor() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner("System.in");
        System.out.print("Please enter your full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Please enter your contact: ");
        String contact = scanner.nextLine();
        System.out.print("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Please enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();
        int valid = vendorRepositoryImpl.createVendor(fullName, contact, email, userName, password);
        System.out.println((valid==1) ? "Vendor created successfully" :
            "Vendor creation failed.\n"+
			"Please check:\n"+
			"\t1. This contact has already been used"+
			"\t2. This email has already been used"+
			"\t3. This username has already been used");
        return valid;
    }

    @Override
    public void checkAndUpdateVendor(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Old Password:");
		String password=sc.nextLine();
		int finals=0;
		int res=vendorRepositoryImpl.checkVendorPassword(password);
		if(res==1){
			System.out.println("Enter New Password");
			String pass=sc.nextLine();
			finals=vendorRepositoryImpl.updateVendorPassword(pass);
			if(finals==0){
				System.out.println("No Password Change");
			}
			else{
				System.out.println("Password Changed Successfully");
			}
		}


    @Override
    public void inventory() {
        //1.addNewProduct 2.add 3.remove 4.addByFile(Palash-TODo) 0.goBack
        Scanner scanner=new Scanner(System.in);
		try {
			do {
				System.out.println("1. Add new product: "
						+ "\n2. To refill the inventory: "
						+ "\n3. Remove products from inventory: "
                        + "\n4. Add products from file: "
						+ "\n0. Back");
				String operation=scanner.nextLine();
				
				switch(operation) {
					case "1":
                        addProduct();
                        continue;
					case "2":
						restock();
						continue;
					case "3":
						removeProduct();
						continue;
                    case "4":
                    //    addByFile();
                    //    continue;
					default:
						System.out.println("Please input an correct option...");
						continue;
					case "0":
						System.exit(0);
				}
				break;
			}while(true);
		} catch (Exception e) {
				System.out.println(e);
		}
        

    }

    @Override
    public void acceptOrders() {
        //default.seeAll(10atATime) 0.goBack
    }
    
}