package com.disaster.model;

public class EarthQuakeZone extends DisasterZone {

    public EarthQuakeZone(String zoneName) {
        super(zoneName);
    }

    @Override
    public void showAlert() {
        System.out.println("Earthquake Alert in Zone: " + zoneName);
    }
}