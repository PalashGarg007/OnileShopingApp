package com.genpact.onlineshopingapp.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.entity.Shopkeeper;

public class VendorRepositoryImpl implements VendorRepository{
    static Shopkeeper shopkeeper = null;
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	CartRepository cartRepository = (CartRepository)context.getBean("cartRepository");
	CustomerRepository customerRepository = (CustomerRepository)context.getBean("customerRepository");
	FavoriteRepository favoriteRepository = (FavoriteRepository)context.getBean("favoriteRepository");
	ProductRepository productRepository = (ProductRepository)context.getBean("productRepository");
	ReviewRepository reviewRepository = (ReviewRepository)context.getBean("reviewRepository");
	ShopkeeperRepository shopkeeperRepository = (ShopkeeperRepository)context.getBean("shopkeeperRepository");
	OrderRepository orderRepository = (OrderRepository)context.getBean("orderRepository");
	PaymentRepository paymentRepository = (PaymentRepository)context.getBean("paymentRepository");

	/*For vendor to login to his account */
	@Override
	public int vendorLogin(String username, String password) {
		Shopkeeper s = shopkeeperRepository.vendorLogin(username, password);
		int valid = 0;
		if(s!=null){
			shopkeeper = s;
			valid = 1;
		}
		return valid;	
	}

	//vendors should be able to view his/her details
	@Override
	public Shopkeeper viewDetails(){
		return shopkeeperRepository.viewDetails(shopkeeper.getId());
	}

    @Override
    public List<Orders> getPendingOrders() {
        List<Orders> pendingList = orderRepository.getPendingOrders(shopkeeper.getId());
        return pendingList;
    }

    @Override
    public int setConfirmation(Orders order) {
        int check = productRepository.getOrderFromWherehouse(order.getPid(), order.getQuantity());
        int conformation=0;
        if(check>0)
            conformation = orderRepository.setConfirmation(order);
        return conformation;
    }

    public String getProductName(Integer pid) {
        String productName = productRepository.getProductName(pid);
        return productName;
    }

	/*add and remove products */
    @Override
	public int addProduct(String name,String category,Double cost,Integer warehouse) {
		int sid = shopkeeper.getId();
		int result = 0;
		result = productRepository.addProduct(sid,name,category,cost,warehouse);
		if(result>0)
			return 1;
		return 0;
	}

	@Override
	public int removeProduct(String name, String category, Integer warehouse) {
		int sid = shopkeeper.getId();
		int result = 0;
		result = productRepository.removeProduct(sid, name, category, warehouse);
		if(result>0)
			return 1;
		return 0;
	}

	/*restock the amount of product. */
	@Override
	public int restock(String name, String category, Integer warehouse) {
		int sid = shopkeeper.getId();
		int result = 0;
		result = productRepository.restock(sid, name, category, warehouse);
		if(result>0)
			return 1;
		return 0;
	}

	/*To create a new vendor account */
	@Override
	public int createVendor(String fullName, String contact, String email,
		String userName, String password) {
		Shopkeeper s = shopkeeperRepository.createShopkeeper(fullName, contact, email, userName, password);
		int valid = 0;
		if(s!=null){
			shopkeeper = s;
            valid = 1;
		}
		return valid;
	}

	// @Override
	// public int checkVendorPassword(String password){
	// 	  int customers = jdbcTemplate.query("select * from shopkeeper where  _password='"+password+"', id="+shopkeeper.getId()+""){
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

	// @Override
	// public int updateVendorPassword(String password){
	// 	 int update = jdbcTemplate.query("Update shopkeeper set _password='"+password+"' where id="+shopkeeper.getId()+""){
	// 		if(update==0){
	// 			return 0;
	// 		}
	// 		else{
	// 			return 1;
	// 		}

	// 	}
	// }
}