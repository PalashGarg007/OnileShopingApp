package com.genpact.onlineshopingapp.repository;


// Persistence layer implementation
public interface VendorRepository {
	void addProduct(String name, String category, Double cost, Integer warehouse);
	void removeProduct(String name, String category, Integer warehouse);
}
