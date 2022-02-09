package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.TypeOfTransport;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.PassengerTaxi;
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

    public Park(){
        this.taxiPark = new ArrayList<>();
    }

    public Park(Transport...transport){
        this(Arrays.asList(transport));
    }

    public void printCars(List<Transport> cars){
        cars.stream().forEach(System.out::println);
    }

    public int getCostOfAllPark(){
       // if (taxiPark.size() == 0)
        return (int)taxiPark.stream().map(Transport::getCost).count();
    }
    public List<Transport> getTaxiParkBySpeed(int minSpeed, int maxSpeed){
       return taxiPark.stream().filter((t)-> t.getMaxSpeed() >= minSpeed && t.getMaxSpeed() <= maxSpeed)
               .collect(Collectors.toList());
    }

    public List<Transport> getTaxiParkByFuelConsumption(int minSpeed, int maxSpeed){
        return taxiPark.stream().filter((t)-> t.getFuelConsumptionForHundred() >= minSpeed && t.getFuelConsumptionForHundred() <= maxSpeed)
                .collect(Collectors.toList());
    }

    public void sortingTaxiParkByFuelConsumption(){
       taxiPark = taxiPark.stream().sorted((t1,t2)-> (int) (t1.getFuelConsumptionForHundred()-t2.getFuelConsumptionForHundred()))
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Park park = new Park();
//        Park park = new Park(new PassengerTaxi(20_000, "1234 AO-2", 220,
//                5.5, TypeOfTransport.SEDAN, 3));
        park.taxiPark.add(new PassengerTaxi("Skoda",20_000, "1234 AO-2", 220,
                5.5, TypeOfTransport.SEDAN, 3));
        park.printCars(park.taxiPark);
    }
}
