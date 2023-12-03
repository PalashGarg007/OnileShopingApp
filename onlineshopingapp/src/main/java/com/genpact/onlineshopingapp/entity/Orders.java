
package com.genpact.onlineshopingapp.entity;

import java.time.LocalDate;

public class Orders {

    private Integer id;
    private Integer cid;
    private Integer sid;
    private Integer pid;
    private Double amount;
    private Integer quantity;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private Integer payid;
    private boolean confirmation;


    public Orders() {
    }

    public Orders(Integer id, Integer cid, Integer sid, Integer pid, Double amount, Integer quantity, LocalDate orderDate, LocalDate shippingDate, Integer payid, boolean confirmation) {
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return this.cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public Integer getPayId() {
        return this.payid;
    }

    public void setPayId(Integer payid) {
        this.payid = payid;
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
            ", payid='" + getPayId() + "'" +
            "}";
    }
    
}