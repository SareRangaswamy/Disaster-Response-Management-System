package com.disaster.model;

import java.util.List;

public class AllocationResult {

    private int priorityScore;
    private String priorityLevel;
    private RescueTeam rescueTeam;
    private List<Resource> allocatedResources;
    private Shelter shelter;
    private String status;

    public AllocationResult(int priorityScore,
                            String priorityLevel,
                            RescueTeam rescueTeam,
                            List<Resource> allocatedResources,
                            Shelter shelter,
                            String status) {

        this.priorityScore = priorityScore;
        this.priorityLevel = priorityLevel;
        this.rescueTeam = rescueTeam;
        this.allocatedResources = allocatedResources;
        this.shelter = shelter;
        this.status = status;
    }

    public int getPriorityScore() {
        return priorityScore;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public RescueTeam getRescueTeam() {
        return rescueTeam;
    }

    public List<Resource> getAllocatedResources() {
        return allocatedResources;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public String getStatus() {
        return status;
    }

    public void displayResult() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          AI RESPONSE RESULT");
        System.out.println("==========================================");

        System.out.println("Priority Score : " + priorityScore);
        System.out.println("Priority Level : " + priorityLevel);

        System.out.println();

        System.out.println("---------- RESCUE TEAM ----------");

        if (rescueTeam != null) {
            rescueTeam.displayTeam();
        } else {
            System.out.println("No rescue team assigned.");
        }

        System.out.println();

        System.out.println("---------- RESOURCES ----------");

        if (allocatedResources != null &&
                !allocatedResources.isEmpty()) {

            allocatedResources.forEach(Resource::displayResource);

        } else {
            System.out.println("No resources allocated.");
        }

        System.out.println();

        System.out.println("---------- SHELTER ----------");

        if (shelter != null) {
            shelter.displayShelter();
        } else {
            System.out.println("No shelter assigned.");
        }

        System.out.println();

        System.out.println("Status: " + status);

        System.out.println("==========================================");
    }
}