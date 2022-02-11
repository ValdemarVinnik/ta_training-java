package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action;

import com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.cars.Transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class ApplicationTaxiPark {
    static private Park park;

    static {
        List<Transport> list = null;
        try {
            list = DownloaderParkFromFile.getTaxiFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        park = new Park(list);
    }

    private static String getDataFromConsole() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        return buffer.readLine();
    }

    private static void cleanConsole() {
        System.out.println("\n\n\n");
    }

    private static <T> void printMessage(T message) {
        System.out.println(message);
    }

    private static void printStartMenu() {
        System.out.println("---------------------------TAXI_PARK------------------------------\n\n" +
                " You've got a taxi park. Choose an action with him (select a number).:\n\n" +
                "1. Print all park.\n" +
                "2. Get cost of all park.\n" +
                "3. Get a taxi park for a given range of speed.\n" +
                "4. Get a taxi park by fuel consumption.\n" +
                "5. Get a taxi park for a given range of fuel consumption.\n" +
                "0. EXIT");
    }

    private static boolean isANumberFromRange(String strNumber, int range) {
        try {
            int number = Integer.parseInt(strNumber.trim());
            return number >= 0 && number <= range;

        } catch (Exception e) {
            return false;
        }
    }

    private static boolean chooseMethod(String stringNumber) throws IOException {

        switch (stringNumber.trim()) {
            case ("1"):
                park.printCars(park.getAllPark());
                return true;
            case ("2"):
                printMessage(park.getCostOfAllPark());
                return true;
            case ("3"):
                callGetTaxiParkBySpeed();
                return true;
            case ("4"):
                park.sortingTaxiParkByFuelConsumption();
                park.printCars(park.getAllPark());
                return true;
            case ("5"):
                callGetTaxiParkByFuelConsumption();
                return true;
            case ("0"):
            default:
                return false;
        }
    }

    private static void callGetTaxiParkBySpeed() throws IOException {
        cleanConsole();
        System.out.println("Enter minimum speed");

        String minSpeed = getDataFromConsole();
        while (!isANumberFromRange(minSpeed, 300)) {
            minSpeed = getDataFromConsole();
        }

        System.out.println("Enter maximum speed");
        String maxSpeed = getDataFromConsole();
        while (!isANumberFromRange(maxSpeed, 300)) {
            maxSpeed = getDataFromConsole();
        }

        park.printCars(park.getTaxiParkBySpeed(Integer.parseInt(minSpeed), Integer.parseInt(maxSpeed)));
    }

    private static void callGetTaxiParkByFuelConsumption() throws IOException {
        cleanConsole();
        System.out.println("Enter minimum consumption");

        String minConsumption = getDataFromConsole();
        while (!isANumberFromRange(minConsumption, 100)) {
            minConsumption = getDataFromConsole();
        }
        System.out.println("Enter maximum consumption");

        String maxConsumption = getDataFromConsole();
        while (!isANumberFromRange(maxConsumption, 300)) {
            maxConsumption = getDataFromConsole();
        }

        park.printCars(park.getTaxiParkByFuelConsumption(Integer.parseInt(minConsumption),
                Integer.parseInt(maxConsumption)));
    }

    public static void run() throws IOException {
        boolean isLive = true;

        while (isLive) {
            cleanConsole();
            printStartMenu();

            String stringNumber = getDataFromConsole();
            if (isANumberFromRange(stringNumber, 5)) {
                isLive = chooseMethod(stringNumber);
            }
            cleanConsole();
        }
    }

    public static void main(String[] args) throws IOException {
        run();
    }


}
