package com.genpact.onlineshopingapp.service;

public interface VendorService {

    /*Conform the pending product approval list. */
    void confirmProductList();

    //add or remove product
    void addProduct();
    void removeProduct();

    //restock product
    void restock();

}
