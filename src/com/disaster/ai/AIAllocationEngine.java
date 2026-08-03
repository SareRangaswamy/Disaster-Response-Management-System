package com.disaster.ai;

import com.disaster.exception.ResourceUnavailableException;
import com.disaster.exception.RescueTeamUnavailableException;
import com.disaster.exception.ShelterCapacityException;
import com.disaster.model.AllocationResult;
import com.disaster.model.EmergencyRequest;
import com.disaster.model.MedicalRequest;
import com.disaster.model.Resource;
import com.disaster.model.RescueTeam;
import com.disaster.model.Shelter;
import com.disaster.service.DisasterManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class AIAllocationEngine {


    // ==========================================
    // MAIN AI PROCESSING METHOD
    // ==========================================

    public AllocationResult processRequest(
            EmergencyRequest request,
            DisasterManagementSystem system) {


        // ==========================================
        // STEP 1: CALCULATE PRIORITY
        // ==========================================

        int priorityScore =
                calculatePriorityScore(request);

        String priorityLevel =
                determinePriorityLevel(
                        priorityScore);


        // ==========================================
        // STEP 2: DETERMINE TEAM
        // ==========================================

        String specialization =
                determineSpecialization(
                        request.getRequestType());

        RescueTeam assignedTeam;


        try {

            assignedTeam =
                    system.assignTeam(
                            specialization);

        } catch (RescueTeamUnavailableException e) {

            return new AllocationResult(
                    priorityScore,
                    priorityLevel,
                    null,
                    new ArrayList<>(),
                    null,
                    "RESPONSE FAILED: "
                            + e.getMessage()
            );
        }


        // ==========================================
        // STEP 3: FIND DISASTER RESOURCES
        // ==========================================

        List<Resource> matchingResources =
                system.findResourcesForDisaster(
                        request.getRequestType());


        List<Resource> allocatedResources =
                new ArrayList<>();


        // ==========================================
        // STEP 4: ALLOCATE RESOURCES
        // ==========================================

        try {

            for (Resource resource :
                    matchingResources) {

                int requiredAmount =
                        determineRequiredAmount(
                                resource.getResourceName(),
                                request);


                if (requiredAmount > 0) {

                    Resource allocated =
                            system.allocateResource(
                                    resource.getResourceName(),
                                    request.getRequestType(),
                                    requiredAmount
                            );

                    allocatedResources.add(
                            allocated);
                }
            }


        } catch (ResourceUnavailableException e) {

            return new AllocationResult(
                    priorityScore,
                    priorityLevel,
                    assignedTeam,
                    allocatedResources,
                    null,
                    "RESPONSE FAILED: "
                            + e.getMessage()
            );
        }


        // ==========================================
        // STEP 5: SHELTER ALLOCATION
        // ==========================================

        Shelter shelter;


        try {

            shelter =
                    system.accommodatePeople(
                            request.getPeopleAffected());

        } catch (ShelterCapacityException e) {

            return new AllocationResult(
                    priorityScore,
                    priorityLevel,
                    assignedTeam,
                    allocatedResources,
                    null,
                    "RESPONSE FAILED: "
                            + e.getMessage()
            );
        }


        // ==========================================
        // STEP 6: RETURN RESULT
        // ==========================================

        return new AllocationResult(
                priorityScore,
                priorityLevel,
                assignedTeam,
                allocatedResources,
                shelter,
                "RESPONSE INITIATED SUCCESSFULLY"
        );
    }


    // ==========================================
    // PRIORITY SCORE
    // ==========================================

    private int calculatePriorityScore(
            EmergencyRequest request) {

        int score = 0;


        // Severity contribution

        score +=
                request.getSeverity() * 10;


        // Affected people contribution

        score +=
                request.getPeopleAffected() / 20;


        // Medical emergency contribution

        if (request instanceof MedicalRequest) {

            MedicalRequest medicalRequest =
                    (MedicalRequest) request;

            score +=
                    medicalRequest
                            .getInjuredPeople() / 5;
        }


        return score;
    }


    // ==========================================
    // PRIORITY LEVEL
    // ==========================================

    private String determinePriorityLevel(
            int score) {

        if (score >= 100) {

            return "CRITICAL";

        } else if (score >= 60) {

            return "HIGH";

        } else if (score >= 30) {

            return "MEDIUM";

        } else {

            return "LOW";
        }
    }


    // ==========================================
    // DETERMINE TEAM SPECIALIZATION
    // ==========================================

    private String determineSpecialization(
            String disasterType) {

        if (disasterType.equalsIgnoreCase(
                "Flood")) {

            return "Water Rescue";
        }


        if (disasterType.equalsIgnoreCase(
                "Fire")) {

            return "Fire Rescue";
        }


        if (disasterType.equalsIgnoreCase(
                "Earthquake")) {

            return "Search and Rescue";
        }


        if (disasterType.equalsIgnoreCase(
                "Cyclone")) {

            return "Disaster Response";
        }


        return "General Rescue";
    }


    // ==========================================
    // DETERMINE RESOURCE QUANTITY
    // ==========================================

    private int determineRequiredAmount(
            String resourceName,
            EmergencyRequest request) {


        String disasterType =
                request.getRequestType();


        // ==========================================
        // FLOOD
        // ==========================================

        if (disasterType.equalsIgnoreCase(
                "Flood")) {

            if (resourceName.equalsIgnoreCase(
                    "Rescue Boats")) {

                return 5;
            }


            if (resourceName.equalsIgnoreCase(
                    "Life Jackets")) {

                return 50;
            }


            if (resourceName.equalsIgnoreCase(
                    "Medical Kits")) {

                return 50;
            }
        }


        // ==========================================
        // FIRE
        // ==========================================

        if (disasterType.equalsIgnoreCase(
                "Fire")) {

            if (resourceName.equalsIgnoreCase(
                    "Fire Extinguishers")) {

                return 10;
            }


            if (resourceName.equalsIgnoreCase(
                    "Medical Kits")) {

                return 30;
            }
        }


        // ==========================================
        // EARTHQUAKE
        // ==========================================

        if (disasterType.equalsIgnoreCase(
                "Earthquake")) {

            if (resourceName.equalsIgnoreCase(
                    "Rescue Equipment")) {

                return 10;
            }


            if (resourceName.equalsIgnoreCase(
                    "Medical Kits")) {

                return 50;
            }
        }


        return 0;
    }
}