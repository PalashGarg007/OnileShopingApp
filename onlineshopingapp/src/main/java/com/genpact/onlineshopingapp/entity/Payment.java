package com.genpact.onlineshopingapp.entity;

public class Payment {
    private Integer id;
    private String method;
    private Double discount;


    public Payment() {
    }

    public Payment(Integer id, String method, Double discount) {
        this.id = id;
        this.method = method;
        this.discount = discount;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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
