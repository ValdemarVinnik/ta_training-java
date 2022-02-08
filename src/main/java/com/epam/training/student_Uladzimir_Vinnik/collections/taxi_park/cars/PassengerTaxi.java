package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.TypeOfTransport;

import java.util.Objects;

public class PassengerTaxi extends Transport {
    private TypeOfTransport type;
    private int passengerCapacity;

    public PassengerTaxi(int cost, String registrationNumber, int maxSpeed, double fuelConsumptionForHundred,
                         TypeOfTransport type, int passengerCapacity) {
        super(cost, registrationNumber, maxSpeed, fuelConsumptionForHundred);
        this.type = type;
        this.passengerCapacity = passengerCapacity;
    }

    public TypeOfTransport getType() {
        return type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "type=" + type +
                ", passengerCapacity=" + passengerCapacity +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerTaxi)) return false;
        if (!super.equals(o)) return false;
        PassengerTaxi that = (PassengerTaxi) o;
        return getPassengerCapacity() == that.getPassengerCapacity() &&
                getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType(), getPassengerCapacity());
    }
}
