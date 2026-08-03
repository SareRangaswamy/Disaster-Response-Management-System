package com.disaster.model;

public class CycloneZone extends DisasterZone {

    public CycloneZone(String zoneName) {
        super(zoneName);
    }

    @Override
    public void showAlert() {
        System.out.println("Cyclone Alert in Zone: " + zoneName);
    }
}