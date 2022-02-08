package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
