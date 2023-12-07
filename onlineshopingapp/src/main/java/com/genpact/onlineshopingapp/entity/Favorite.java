package com.genpact.onlineshopingapp.entity;

public class Favorite {
private Integer cid;
private Integer pid;

    public Favorite() {
    }


    public Favorite(Integer cid, Integer pid) {
        this.cid = cid;
        this.pid = pid;
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

    @Override
    public String toString() {
        return "{\n" +
            "\tCustomer ID = " + getCid() + "\n" +
            "\tProduct ID = " + getPid() + "\n" +
            "}";
    }

}
