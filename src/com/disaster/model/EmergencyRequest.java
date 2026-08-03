package com.disaster.model;

public class EmergencyRequest {

    private String requestType;
    private int severity;
    private int peopleAffected;

    public EmergencyRequest(String requestType,
                            int severity,
                            int peopleAffected) {

        this.requestType = requestType;
        this.severity = severity;
        this.peopleAffected = peopleAffected;
    }

    public String getRequestType() {
        return requestType;
    }

    public int getSeverity() {
        return severity;
    }

    public int getPeopleAffected() {
        return peopleAffected;
    }

    public void displayRequest() {

        System.out.println("Request Type: " + requestType);
        System.out.println("Severity: " + severity);
        System.out.println("People Affected: " + peopleAffected);
    }

    @Override
    public String toString() {

        return "Request Type: " + requestType +
                " | Severity: " + severity +
                " | People Affected: " + peopleAffected;
    }
}