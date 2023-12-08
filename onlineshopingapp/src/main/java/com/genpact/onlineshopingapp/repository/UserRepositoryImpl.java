package com.genpact.onlineshopingapp.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.genpact.onlineshopingapp.entity.Cart;
import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.entity.Payment;
import com.genpact.onlineshopingapp.entity.Product;

public class UserRepositoryImpl implements UserRepository {
	static Customer customer = null;
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	CartRepository cartRepository = (CartRepository)context.getBean("cartRepository");
	CustomerRepository customerRepository = (CustomerRepository)context.getBean("customerRepository");
	FavoriteRepository favoriteRepository = (FavoriteRepository)context.getBean("favoriteRepository");
	ProductRepository productRepository = (ProductRepository)context.getBean("productRepository");
	ReviewRepository reviewRepository = (ReviewRepository)context.getBean("reviewRepository");
	ShopkeeperRepository shopkeeperRepository = (ShopkeeperRepository)context.getBean("shopkeeperRepository");
	OrderRepository orderRepository = (OrderRepository)context.getBean("orderRepository");
	PaymentRepository paymentRepository = (PaymentRepository)context.getBean("paymentRepository");
	/* Init is for user to see his cart when the user login */
	@Override
	public void init() {
		List<Cart> cartList = cartRepository.getAllItemsByCustomerId(customer.getId());
		if(cartList.size()==0)
			return;
		for(Cart cart:cartList){
			Product product = productRepository.getProductByCart(cart);
			if(product!=null){
				if(product.getId()!=cart.getPid()){
					cartRepository.remove(cart);
					cartRepository.addToCart(cart.getCid(), product.getId(), cart.getQuantity());
					System.out.println("price of " + product.getName() + " in your cart has changed.");
				}
			}
			else{
				String productName = productRepository.getProductName(cart.getPid());
				System.out.println(productName + " from your cart is out of stock.");
			}
		}
	}

	/* For user to log in to his account */
	@Override
	public int userLogin(String username, String password) {
		Customer c = customerRepository.userLogin(username, password);
		int valid = 0;
		if(c!=null){
			customer = c;
			init();
			valid = 1;
		}
		return valid;
	}

	/*For creating a new user account */
	@Override
	public int createUser(String fullName, String dob, String contact, 
		String email, String address, String username, String password) {
		Customer c = customerRepository.createCustomer(fullName, dob, contact, 
			email, address, username, password);
		int valid = 0;
		if(c!=null){
			customer = c;
            valid = 1;
		}
		return valid;
	}

	@Override
	public int modifyUser(String feature, String modify) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyPassword(String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addToCart(Product product, int quantity) {
		int cid = customer.getId();
		int pid = product.getId();
		return cartRepository.addToCart(cid, pid, quantity);
	}

	@Override
	public int removeFromCart(Product product, int quantity) {
		int cid = customer.getId();
		int pid = product.getId();
		return cartRepository.removeFromCart(cid, pid, quantity);
	}

	@Override
	public List<Payment> getAllPayment() {
		List<Payment> paymentList = paymentRepository.getAllPayment();
		return paymentList;
	}

	//list of all the Products in the cart
	@Override
	public Map<Product, Integer> viewCart(){
		List<Cart> cartList = cartRepository.getAllItemsByCustomerId(customer.getId());
		if(cartList.size()==0)
			return null;
		Map<Product, Integer> cartMap = new HashMap<Product, Integer>();
		for(Cart cart:cartList){
			int quantity = cart.getQuantity();
			Product product = productRepository.getProductById(cart.getPid());
			cartMap.put(product, quantity);
		}
		return cartMap;
	}

	@Override
	public Double placeOrderByCart(Payment payment) {
		List<Cart> cartList = cartRepository.getAllItemsByCustomerId(customer.getId());
		if(cartList.size()==0)
			return 0.0d;
		
		double amount = 0.0d;
		for(Cart cart:cartList){
			Product product = productRepository.getProductByCart(cart);
			if(product != null){
				orderRepository.placeOrder(customer.getId(), product, 
					cart.getQuantity(), payment.getId());
				cartRepository.remove(cart);
				amount+=product.getCost();
			}
		}
		return amount*(1 + payment.getDiscount()/100);
	}

	//should be able to track order
	@Override
	public String[][] trackProducts(){
		List<Orders> listOrders =orderRepository.getOrderByCustomerId(customer.getId());

		if(listOrders.size()==0)
			return null;
		
		String[][] ans = new String[listOrders.size()][4];
		for(int i=0; i<listOrders.size(); i++){
			Orders order = listOrders.get(i);
			Product productDetails = productRepository.getProductById(order.getPid());
			String diff = Integer.toString(order.getShippingDate().compareTo(LocalDate.now()));
			ans[i][0] = productDetails.getName(); 
			ans[i][1] = productDetails.getCategory();
			ans[i][2] = String.valueOf(order.getQuantity());
			ans[i][3] = diff;
		}
		return ans;
	}

	//show all products
	@Override
	public List<Product> showAllProducts(){
		return productRepository.showAllProducts();
	}
	
	//show products by category
	@Override
	public List<Product> showProductsByCategory(String category){
		return productRepository.showProductsByCategory(category);
	}

	//show products by Name
	@Override
	public List<Product> showProductsByName(String name){
		return productRepository.showProductsByName(name);
	}
	
	//customers should be able to view his/her details
	@Override
	public Customer viewDetails(){
		return customerRepository.viewDetails(customer.getId());
	}

	/* To get all unrated products.*/
	@Override
	public List<Product> getAllUnratedProducts() {
		int id=customer.getId();
		List<Product> productIds = productRepository.getAllUnratedProductsByCid(id);
		return productIds;
	}

	/*To add reviews to unrated products. */
	@Override
	public int addReview(Integer n, Double rating, String review) {
		Product product = getAllUnratedProducts().get(n-1);
		return reviewRepository.addReview(product.getId(), rating, review);
	}

	@Override
	public int checkPassword(String password) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'checkPassword'");
	}

	@Override
	public int updateUserPassword(String password) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateUserPassword'");
	}

	@Override
	public int checkUserPassword(String password) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'checkUserPassword'");
	}

    public List<Product> getProductFromFavorite() {
        List<Product> productList = productRepository.getProductFromFavorite(customer.getId());
		return productList;
    }

    public int removeFromFavorite(Integer productId) {
        int result;
		result = favoriteRepository.removeFromFavorite(customer.getId(), productId);
		return result;
    }

    public int addToFavorite(Integer productId) {
        int result = favoriteRepository.addToFavorite(customer.getId(), productId);
		return result;
    }
	
	// @Override
	// public int checkPassword(String password){
	// 	  int customers = jdbcTemplate.query("select * from customer where  _password='"+password+"', id="+customer.getId()+""){
	// 		{
	// 			if(customers==0){
	// 				return 0;
	// 			}
	// 			else{
	// 				return 1;
	// 			}
	// 		}
	// 	    };
    // }

	// public int updateUserPassword(String password){
	// 	 int update = jdbcTemplate.query("Update customer set _password='"+password+"' where id="+customer.getId()+""){
	// 		if(update==0){
	// 			return 0;
	// 		}
	// 		else{
	// 			return 1;
	// 		}

	// }

}
