package com.genpact.onlineshopingapp.service;

public interface AdminService {

	/*Display the details of all the Customers. */
	void getAllCustomer();
	
	/*Display the details of all the Shopkeepers. */
	void getAllShopkeeper();

	/*Display the details of all the Orders of a customer by taking his customerId. */
	void getHistoryOfCustomer();

	/*Display all the inventory of a Shopkeeper by taking his shopkeeperId. */
	void getHistoryOfShopkeeper();

	/*Display the status of the Update. */
	void addPaymentMethod();

	/*Display the status of the Update. */
	void changeDiscountOfPayment();
}
