package com.genpact.onlineshopingapp.entity;

public class Cart {
	private int cid;
    private int pid;
    private int quantity;


    public Cart(int cid, int pid, int quantity) {
        this.cid = cid;
        this.pid = pid;
        this.quantity = quantity;
    }



    public int getCid() {
        return this.cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
            " cid='" + getCid() + "'" +
            ", pid='" + getPid() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }
}