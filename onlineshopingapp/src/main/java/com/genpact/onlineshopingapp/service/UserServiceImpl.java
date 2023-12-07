package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.entity.Product;
import com.genpact.onlineshopingapp.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	static UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();

/*For user login. */
	@Override
	public int userLogin() {
		@SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        String username = scanner.next();
        System.out.print("Please enter your password: ");
        String password = scanner.next();
		System.out.println("------------------------------------------");
        int valid = userRepositoryImpl.userLogin(username, password);
        System.out.println((valid==1)?"Login Successful" : "Login Failed");
		return valid;
	}

	@Override
	public void buyProductsFromCart() {
		System.out.println("------------------------------------------");
		List<Payment> paymentList = userRepositoryImpl.getAllPayment();
		for(Payment payment: paymentList)
			System.out.println(payment);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please select a Payment Method :");
		Integer payId = scanner.nextInt();
		if(payId > 0 & payId<=paymentList.size()){
			System.out.print("Please Enter an valid input: ");
			payId = scanner.nextInt();
		}
		Double cost = 0.0d;
		for(Payment payment: paymentList){
			if(payId==payment.getId()){
				cost = userRepositoryImpl.placeOrderByCart(payment);
				break;
			}
		}
		System.out.println((cost==0.0d)?"Please add some products to the cart" :
			String.format("Order Placed With the total amount ₹%.2d", cost));
	}

	//should be able to track order
	@Override
	public void trackProducts(){
		String[][] productList=userRepositoryImpl.trackProducts();
		if(productList.length>0){
			System.out.println(productList.length+" records found.");
			System.out.printf("%-20s %-20s %-5s %-5s\n","Name", "Category",
				"Quantity", "Days Remaining");
			System.out.println("-------------------------------------------------");
			for(int i=0; i<productList.length; i++){
				System.out.printf("%-10s %-10s %-5s %-5s\n", productList[i][0],productList[i][1],
					productList[i][2], productList[i][3]);
			}
		}else
			System.out.println("No record found");
	}

	@Override
	public void showProduct(Integer start, Integer stop, List<Product> productList){
		for(int i = start-1; i<stop && i<productList.size(); i++){
			Product product = productList.get(i);
			System.out.printf("%d) %-15s\n%-20s\t%5.2f %3.1f\n", 
				i+1, product.getName(), product.getCategory(), 
				product.getAmount(), product.getRating());
			System.out.println("________________________________");
			showLastThreeReview();
		}
	}

	//show products by category
	@Override
	public void showProductsByCategory(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------")
		System.out.print("Enter the category of product: ");
		String category = sc.nextLine();
		List<Product> productList = userRepositoryImpl.showProductsByCategory(category);
		if(productList.size()==0)
			System.out.println("No product found");
		else
			showProduct(1, productList.size(), productList);
		}
	}

	@Override
	public void showLastThreeReview(){
		//TO Do
	}

	//show products by Name
	@Override
	public void showProductsByName(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("---------------------------------------")
		System.out.print("Enter the name of product: ");
		String name = sc.nextLine();
		List<Product> productList = userRepositoryImpl.showProductsByCategory(name);
		if(productList.size()==0)
			System.out.println("No product found.");
		else
			showProduct(1, productList.size(), productList);
	}

	@Override
	public int createUser() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
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
		
		if(valid == 1)
			System.out.println("User created successfully.");
		else
			System.out.println("User creation failed.\n"+
			"Please check:\n"+
			"\t1. This contact has already been used."+
			"\t2. This email has already been used."+
			"\t3. This username has already been used.");
		return valid;
	}

