package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongAndShortNumber {

    public static void run() throws IOException {
        printMessage("How many digits do you want to enter? :");

        String stringNumber = getStringFromConsole();

        while (!checkForValidity(stringNumber)) {
            printMessage("try again...:");
            stringNumber = getStringFromConsole();
        }

        int[] numbersArray = collectNumbers(Integer.parseInt(stringNumber));

        printMessage(String.format("Shorter number is : %d\n",getShorterNumber(numbersArray)));
        printMessage(String.format("Longest number is : %d",getLongestNumber(numbersArray)));

    }

    private static int[] collectNumbers(int arrayLength) throws IOException {
        int[] numbers = new int[arrayLength];
        for (int i = 0; i < numbers.length; i++) {

            printMessage("Enter a number: ");
            String numberFromConsole = getStringFromConsole();
            while (!checkForValidity(numberFromConsole)) {
                printMessage("try again...:");
                numberFromConsole = getStringFromConsole();
            }
            numbers[i] = Integer.parseInt(numberFromConsole);
        }
        return numbers;
    }

    private static void printMessage(String message) {
        System.out.print(message);
    }

    private static String getStringFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    private static boolean checkForValidity(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return (number > 0);
    }

    private static int getShorterNumber(int[] numbers){
        int shorter = numbers[0];
        for (int number : numbers) {

            if (shorter > number) shorter = number;

        }
        return shorter;
    }

    private static int getLongestNumber(int[] numbers){
        int longest = numbers[0];
        for (int number : numbers) {

            if (longest < number) longest = number;

        }
        return longest;
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
