package com.disaster.model;

public class Resource {

    private String resourceName;
    private int quantity;
    private String disasterType;

    public Resource(String resourceName,
                    int quantity,
                    String disasterType) {

        this.resourceName = resourceName;
        this.quantity = quantity;
        this.disasterType = disasterType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public boolean allocate(int amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > quantity) {
            return false;
        }

        quantity -= amount;

        return true;
    }

    public void displayResource() {

        System.out.println(
                "Resource Name: " + resourceName);

        System.out.println(
                "Quantity: " + quantity);

        System.out.println(
                "Disaster Type: " + disasterType);
    }

    @Override
    public String toString() {

        return "Resource: " + resourceName +
                " | Quantity: " + quantity +
                " | Disaster Type: " + disasterType;
    }
}