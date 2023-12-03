<<<<<<< HEAD:onlineshopingapp/src/main/java/com/genpact/onlineshopingapp/entity/Order.java
package com.genpact.onlineshopingapp.entity;

import java.time.LocalDate;

public class Order {

    private int id;
    private int cid;
    private int sid;
    private int pid;
    private int amount;
    private int quantity;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private int payid;
    private boolean confirmation;


    public Order(int id, int cid, int sid, int pid, int amount, int quantity, LocalDate orderDate, LocalDate shippingDate, int payid, boolean confirmation) {
        this.id = id;
        this.cid = cid;
        this.sid = sid;
        this.pid = pid;
        this.amount = amount;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.payid = payid;
        this.confirmation = confirmation;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return this.cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return this.sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getShippingDate() {
        return this.shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public int getPayid() {
        return this.payid;
    }

    public void setPayid(int payid) {
        this.payid = payid;
    }

    public boolean isConfirmation() {
        return this.confirmation;
    }

    public boolean getConfirmation() {
        return this.confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cid='" + getCid() + "'" +
            ", sid='" + getSid() + "'" +
            ", pid='" + getPid() + "'" +
            ", amount='" + getAmount() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", shippingDate='" + getShippingDate() + "'" +
            ", payid='" + getPayid() + "'" +
            ", confirmation='" + isConfirmation() + "'" +
            "}";
    }


}
=======

>>>>>>> ca086f3dc94dcec38f73a64ba2ddd51028af0e9f:onlineshopingapp/src/main/java/com/genpact/onlineshopingapp/entity/Orders.java
