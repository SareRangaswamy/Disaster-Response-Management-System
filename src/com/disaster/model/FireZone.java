package com.disaster.model;

public class FireZone extends DisasterZone {

    public FireZone(String zoneName) {
        super(zoneName);
    }

    @Override
    public void showAlert() {
        System.out.println("Fire Alert in Zone: " + zoneName);
    }
}