package com.genpact.onlineshopingapp.entity;

public class Cart {
	private Integer cid;
    private Integer pid;
    private Integer quantity;

    public Cart() {
    }


    public Cart(Integer cid, Integer pid, Integer quantity) {
        this.cid = cid;
        this.pid = pid;
        this.quantity = quantity;
    }



    public Integer getCid() {
        return this.cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{\n" +
            "\tCustomer ID = " + getCid() + "\n" +
            ",\tProduct ID = " + getPid() + "\n" +
            ",\tQuantity = " + getQuantity() + "\n" +
            "}";
    }
}
