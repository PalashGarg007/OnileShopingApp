package com.genpact.onlineshopingapp.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.entity.Product;
import com.genpact.onlineshopingapp.exception.OSAException;
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

	/*User will be able to buy produduct from cart.*/
	@Override
	public void buyProductsFromCart() {
		System.out.println("------------------------------------------");
		List<Payment> paymentList = userRepositoryImpl.getAllPayment();
		for(Payment payment: paymentList)
			System.out.println(payment);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please select a Payment Id :");
		Integer payId = scanner.nextInt();
		if(payId >= 0 & payId<=paymentList.size()){
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
			System.out.printf("%-25s %-25s %-10s %-10s\n","Name", "Category",
				"Quantity", "Days Remaining");
			System.out.println("-------------------------------------------------");
			for(int i=0; i<productList.length; i++){
				System.out.printf("%-10s %-10s %-5s %-5s\n", productList[i][0],productList[i][1],
					productList[i][2], productList[i][3]);
			}
		}else
			System.out.println("No record found");
	}

	//show the details of all the products from start to 
	//stop in product list.
	@Override
	public void showProduct(Integer start, Integer stop, 
		List<Product> productList){
		for(int i = start-1; i<stop && i<productList.size(); i++){
			Product product = productList.get(i);
			System.out.printf("%-5d %-20s\n     %-25s %10.2f %5.1f\n", 
				i+1, product.getName(), product.getCategory(), 
				product.getCost(), product.getRating());
			System.out.println("________________________________");
			showLastThreeReview();
		}
	}

	//show products by category
	@Override
	public void showProductsByCategory(String category){
		// @SuppressWarnings("resource")
		// Scanner sc = new Scanner(System.in);
		// System.out.println("---------------------------------------")
		// System.out.print("Enter the category of product: ");
		// String category = sc.nextLine();
		List<Product> productList = userRepositoryImpl.showProductsByCategory(category);
		if(productList.size()==0)
			System.out.println("No product found");
		else
			showProduct(1, productList.size(), productList);
	}

	//show the last 3 reviews by customers.
	@Override
	public void showLastThreeReview(){
		//TO Do
	}

	//show products by Name
	@Override
	public void showProductsByName(String name){
		// @SuppressWarnings("resource")
		// Scanner sc=new Scanner(System.in);
		// System.out.println("---------------------------------------")
		// System.out.print("Enter the name of product: ");
		// String name = sc.nextLine();
		List<Product> productList = userRepositoryImpl.showProductsByCategory(name);
		if(productList.size()==0)
			System.out.println("No product found.");
		else
			showProduct(1, productList.size(), productList);
	}

	/*User will be able to create new account */
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
            System.out.printf("%-5d%-25s%-20s", i+1, 
				productList.get(i).getName(), productList.get(i).getCategory());
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
	@Override 
	public int checkInput(int n){
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter Serial Number: ");
		int result = scanner.nextInt();
		while(result<1 || result>n){
			System.out.print("Please enter a valid Serial Number: ");
			result = scanner.nextInt();
		}
		return result;
	}

	//add to cart, product
	@Override
	public void addToCart(Product product) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Amount to be added: ");
		int quantity = scanner.nextInt();
		while(quantity < 1){
			System.out.print("Please input an valid input: ");
			quantity = scanner.nextInt();
		}
		int result = userRepositoryImpl.addToCart(product, quantity);
		System.out.println((result>0)?"Successfully added to cart.":
			"Something went wrong.");
	}

	//remove from cart, product
	@Override
	public void removeFromCart(Product product) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Amount to be removed: ");
		int quantity = scanner.nextInt();
		while(quantity < 0){
			System.out.print("Please input an valid input: ");
			quantity = scanner.nextInt();
		}
		int result = userRepositoryImpl.removeFromCart(product, quantity);
		System.out.println((result>0)?"Successfully removed from cart.":
			"Enter an corret number of quantity.");
	}

	//ckeck old password and then change password.
	@Override
	public void checkAndUpdateUser(){
		@SuppressWarnings("resource")
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
            "}");
		}
	}

	@Override
	public void removeFromFavorite(Integer productId) {
		int result = userRepositoryImpl.removeFromFavorite(productId);
		String wrongResult = "Product can't be removed can be because of:"+
			"\n\t1) This product does not exist.";
		System.out.println((result==0)? wrongResult : "Product removed successefully :)");
	}

	@Override
	public void addToFavorite(Product product) {
		int result = userRepositoryImpl.addToFavorite(product.getId());
		System.out.println((result>0)?"Successfully added to favorite.":
			"Product alrady exist in the favorite.");
	}

	@Override
	public void account() {
		//1.seeDetails 2.changeDetails 3.changePassword 4.giveReview 0.goBack
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		try {
			do {
				System.out.println("Please select an option:\n" +
					"\t1. See your details\n" + 
					"\t2. Change your details\n" + 
					"\t3. Change Password:\n" +
					"\t4. Give Review\n" +
					"\t5. Track Product\n" +
					"\t0. Back\n");
				String operation=scanner.nextLine();
				
				switch(operation) {
					case "1":
						viewDetails();
						continue;
					case "2":
						System.out.println("Coming soon...");
				//		modifyUser();
						continue;
					case "3":
						System.out.println("Coming soon...");
				//		modifyPassword();
						continue;
					case "4":
						addReview();
						continue;
					case "5":
						trackProducts();
						continue;
					default:
						System.out.println("Please input an correct option:");
						continue;
					case "0":
						break;
				}
				break;
			}while(true);
		} catch (OSAException e) {
				System.out.println(e);
				System.out.println("Something went wrong\n\tplease try again later...");
		}
	}

	@Override
	public void shopping() {
		//1.seeAll(10atATime) 2.searchByName,category 3.addToCart 4.addToFavorite 0.goBack
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		try {
			int seeAtATime = 10;
			int n = 1;
			List<Product> productList = userRepositoryImpl.showAllProducts();
			boolean next = true;
			do {
				if(next){
					showProduct(n, n+seeAtATime-1, productList);
					n = (n+seeAtATime-1>=productList.size()) ? productList.size()+1 : n+seeAtATime;
				}
				System.out.println("" +
					"\tn. Next" +
					"\t1. Add to Cart." +
					"\t2. Search Product by Name:" +
					"\t3. Search Product by Category:" +
					"\t4. Add to Favorite." +
					"\t0. Back");
				String operation=scanner.nextLine();
				
				switch(operation) {
					case "n":
						if(n>=productList.size()){
							System.out.println("No more products available.");
							next = false;
						}
						continue;
					case "1": //Add to Cart
						int sno1 = checkInput(n-1);
						addToCart(productList.get(sno1-1));
						continue;
					case "2": //Search Product by Name
						System.out.print("Enter the name of product: ");
						String name = scanner.nextLine();
						next = false;
						productList = userRepositoryImpl.showProductsByName(name);
						n = productList.size();
						showProductsByName(name);
						continue;
					case "3": //Search Product by Category
						System.out.print("Enter the category of product: ");
						String category = scanner.nextLine();
						next = false;
						productList = userRepositoryImpl.showProductsByCategory(category);
						n = productList.size();
						showProductsByCategory(category);
						continue;
					case "4":
						int sno2 = checkInput(n-1);
						addToFavorite(productList.get(sno2-1));
						continue;
					default:
						System.out.println("Please input an correct option...");
						continue;
					case "0":
						break;
				}
				break;
			}while(true);
		} catch (OSAException e) {
				System.out.println(e);
		}
	}

	@Override
	public void cart() {
		//default.seeAll 1.remove 2.buy 0.goBack
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		try {
			do{
				Map<Product, Integer> cartMap = userRepositoryImpl.viewCart();
				if(cartMap==null){
					System.out.println("Your cart is empty.\n"+
						"please add something in it.");
					return;
				}
				Double totalAmount = 0d;
				Integer totalQuantity = 0;
				
				int i=1;
				for(Map.Entry<Product, Integer> entry: cartMap.entrySet()){
					Product product = entry.getKey();
					int quantity = entry.getValue();
					System.out.printf("%d) %-25s %10d %6.2d",
						i, product.getName(), quantity,
						product.getCost()*quantity);
					totalAmount += product.getCost()*quantity;
					totalQuantity += quantity;
					i++;
				}
				System.out.printf("--------------------------------------------\n"+
					"%39d 6.2d\n--------------------------------------------\n",
					totalQuantity, totalAmount);

				System.out.println("Please choose an option:\n"+
					"1. Remove something from cart.\n"+
					"2. Buy\n"+
					"0. Back");
				String operation=scanner.nextLine();

				switch(operation){
					case "1": //remove from cart
						int serialNo = checkInput(cartMap.size());
						int inCart = 0;
						Product product = null;
						i=1;
						for(Map.Entry<Product, Integer> entry: cartMap.entrySet()){
							if(i==serialNo){
								product = entry.getKey();
								inCart = entry.getValue();
							}
							i++;
						}
						System.out.print("Amount to be removed: ");
						int quantityRemove = scanner.nextInt();
						while(quantityRemove < 0 && quantityRemove>inCart){
							System.out.print("Please input an valid input: ");
							quantityRemove = scanner.nextInt();
						}
						int result = userRepositoryImpl.removeFromCart(product, quantityRemove);
						System.out.println((result>0)?"Successfully removed from cart.":
							"Enter an corret number of quantity.");
						continue;
					case "2": //buy
						buyProductsFromCart();
						break;
					default: 
						System.out.println("Please input an correct option...");
						continue;
					case "0":
						break;
				}
				break;
			}while(true);
		} catch (OSAException e) {
			System.out.println(e);
			System.out.println("Something went wrong\n\tplease try again later...");
		}
	
	}

	@Override
	public void favorite() {
		//default.seeAll(10AtATime) 1.remove 0.goBack
		
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		try {
			int seeAtATime = 10;
			int n = 1;
			boolean next = true;
			do {
				List<Product> productList = userRepositoryImpl.getProductFromFavorite();
				if(next){
					showProduct(n, n+seeAtATime-1, productList);
					n = (n+seeAtATime-1>=productList.size()) ? productList.size() : n+seeAtATime;
				}
				System.out.println("Please choose an option:" +
					"\tn. Next\n" + 
					"\t1. Remove something from favorite.\n"+
					"\t0. Back.");
				String operation=scanner.nextLine();
				
				switch(operation){
					case "n":
						if(n>=productList.size()){
							System.out.println("No more products available.");
							next = false;
						}
						continue;
					case "1"://Remove from Favorite.
						int serialNo = checkInput(n-1);
						removeFromFavorite(productList.get(serialNo-1).getId());
						continue;
					default:
						System.out.println("Please input an correct option...");
						continue;
					case "0":
						break;
				}
				break;
			} while(true);
		} catch(OSAException e){
			System.out.println(e);
			System.out.println("Something went wrong\n\tplease try again later...");
		}
		
	}

	
}
