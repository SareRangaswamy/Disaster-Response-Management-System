package com.disaster.util;

import java.util.Scanner;

public class InputValidator {

    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getDisasterType() {

        while (true) {

            System.out.print("Enter disaster type (Flood/Fire/Earthquake): ");

            String type = scanner.nextLine().trim();

            if (type.equalsIgnoreCase("Flood") ||
                    type.equalsIgnoreCase("Fire") ||
                    type.equalsIgnoreCase("Earthquake")) {

                return type;
            }

            System.out.println(
                    "Invalid disaster type. Please enter Flood, Fire, or Earthquake."
            );
        }
    }

    public int getSeverity() {

        while (true) {

            System.out.print("Enter severity (1-10): ");

            try {

                int severity = Integer.parseInt(
                        scanner.nextLine().trim()
                );

                if (severity >= 1 && severity <= 10) {
                    return severity;
                }

                System.out.println(
                        "Severity must be between 1 and 10."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    public int getPeopleAffected() {

        while (true) {

            System.out.print("Enter people affected: ");

            try {

                int people = Integer.parseInt(
                        scanner.nextLine().trim()
                );

                if (people > 0) {
                    return people;
                }

                System.out.println(
                        "People affected must be greater than 0."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
            }
        }
    }

    public int getInjuredPeople(int peopleAffected) {

        while (true) {

            System.out.print("Enter injured people: ");

            try {

                int injured = Integer.parseInt(
                        scanner.nextLine().trim()
                );

                if (injured >= 0 && injured <= peopleAffected) {
                    return injured;
                }

                System.out.println(
                        "Injured people must be between 0 and "
                                + peopleAffected
                                + "."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
            }
        }
    }
}