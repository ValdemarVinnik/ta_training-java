package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Park {
   private List<? extends Transport> taxiPark;

    public Park(List<? extends Transport> taxiPark) {
        this.taxiPark = taxiPark;
    }

    public Park(){
        this.taxiPark = new ArrayList<>();
    }

    public Park(Transport...transport){
        new Park(Arrays.asList(transport));
    }

    public void printCars(List<? extends Transport> cars){
        cars.stream().forEach(System.out::println);
    }

    public int getCostOfAllPark(){
       // if (taxiPark.size() == 0)
        return (int)taxiPark.stream().map(Transport::getCost).count();
    }
    public List<? extends Transport> getTaxiParkBySpeed(int minSpeed, int maxSpeed){
       return taxiPark.stream().filter((t)-> t.getMaxSpeed() >= minSpeed && t.getMaxSpeed() <= maxSpeed)
               .collect(Collectors.toList());
    }

    public List<? extends Transport> getTaxiParkByFuelConsumption(int minSpeed, int maxSpeed){
        return taxiPark.stream().filter((t)-> t.getFuelConsumptionForHundred() >= minSpeed && t.getFuelConsumptionForHundred() <= maxSpeed)
                .collect(Collectors.toList());
    }

    public void sortingTaxiParkByFuelConsumption(){
       taxiPark = taxiPark.stream().sorted((t1,t2)-> (int) (t1.getFuelConsumptionForHundred()-t2.getFuelConsumptionForHundred()))
               .collect(Collectors.toList());
    }

}