/*For user to give rating and review to unrated products */
	@Override
	public void addReview() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		List<Product> productList = userRepositoryImpl.getAllUnratedProducts();
        for(int i=0; i<productList.size(); i++)
            System.out.printf("%d\t%-20s%-20s", i+1, productList.get(i).getName(), productList.get(i).getCategory());
		System.out.println("---------------------------------------");
		System.out.print("Please select the product to give rating and review: ");
		int productIndex = scanner.nextInt();
		while(productIndex < 0 || productIndex>=productList.size()){
			System.out.print("Please Enter an valid input: ");
            productIndex = scanner.nextInt();
        }
		System.out.print("Please enter your rating on a scale of 0 to 5: ");
		Double rate = scanner.nextDouble();
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
		System.out.println((userRepositoryImpl.addReview(productIndex, rate, review)>0)?
			"Changes added successfully" : "Changes not added");
	}

	// Take input between 1 to n
	@Override int checkInput(int n){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.print("Product Serial Number: ")
		int result = scanner.nextInt();
		while(result<0 && result>n){
			System.out.print("Please enter a valid Serial Number: ");
			result = scanner.nextInt();
		}
		return result;
	}

	@Override
	public void addToCart(Product product) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Amount to be added: ");
		int quantity = scanner.nextInt();
		while(quantity > 0){
			System.out.print("Please input an valid input: ");
			quantity = scanner.nextInt();
		}
		int result = userRepositoryImpl.addToCart(product, quantity);
		System.out.println((result>0)?"Successfully added to cart.":
			"Something went wrong.");
	}

	@Override
	public void removeFromCart(Product product) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Amount to be removed: ");
		int quantity = scanner.nextInt();
		while(quantity > 0){
			System.out.print("Please input an valid input: ");
			quantity = scanner.nextInt();
		}
		int result = userRepositoryImpl.addToCart(product, quantity);
		System.out.println((result>0)?"Successfully removed from cart.":
			"Enter an corret number of quantity.");
	}

	public void checkAndUpdateUser(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your Old Password: ");
		String password=sc.nextLine();
		int finals=0;
		int res=userRepositoryImpl.checkUserPassword(password);
		if(res==1){
			System.out.println("Enter New Password");
			String pass=sc.nextLine();
			finals=userRepositoryImpl.updateUserPassword(pass);
			if(finals==0){
				System.out.println("No Password Change");
			}
			else{
				System.out.println("Password Successfully");
			}
		}

	}

	//customers should be able to view his/her details
	@Override
	public void viewDetails(){
		Customer customer=userRepositoryImpl.viewDetails();
		if(customer==null){
			System.out.println("No Details found");
		}else{
			System.out.println("{\n" +
            "\tName = " + customer.getName() + "\n" +
            "\tDOB = " + customer.getDob() + "\n" +
            "\tContact = " + customer.getContact() + "\n" +
            "\tEmail = " + customer.getEmail() + "\n" +
            "\tAddress = " + customer.getAddress() + "\n" +
            "}")
		}
	}

	@Override
	public void account() {
		//1.seeDetails 2.changeDetails 3.changePassword 4.giveReview 0.goBack

		Scanner scanner=new Scanner(System.in);
		try {
			do {
				System.out.println("1. See your details" + 
						"\n2. Change your details" + 
						"\n3. Change Password: " +
						"\n4. Give Review" +
						"\n5. Track Product" +
						"\n0. Back");
				String operation=scanner.nextLine();
				
				switch(operation) {
					case "1":
						viewDetails();
						continue;
					case "2":
				//		modifyUser();
						continue;
					case "3":
				//		modifyPassword();
						continue;
					case "4":
						addReview();
						continue;
					case "5":
						trackProducts();
						continue;
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
	public void shopping() {
		//1.seeAll(10atATime) 2.searchByName,category 3.addToCart 0.goBack

		Scanner scanner=new Scanner(System.in);
		try {
			int seeAtATime = 10;
			int n = 1;
			List<Product> productList = userRepositoryImpl.showAllProducts();
			boolean next = true;
			do {
				if(next){
					showProduct(n, n+seeAtATime-1, productList);
					n = (n+seeAtATime-1>=productList.size()) ? productList.size() : n+seeAtATime;
				}
				System.out.println("n. Next"
						+ "\n1. Add to Cart."
						+ "\n2. Search Product by Name: "
						+ "\n3. Search Product by Category: "
						+ "\n0. Back");
				String operation=scanner.nextLine();
				
				switch(operation) {
					case "n":
						if(n>=productList.size()){
							System.out.println("No more products available.");
							next = false;
						}
						continue;
					case "1": //Add to Cart
						int sno = checkInput(n);
						addToCart(productList.get(sno-1));
						continue;
					case "2": //Search Product by Name
						next = false;
						productList = userRepositoryImpl.showProductsByName(name);
						n = productList.size();
						showProductsByName();
						continue;
					case "3": //Search Product by Category
						next = false;
						productList = userRepositoryImpl.showProductsByCategory(name);
						n = productList.size();
						showProductsByName();
						continue;
					default:
						System.out.println("Please input an correct option...");
						continue;
					case "0":
						break;
				}
				break;
			}while(true);
		} catch (Exception e) {
				System.out.println(e);
		}
	}

	@Override
	public void cart() {
		//default.seeAll(10AtATime) 1.remove 2.buy 0.goBack
	}

	@Override
	public void favorite() {
		//default.seeAll(10AtATime) 1.remove 0.goBack
	}


}
