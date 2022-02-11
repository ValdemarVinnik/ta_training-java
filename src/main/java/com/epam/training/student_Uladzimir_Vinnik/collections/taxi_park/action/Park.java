package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Park {
    private List<Transport> taxiPark;

    public Park(List<Transport> taxiPark) {
        this.taxiPark = taxiPark;
    }

    public Park() {
        this.taxiPark = new ArrayList<>();
    }

    public Park(Transport... transport) {
        this(Arrays.asList(transport));
    }

    public List<Transport> getAllPark() {
        return taxiPark;
    }

    public void printCars(List<Transport> cars) {
        cars.forEach(System.out::println);
    }

    public int getCostOfAllPark() {
        return (int) taxiPark.stream().map(Transport::getCost).count();
    }

    public List<Transport> getTaxiParkBySpeed(int minSpeed, int maxSpeed) {
        return taxiPark.stream().filter((t) -> t.getMaxSpeed() >= minSpeed && t.getMaxSpeed() <= maxSpeed)
                .collect(Collectors.toList());
    }

    public List<Transport> getTaxiParkByFuelConsumption(int minFuelConsumption, int maxFuelConsumption) {
        return taxiPark.stream().filter((t) -> t.getFuelConsumptionForHundred() >= minFuelConsumption &&
                t.getFuelConsumptionForHundred() <= maxFuelConsumption)
                .collect(Collectors.toList());
    }

    public void sortingTaxiParkByFuelConsumption() {
        taxiPark = taxiPark.stream().sorted((t1, t2) -> (int) (t1.getFuelConsumptionForHundred() - t2.getFuelConsumptionForHundred()))
                .collect(Collectors.toList());
    }

}
