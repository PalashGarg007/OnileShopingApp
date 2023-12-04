package com.genpact.onlineshopingapp.service;

public interface VendorService {

    /* Vendor will be able to login */
    public int vendorLogin();

    /*Confirm the pending product approval list. */
    void confirmProductList();

    //add or remove product
    void addProduct();
    void removeProduct();

    //restock product
    void restock();

}
