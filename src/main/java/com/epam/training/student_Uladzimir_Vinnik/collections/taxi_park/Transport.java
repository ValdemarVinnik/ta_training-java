package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park;

public abstract class Transport {
    private int cost;
    private String registrationNumber;
    private int maxSpeed;
    private double fuelConsumptionForHundred;

    public Transport(int cost, String registrationNumber, int maxSpeed, double fuelConsumptionForHundred) {
        this.cost = cost;
        this.registrationNumber = registrationNumber;
        this.maxSpeed = maxSpeed;
        this.fuelConsumptionForHundred = fuelConsumptionForHundred;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setFuelConsumptionForHundred(double fuelConsumptionForHundred) {
        this.fuelConsumptionForHundred = fuelConsumptionForHundred;
    }
}
