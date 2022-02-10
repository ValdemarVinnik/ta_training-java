package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.TypeOfTransport;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action.exception.DataSubmissionException;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.CargoTaxi;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.PassengerTaxi;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.Transport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloaderParkFromFile {
    private static final String FILE_PATH = "src/test/resources/TaxiPark.txt";
    private static List<Transport> list = new ArrayList<>();

    private static void getDataFromTheFile(String filePath) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            Transport transport;
            while (bufferedReader.ready()) {
                transport = getDeserializableCar(bufferedReader.readLine());
                if (transport != null){list.add(transport);}
            }

        }
    }

    public static List<Transport> getTaxiFromFile() throws IOException {
        getDataFromTheFile(FILE_PATH);
        return list;
    }

    private static Transport createTransport(String[] dataArray){
        String typeOfTransport = dataArray[5].trim().toUpperCase();
        switch (typeOfTransport){
            case ("SEDAN"):
            case ("PASSENGER_BUS"):
            case ("MINIVAN"):
                return createPassengerTransport(dataArray);
            case ("CARGO_BUS"):
            case ("TRUCK"):
                return createCargoTransport(dataArray);
            default: return null;
        }
    }

    private static Transport createCargoTransport(String[] dataArray){
        String name = dataArray[0].trim();

        int cost;
        try {
            cost = Integer.parseInt(dataArray[1].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Cost information is incorrect...");
        }

        String regNumber = dataArray[2].trim();

        int maxSpeed;
        try {
            maxSpeed = Integer.parseInt(dataArray[3].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Registration number information is incorrect...");
        }

        double fuelConsumption;
        try {
            fuelConsumption = Double.parseDouble(dataArray[4].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Fuel consumption information is incorrect...");
        }

        TypeOfTransport typ;
        try {
            typ = TypeOfTransport.valueOf(dataArray[5].trim().toUpperCase());
        }catch (Exception e){
            throw new DataSubmissionException("Type of transport information is incorrect...");
        }

        int capacity;
        try {
            capacity = Integer.parseInt(dataArray[6].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Capacity information is incorrect...");
        }

        return new CargoTaxi(name, cost, regNumber, maxSpeed, fuelConsumption, typ, capacity);
    }

    private static Transport createPassengerTransport(String[] dataArray){
        String name = dataArray[0].trim();

        int cost;
        try {
            cost = Integer.parseInt(dataArray[1].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Cost information is incorrect...");
        }

        String regNumber = dataArray[2].trim();

        int maxSpeed;
        try {
            maxSpeed = Integer.parseInt(dataArray[3].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Registration number information is incorrect...");
        }

        double fuelConsumption;
        try {
            fuelConsumption = Double.parseDouble(dataArray[4].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Fuel consumption information is incorrect...");
        }

        TypeOfTransport typ;
        try {
            typ = TypeOfTransport.valueOf(dataArray[5].trim().toUpperCase());
        }catch (Exception e){
            throw new DataSubmissionException("Type of transport information is incorrect...");
        }

        int capacity;
        try {
            capacity = Integer.parseInt(dataArray[6].trim());
        }catch (Exception e){
            throw new DataSubmissionException("Capacity information is incorrect...");
        }

        return new PassengerTaxi(name, cost, regNumber, maxSpeed, fuelConsumption, typ, capacity);
    }

    private static Transport getDeserializableCar(String data){
        if (data == null){return null;}
        String[] dataArray = data.split(",");
        if (dataArray.length != 7) {return null;}

        return createTransport(dataArray);
    }

    public static void main(String[] args) throws IOException {
        List<Transport> list = getTaxiFromFile();

        //list.stream().forEach(System.out::println);

        Park park = new Park(list);
        park.sortingTaxiParkByFuelConsumption();
        park.printCars(park.getAllPark());
    }

}
