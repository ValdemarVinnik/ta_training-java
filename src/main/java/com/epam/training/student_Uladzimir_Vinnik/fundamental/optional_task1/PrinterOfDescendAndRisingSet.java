package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Вывести числа в порядке возрастания (убывания) значений их длины.**/

public class PrinterOfDescendAndRisingSet {

    public static void run() throws IOException {
        printMessage("How many digits do you want to enter? :");

        String stringNumber = getStringFromConsole();

        while (!checkForValidity(stringNumber)) {
            printMessage("try again...:");
            stringNumber = getStringFromConsole();
        }

        int[] numbersArray = collectNumbers(Integer.parseInt(stringNumber));

        printMessage("\nascending print :");
        printArray(upSortingArray(numbersArray));

        printMessage("\ndescending print :");
        printArray(downSortingArray(numbersArray));
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

    private static int[] upSortingArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {

                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
        return array;
    }

    private static int[] downSortingArray(int[] array) {

        for (int i = 0; i <= array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {

                    array[j] = array[j] + array[j + 1];
                    array[j + 1] = array[j] - array[j + 1];
                    array[j] = array[j] - array[j + 1];
                }
            }
        }
        return array;
    }

    private static void printArray(int[] array) {

        for (int each : array) {
            printMessage(String.format("%d ", each));
        }

    }

    public static void main(String[] args) throws IOException {
        run();
    }

}
