package com.genpact.onlineshopingapp.repository;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.entity.Product;
import com.genpact.onlineshopingapp.entity.Shopkeeper;

public class AdminRepositoryImpl implements AdminRepository {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//	CartRepository cartRepository = (CartRepository)context.getBean("cartRepository");
	CustomerRepository customerRepository = (CustomerRepository)context.getBean("customerRepository");
//	FavoriteRepository favoriteRepository = (FavoriteRepository)context.getBean("favoriteRepository");
	ProductRepository productRepository = (ProductRepository)context.getBean("productRepository");
//	ReviewRepository reviewRepository = (ReviewRepository)context.getBean("reviewRepository");
	ShopkeeperRepository shopkeeperRepository = (ShopkeeperRepository)context.getBean("shopkeeperRepository");
	OrderRepository orderRepository = (OrderRepository)context.getBean("orderRepository");
	PaymentRepository paymentRepository = (PaymentRepository)context.getBean("paymentRepository");
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = customerRepository.getAll();
		return customers;
	}

	@Override
	public List<Shopkeeper> getAllShopkeeper() {
		List<Shopkeeper> shopkeepers = shopkeeperRepository.getAll();
		return shopkeepers;
	}

	@Override
	public List<Orders> getHistoryOfCustomer(Integer customerId) {
		List<Orders> orders = orderRepository.getOrderByCustomerId(customerId);
		return orders;		
	}

	@Override
	public List<Product> getHystoryOfShopkeeper(String shopkeeperId) {
		List<Product> products = productRepository.getProductByShopkeeperId(shopkeeperId);
		return products;
	}

	@Override
	public int addPaymentMethod(String paymentMethod, Double discount) {
		int result = paymentRepository.addPaymentMethod(paymentMethod,discount);
		return result;
	}

	@Override
	public int changeDiscountOfPayment(String paymentMethod, Double discount) {
		int result = paymentRepository.modefyDiscount(paymentMethod,discount);
		return result;
	}
	
	
}
