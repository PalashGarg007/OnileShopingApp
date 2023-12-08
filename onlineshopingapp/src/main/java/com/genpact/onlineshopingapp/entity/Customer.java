package com.genpact.onlineshopingapp.entity;

import java.time.LocalDate;

public class Customer {

    private Integer id;
    private String name;
    private LocalDate dob;
    private String contact;
    private String email;
    private String address;
    private String userName;
    private String password;


    public Customer() {
    }

    public Customer(Integer id, String name, LocalDate dob, String contact, String email, String address, String userName, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.email = email;
        this.address = address;
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

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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
            "\tCustomer ID = " + getId() + "\n" +
            "\tName = " + getName() + "\n" +
            "\tDOB = " + getDob() + "\n" +
            "\tContact = " + getContact() + "\n" +
            "\tEmail = " + getEmail() + "\n" +
            "\tAddress = " + getAddress() + "\n" +
            "\tUser Name = " + getUserName() + "\n" +
            "\tPassword = " + getPassword() + "\n" +
            "}";
    }

}
