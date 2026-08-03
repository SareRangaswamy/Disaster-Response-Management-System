package com.disaster.service;

import com.disaster.exception.ResourceUnavailableException;
import com.disaster.exception.RescueTeamUnavailableException;
import com.disaster.exception.ShelterCapacityException;
import com.disaster.model.EmergencyRequest;
import com.disaster.model.RescueTeam;
import com.disaster.model.Resource;
import com.disaster.model.Shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DisasterManagementSystem {

    private final List<RescueTeam> rescueTeams =
            new ArrayList<>();

    private final List<Resource> resources =
            new ArrayList<>();

    private final List<Shelter> shelters =
            new ArrayList<>();

    private final List<EmergencyRequest> requests =
            new ArrayList<>();


    // ==========================================
    // ADD RESCUE TEAM
    // ==========================================

    public void addRescueTeam(RescueTeam team) {

        rescueTeams.add(team);
    }


    // ==========================================
    // ADD RESOURCE
    // ==========================================

    public void addResource(Resource resource) {

        resources.add(resource);
    }


    // ==========================================
    // ADD SHELTER
    // ==========================================

    public void addShelter(Shelter shelter) {

        shelters.add(shelter);
    }


    // ==========================================
    // ADD REQUEST
    // ==========================================

    public void addRequest(EmergencyRequest request) {

        requests.add(request);
    }


    // ==========================================
    // ASSIGN RESCUE TEAM
    // ==========================================

    public RescueTeam assignTeam(
            String specialization)
            throws RescueTeamUnavailableException {

        RescueTeam team =
                rescueTeams.stream()

                        .filter(RescueTeam::isAvailable)

                        .filter(teamObject ->
                                teamObject
                                        .getSpecialization()
                                        .equalsIgnoreCase(
                                                specialization))

                        .findFirst()

                        .orElseThrow(() ->
                                new RescueTeamUnavailableException(
                                        "No available rescue team for: "
                                                + specialization
                                )
                        );

        team.setAvailable(false);

        return team;
    }


    // ==========================================
    // ALLOCATE RESOURCE
    // NAME + DISASTER TYPE
    // ==========================================

    public Resource allocateResource(
            String resourceName,
            String disasterType,
            int amount)
            throws ResourceUnavailableException {

        Resource resource =
                resources.stream()

                        .filter(resourceObject ->
                                resourceObject
                                        .getResourceName()
                                        .equalsIgnoreCase(
                                                resourceName))

                        .filter(resourceObject ->
                                resourceObject
                                        .getDisasterType()
                                        .equalsIgnoreCase(
                                                disasterType))

                        .findFirst()

                        .orElseThrow(() ->
                                new ResourceUnavailableException(
                                        "Resource not found: "
                                                + resourceName
                                                + " for disaster type: "
                                                + disasterType
                                )
                        );


        if (!resource.allocate(amount)) {

            throw new ResourceUnavailableException(
                    "Insufficient quantity of "
                            + resourceName
                            + " for "
                            + disasterType
            );
        }

        return resource;
    }


    // ==========================================
    // FIND RESOURCES FOR DISASTER
    // JAVA STREAM
    // ==========================================

    public List<Resource> findResourcesForDisaster(
            String disasterType) {

        return resources.stream()

                .filter(resource ->
                        resource.getDisasterType()
                                .equalsIgnoreCase(
                                        disasterType))

                .toList();
    }


    // ==========================================
    // ACCOMMODATE PEOPLE
    // ==========================================

    public Shelter accommodatePeople(
            int people)
            throws ShelterCapacityException {

        Shelter shelter =
                shelters.stream()

                        .filter(shelterObject ->
                                shelterObject
                                        .getAvailableCapacity()
                                        >= people)

                        .findFirst()

                        .orElseThrow(() ->
                                new ShelterCapacityException(
                                        "No shelter has enough capacity for "
                                                + people
                                                + " people."
                                )
                        );

        shelter.accommodatePeople(people);

        return shelter;
    }


    // ==========================================
    // CRITICAL REQUESTS
    // ==========================================

    public List<EmergencyRequest> getCriticalRequests() {

        return requests.stream()

                .filter(request ->
                        request.getSeverity() >= 8)

                .toList();
    }


    // ==========================================
    // REQUESTS BY SEVERITY
    // ==========================================

    public List<EmergencyRequest> getRequestsBySeverity() {

        return requests.stream()

                .sorted(
                        Comparator
                                .comparing(
                                        EmergencyRequest::getSeverity)
                                .reversed()
                )

                .toList();
    }


    // ==========================================
    // GET RESCUE TEAMS
    // ==========================================

    public List<RescueTeam> getRescueTeams() {

        return rescueTeams;
    }


    // ==========================================
    // GET RESOURCES
    // ==========================================

    public List<Resource> getResources() {

        return resources;
    }


    // ==========================================
    // GET SHELTERS
    // ==========================================

    public List<Shelter> getShelters() {

        return shelters;
    }


    // ==========================================
    // GET REQUESTS
    // ==========================================

    public List<EmergencyRequest> getRequests() {

        return requests;
    }
}