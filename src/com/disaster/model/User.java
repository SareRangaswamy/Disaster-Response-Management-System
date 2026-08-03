package com.disaster.model;

public class User {

    private String name;
    private String phone;
    private String location;

    public User(String name,
                String phone,
                String location) {

        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public void displayUser() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Location: " + location);
    }
}