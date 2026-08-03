package com.disaster.model;

public class Shelter {

    private String shelterName;
    private String location;
    private int capacity;
    private int occupied;

    public Shelter(String shelterName,
                   String location,
                   int capacity,
                   int occupied) {

        this.shelterName = shelterName;
        this.location = location;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    public String getShelterName() {
        return shelterName;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupied() {
        return occupied;
    }

    // Calculate remaining capacity
    public int getAvailableCapacity() {

        return capacity - occupied;
    }

    // Accommodate people
    public boolean accommodatePeople(int people) {

        if (people <= 0) {
            return false;
        }

        if (people > getAvailableCapacity()) {
            return false;
        }

        occupied = occupied + people;

        return true;
    }

    // Used to display shelter information
    public void displayShelter() {

        System.out.println("Shelter Name: " + shelterName);
        System.out.println("Location: " + location);
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupied: " + occupied);
        System.out.println("Available Capacity: "
                + getAvailableCapacity());
    }

    @Override
    public String toString() {

        return "Shelter: " + shelterName +
                " | Location: " + location +
                " | Capacity: " + capacity +
                " | Occupied: " + occupied +
                " | Available: " + getAvailableCapacity();
    }
}