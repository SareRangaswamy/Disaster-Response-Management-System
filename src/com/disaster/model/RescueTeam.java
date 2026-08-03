package com.disaster.model;

public class RescueTeam {

    private String teamName;
    private int teamMembers;
    private String specialization;
    private boolean available;

    public RescueTeam(String teamName,
                      int teamMembers,
                      String specialization,
                      boolean available) {

        this.teamName = teamName;
        this.teamMembers = teamMembers;
        this.specialization = specialization;
        this.available = available;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamMembers() {
        return teamMembers;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Used to display team information
    public void displayTeam() {

        System.out.println("Team Name: " + teamName);
        System.out.println("Team Members: " + teamMembers);
        System.out.println("Specialization: " + specialization);
        System.out.println("Available: " + available);
    }

    @Override
    public String toString() {

        return "Rescue Team: " + teamName +
                " | Members: " + teamMembers +
                " | Specialization: " + specialization +
                " | Available: " + available;
    }
}