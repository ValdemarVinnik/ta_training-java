package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars;

import java.util.Objects;

public abstract class Transport {
    private String model;
    private int cost;
    private String registrationNumber;
    private int maxSpeed;
    private double fuelConsumptionForHundred;

    public Transport(String model, int cost, String registrationNumber,
                     int maxSpeed, double fuelConsumptionForHundred) {
        this.model = model;
        this.cost = cost;
        this.registrationNumber = registrationNumber;
        this.maxSpeed = maxSpeed;
        this.fuelConsumptionForHundred = fuelConsumptionForHundred;
    }

    public String getModel() {
        return model;
    }

    public int getCost() {
        return cost;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumptionForHundred() {
        return fuelConsumptionForHundred;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "model='" + model + '\'' +
                ", cost=" + cost +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumptionForHundred=" + fuelConsumptionForHundred +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;
        Transport transport = (Transport) o;
        return getCost() == transport.getCost() &&
                getMaxSpeed() == transport.getMaxSpeed() &&
                Double.compare(transport.getFuelConsumptionForHundred(), getFuelConsumptionForHundred()) == 0 &&
                getModel().equals(transport.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getCost(), getRegistrationNumber(), getMaxSpeed(), getFuelConsumptionForHundred());
    }
}
