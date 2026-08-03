package com.disaster.model;

public class Victim {

    private String name;
    private int age;
    private boolean injured;

    public Victim(String name,
                  int age,
                  boolean injured) {

        this.name = name;
        this.age = age;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isInjured() {
        return injured;
    }

    public void displayVictim() {
        System.out.println("Victim Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Injured: " + injured);
    }
}