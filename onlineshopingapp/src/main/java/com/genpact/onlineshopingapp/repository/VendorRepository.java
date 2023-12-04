package com.genpact.onlineshopingapp.repository;

import java.util.List;
import com.genpact.onlineshopingapp.entity.Orders;

  // Persistence layer implementation
  public interface VendorRepository {

    /* Vendor login using username and password */
    public int vendorLogin(String username, String password);
    
    
    /*Give the list of all orders which the vendor has not conformed. */
    List<Orders> getPendingOrders();

    /*Set conformation of orders. */
    int setConfirmation(Orders order);

    /*add and remove products */
    int addProduct(String name, String category, Double cost, Integer warehouse);
    int removeProduct(String name, String category, Integer warehouse);

    /*restock the amount of product. */
    int restock(String name, String category, Integer warehouse);

    /*Create new vendor account and add his details in the database.*/
    int createVendor(String fullName, String contact, String email, String userName, String password);
  
  
}
