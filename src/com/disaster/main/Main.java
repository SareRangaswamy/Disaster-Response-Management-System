package com.disaster.main;

import com.disaster.ai.AIAllocationEngine;
import com.disaster.model.AllocationResult;
import com.disaster.model.EarthquakeRequest;
import com.disaster.model.EmergencyRequest;
import com.disaster.model.FireRequest;
import com.disaster.model.FloodRequest;
import com.disaster.model.Resource;
import com.disaster.model.RescueTeam;
import com.disaster.model.Shelter;
import com.disaster.service.DisasterManagementSystem;
import com.disaster.util.InputValidator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       AI DISASTER RESPONSE SYSTEM");
        System.out.println("==========================================");

        // ==========================================
        // INPUT
        // ==========================================

        Scanner scanner = new Scanner(System.in);

        InputValidator input =
                new InputValidator(scanner);

        String disasterType =
                input.getDisasterType();

        int severity =
                input.getSeverity();

        int peopleAffected =
                input.getPeopleAffected();

        int injuredPeople =
                input.getInjuredPeople(peopleAffected);


        // ==========================================
        // CREATE MANAGEMENT SYSTEM
        // ==========================================

        DisasterManagementSystem system =
                new DisasterManagementSystem();


        // ==========================================
        // CREATE AI ENGINE
        // ==========================================

        AIAllocationEngine ai =
                new AIAllocationEngine();


        // ==========================================
        // RESCUE TEAMS
        // ==========================================

        system.addRescueTeam(
                new RescueTeam(
                        "Flood Rescue Team",
                        10,
                        "Water Rescue",
                        true
                )
        );

        system.addRescueTeam(
                new RescueTeam(
                        "Fire Rescue Team",
                        12,
                        "Fire Rescue",
                        true
                )
        );

        system.addRescueTeam(
                new RescueTeam(
                        "Earthquake Rescue Team",
                        15,
                        "Search and Rescue",
                        true
                )
        );


        // ==========================================
        // FLOOD RESOURCES
        // ==========================================

        system.addResource(
                new Resource(
                        "Rescue Boats",
                        10,
                        "Flood"
                )
        );

        system.addResource(
                new Resource(
                        "Life Jackets",
                        100,
                        "Flood"
                )
        );

        system.addResource(
                new Resource(
                        "Medical Kits",
                        100,
                        "Flood"
                )
        );


        // ==========================================
        // FIRE RESOURCES
        // ==========================================

        system.addResource(
                new Resource(
                        "Fire Extinguishers",
                        50,
                        "Fire"
                )
        );

        system.addResource(
                new Resource(
                        "Medical Kits",
                        100,
                        "Fire"
                )
        );


        // ==========================================
        // EARTHQUAKE RESOURCES
        // ==========================================

        system.addResource(
                new Resource(
                        "Rescue Equipment",
                        50,
                        "Earthquake"
                )
        );

        system.addResource(
                new Resource(
                        "Medical Kits",
                        100,
                        "Earthquake"
                )
        );


        // ==========================================
        // SHELTER
        // ==========================================

        system.addShelter(
                new Shelter(
                        "Emergency Relief Shelter",
                        "Switzerland",
                        500,
                        0
                )
        );


        // ==========================================
        // CREATE REQUEST
        // ==========================================

        EmergencyRequest request;

        if (disasterType.equalsIgnoreCase("Flood")) {

            request = new FloodRequest(
                    "Flood",
                    severity,
                    peopleAffected,
                    injuredPeople
            );

        } else if (disasterType.equalsIgnoreCase("Fire")) {

            request = new FireRequest(
                    "Fire",
                    severity,
                    peopleAffected,
                    injuredPeople
            );

        } else {

            request = new EarthquakeRequest(
                    "Earthquake",
                    severity,
                    peopleAffected,
                    injuredPeople
            );
        }


        // ==========================================
        // DISPLAY REQUEST
        // ==========================================

        System.out.println();

        request.displayRequest();


        // ==========================================
        // ADD REQUEST
        // ==========================================

        system.addRequest(request);


        // ==========================================
        // AI PROCESSING
        // ==========================================

        AllocationResult result =
                ai.processRequest(
                        request,
                        system
                );


        // ==========================================
        // DISPLAY AI RESULT
        // ==========================================

        result.displayResult();


        // ==========================================
        // STREAM OPERATIONS
        // ==========================================

        System.out.println();

        System.out.println(
                "CRITICAL REQUESTS: "
                        + system
                        .getCriticalRequests()
                        .size()
        );

        System.out.println();

        System.out.println(
                "REQUESTS BY SEVERITY:"
        );

        system.getRequestsBySeverity()
                .forEach(requestObject ->
                        System.out.println(
                                requestObject.getRequestType()
                                        + " - Severity: "
                                        + requestObject.getSeverity()
                        )
                );


        // ==========================================
        // FINAL SYSTEM STATE
        // ==========================================

        System.out.println();

        System.out.println(
                "========== FINAL SYSTEM STATE =========="
        );

        System.out.println();

        System.out.println("RESCUE TEAMS:");

        system.getRescueTeams()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("RESOURCES:");

        system.getResources()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("SHELTERS:");

        system.getShelters()
                .forEach(System.out::println);


        // ==========================================
        // COMPLETED
        // ==========================================

        System.out.println();

        System.out.println("==========================================");
        System.out.println("       RESPONSE PROCESS COMPLETED");
        System.out.println("==========================================");

        scanner.close();
    }
}