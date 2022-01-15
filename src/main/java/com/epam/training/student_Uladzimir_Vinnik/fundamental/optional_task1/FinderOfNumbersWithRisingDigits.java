package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 *   Найти число, цифры в котором идут в строгом порядке возрастания.
 *   Если таких чисел несколько, найти первое из них.
 */
public class FinderOfNumbersWithRisingDigits {
    public static void run() throws IOException {
        printMessage("How many digits do you want to enter? :");

        String stringNumber = getStringFromConsole();

        while (!checkForValidity(stringNumber)) {
            printMessage("try again...:");
            stringNumber = getStringFromConsole();
        }

        int[] numbersArray = collectNumbers(Integer.parseInt(stringNumber));

        printMessage("\nThe number with rising digits  :");
        printMessage(getNumberWithRisingDigits(numbersArray));

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

    private static String getNumberWithRisingDigits(int[] array) {
        for (int each : array) {
            if (isRisingDigitsNumber(each)) {
                return String.valueOf(each);
            }
        }
        return new NotRisingDigitsNumber().toString();
    }

    private static boolean isRisingDigitsNumber(int number) {
        if (number / 10 == 0) return false;

        int currentDigit = number % 10;
        number = number / 10;
        while (number > 0) {
            if (currentDigit <= number % 10) {
                return false;
            }
            currentDigit = number % 10;
            number = number / 10;
        }
        return true;
    }

    private static class NotRisingDigitsNumber extends Exception {

        @Override
        public String toString() {
            return "No ascending number found...";
        }
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
