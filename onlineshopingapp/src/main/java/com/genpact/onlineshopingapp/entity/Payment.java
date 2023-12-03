package com.genpact.onlineshopingapp.entity;

public class Payment {
    private int id;
    private String method;
    private Double discount;


    public Payment() {
    }

    public Payment(int id, String method, Double discount) {
        this.id = id;
        this.method = method;
        this.discount = discount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", method='" + getMethod() + "'" +
            ", discount='" + getDiscount() + "'" +
            "}";
    }

}
