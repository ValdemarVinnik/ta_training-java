package main_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterOfMonths {

    public static void run() throws IOException {
        printMessage("enter an integer from 1 to 12 :");
        String stringFromConsole = getStringFromConsole();

        while (!checkForValidity(stringFromConsole)) {
            printMessage("try again...");
            stringFromConsole = getStringFromConsole();
        }
        chooseMonths(stringFromConsole);
    }

    private static String getStringFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static boolean checkForValidity(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return (number > 0 && number <= 12);
    }

    private static void chooseMonths(String numberOfMonth){
        switch (Integer.parseInt(numberOfMonth)){
            case 1 : printMessage("January");
                break;
            case 2 : printMessage("February");
                break;
            case 3 : printMessage("March");
                break;
            case 4 : printMessage("April");
                break;
            case 5 : printMessage("May");
                break;
            case 6 : printMessage("June");
                break;
            case 7 : printMessage("July");
                break;
            case 8 : printMessage("August");
                break;
            case 9 : printMessage("September");
                break;
            case 10 : printMessage("October");
                break;
            case 11 : printMessage("November");
                break;
            case 12 : printMessage("December");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}

