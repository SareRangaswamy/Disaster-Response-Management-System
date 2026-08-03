package com.disaster.model;

public class FireRequest extends EmergencyRequest {

    private int injuredPeople;

    public FireRequest(
            String requestType,
            int severity,
            int peopleAffected,
            int injuredPeople) {

        super(
                requestType,
                severity,
                peopleAffected
        );

        this.injuredPeople = injuredPeople;
    }

    public int getInjuredPeople() {
        return injuredPeople;
    }

    @Override
    public void displayRequest() {

        super.displayRequest();

        System.out.println(
                "Injured People: " + injuredPeople
        );
    }
}