package com.genpact.onlineshopingapp.entity;

public class Shopkeeper {

    private Integer id;
    private String name;
    private String contact;
    private String email;
    private String userName;
    private String password;

    public Shopkeeper() {
    }


    public Shopkeeper(Integer id, String name, String contact, String email, String userName, String password) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\n" +
            "\tShopkeeper ID = " + getId() + "\n" +
            "\tName = " + getName() + "\n" +
            "\tContact = " + getContact() + "\n" +
            "\tEmail = " + getEmail() + "\n" +
            "\tUser Name = " + getUserName() + "\n" +
            "\tPassword = " + getPassword() + "\n" +
            "}";
    }

}
