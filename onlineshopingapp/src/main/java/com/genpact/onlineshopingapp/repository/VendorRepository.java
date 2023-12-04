package com.genpact.onlineshopingapp.repository;

import java.util.List;
import com.genpact.onlineshopingapp.entity.Orders;

// Persistence layer implementation
public interface VendorRepository {

    /*Give the list of all orders which the vendor has not conformed. */
    List<Orders> getPendingOrders();

    /*Set conformation of orders. */
    int setConfirmation(Orders order);
	int addProduct(String name, String category, Double cost, Integer warehouse);
	int removeProduct(String name, String category, Integer warehouse);
}
