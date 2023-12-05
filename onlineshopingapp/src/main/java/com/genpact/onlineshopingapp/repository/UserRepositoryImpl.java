package com.genpact.onlineshopingapp.repository;

import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.genpact.onlineshopingapp.entity.Cart;
import com.genpact.onlineshopingapp.entity.Customer;
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

	@Override
	public String init(Customer customer) {
		// TODO Auto-generated method stub
        return null;
	}

	@Override
	public int userLogin(String username, String password) {
		Customer c = customerRepository.userLogin(username, password);
		int valid = 0;
		if(c!=null){
			customer = c;
			init(customer);
			valid = 1;
		}
		return valid;
	}

	@Override
	public int createUser(String fullName, String dob, String contact, String email, String address, String username,
			String password) {
		Customer c = customerRepository.createCustomer(fullName, dob, contact, email, address, username, password);
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
	public Map<Product, Integer> searchProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addToCart(String productName, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFromCart(String productName, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Payment> getAllPayment() {
		List<Payment> paymentList = paymentRepository.getAllPayment();
		return paymentList;
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

	@Override
	public List<Product> getAllUnratedProducts() {
		int id=customer.getId();
		List<Product> productIds = productRepository.getAllUnratedProductsByCid(id);
		return productIds;
	}

	@Override
	public int addReview(Integer n, Double rating, String review) {
		Product product = getAllUnratedProducts().get(n-1);
		return reviewRepository.addReview(product.getId(), rating, review);
	}	
}
