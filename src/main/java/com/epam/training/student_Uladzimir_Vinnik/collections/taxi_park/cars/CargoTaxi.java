package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.TypeOfTransport;

import java.util.Objects;

public class CargoTaxi extends Transport {
    private TypeOfTransport type;
    private int cargoCapacity;

    public CargoTaxi(int cost, String registrationNumber, int maxSpeed, double fuelConsumptionForHundred,
                     TypeOfTransport type,int cargoCapacity) {
        super(cost, registrationNumber, maxSpeed, fuelConsumptionForHundred);
        this.type = type;
        this.cargoCapacity = cargoCapacity;
    }

    public TypeOfTransport getType() {
        return type;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "type=" + type +
                ", cargoCapacity=" + cargoCapacity +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoTaxi)) return false;
        if (!super.equals(o)) return false;
        CargoTaxi cargoTaxi = (CargoTaxi) o;
        return getCargoCapacity() == cargoTaxi.getCargoCapacity() &&
                getType() == cargoTaxi.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType(), getCargoCapacity());
    }
}
