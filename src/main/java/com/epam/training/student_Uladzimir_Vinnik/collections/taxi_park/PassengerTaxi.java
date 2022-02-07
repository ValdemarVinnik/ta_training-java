package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park;

public class PassengerTaxi extends Transport {
    private TypeOfTransport type;
    private int passengerCapacity;

    public PassengerTaxi(int cost, String registrationNumber, int maxSpeed, double fuelConsumptionForHundred,
                         TypeOfTransport type, int passengerCapacity) {
        super(cost, registrationNumber, maxSpeed, fuelConsumptionForHundred);
        this.type = type;
        this.passengerCapacity = passengerCapacity;
    }

}
