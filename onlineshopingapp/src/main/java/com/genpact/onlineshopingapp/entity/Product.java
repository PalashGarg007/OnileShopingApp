package com.genpact.onlineshopingapp.entity;

public class Product {
    private int id;
    private int sid;
    private String name;
    private String category;
    private Double cost;
    private int warehouse;
    private Double rating;
    private int purchased;


    public Product(int id, int sid, String name, String category, Double cost, int warehouse, Double rating, int purchased) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.warehouse = warehouse;
        this.rating = rating;
        this.purchased = purchased;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return this.sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getPurchased() {
        return this.purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", sid='" + getSid() + "'" +
            ", name='" + getName() + "'" +
            ", category='" + getCategory() + "'" +
            ", cost='" + getCost() + "'" +
            ", warehouse='" + getWarehouse() + "'" +
            ", rating='" + getRating() + "'" +
            ", purchased='" + getPurchased() + "'" +
            "}";
    }


}
