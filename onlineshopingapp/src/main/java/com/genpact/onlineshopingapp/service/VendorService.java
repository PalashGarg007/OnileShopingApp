package com.genpact.onlineshopingapp.service;

public interface VendorService {

    /* Vendor will be able to login */
    public int vendorLogin();

    /*Vendor will be able to create new account */
    public int createVendor();

    //vendors should be able to view his/her details
	void viewDetails();

    /*Confirm the pending product approval list. */
    void confirmProductList();

    //add or remove product
    void addProduct();
    void removeProduct();

    //restock product
    void restock();

    void inventory();

    void acceptOrders();
    //Update user password
    public void checkAndUpdateVendor();

}
