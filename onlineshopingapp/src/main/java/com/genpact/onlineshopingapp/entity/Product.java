package com.genpact.onlineshopingapp.entity;

public class Product {
    private Integer id;
    private Integer sid;
    private String name;
    private String category;
    private Double cost;
    private Integer warehouse;
    private Double rating;
    private Integer purchased;


    public Product() {
    }

    public Product(Integer id, Integer sid, String name, String category, Double cost, Integer warehouse, Double rating, Integer purchased) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.warehouse = warehouse;
        this.rating = rating;
        this.purchased = purchased;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
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

    public Integer getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getPurchased() {
        return this.purchased;
    }

    public void setPurchased(Integer purchased) {
        this.purchased = purchased;
    }

    @Override
    public String toString() {
        return "{\n" +
            "\tProduct ID = " + getId() + "\n" +
            "\tShopkeeper ID = " + getSid() + "\n" +
            "\tName = " + getName() + "\n" +
            "\tCategory = " + getCategory() + "\n" +
            "\tCost = " + getCost() + "\n" +
            "\tWarehouse = " + getWarehouse() + "\n" +
            "\tRating = " + getRating() + "\n" +
            "\tPurchased = " + getPurchased() + "\n" +
            "}";
    }

}
