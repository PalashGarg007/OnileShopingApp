package com.genpact.onlineshopingapp.entity;

public class Favorite {
private int cid;
private int pid;

    public Favorite() {
    }


    public Favorite(int cid, int pid) {
        this.cid = cid;
        this.pid = pid;
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

    @Override
    public String toString() {
        return "{" +
            " cid='" + getCid() + "'" +
            ", pid='" + getPid() + "'" +
            "}";
    }

}
