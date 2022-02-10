package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action.exception.DataSubmissionException;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.CargoTaxi;
import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.Transport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloaderParkFromFile {
    private static final String FILE_PATH = "src/test/resources/TaxiPark.txt";

    private static List<String> getDataFromTheFile(String filePath) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
            return list;
        }
    }

    public static List<Transport> getTaxiFromFile(){
        return null;
    }

    private static Transport createTransport(String[] dataArray){
        String typeOfTransport = dataArray[5].trim().toUpperCase();
        switch (typeOfTransport){
            case ("SEDAN"):return null;
            case ("CARGOBUS"):return null;
            case ("PASSENGER_BUS"):return null;
            case ("TRACK"):return null;
            case ("MINIVAN"):return null;
            default: return null;
        }
    }

    private static Transport createCargoTransport(String[] dataArray){
        String name = dataArray[0].trim();
        int cost;
        try {
            cost = Integer.parseInt(dataArray[1]);
        }catch (Exception e){
            throw new DataSubmissionException("Cost information is incorrect...");
        }
        return null;
    }

    private static Transport getDeserializableCar(String data){
        if (data == null){return null;}
        String[] dataArray = data.split(",");
        if (dataArray.length != 7) {return null;}


        return null;
    }

}
