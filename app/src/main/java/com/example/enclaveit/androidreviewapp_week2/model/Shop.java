package com.example.enclaveit.androidreviewapp_week2.model;

/**
 * Created by enclaveit on 20/12/2016.
 */

public class Shop {
    private  int id;
    private String name;
    private String address;
    public Shop(){

    }

    public Shop(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
