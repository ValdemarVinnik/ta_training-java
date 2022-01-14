package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вывести на консоль те числа,
 * длина которых меньше (больше) средней длины по всем числам, а также длину.
 **/

public class AboveOrBelowAveragePrinter {

    public static void run() throws IOException {
        printMessage("How many digits do you want to enter? :");

        String stringNumber = getStringFromConsole();

        while (!checkForValidity(stringNumber)) {
            printMessage("try again...:");
            stringNumber = getStringFromConsole();
        }

        int[] numbersArray = collectNumbers(Integer.parseInt(stringNumber));

        printMessage("\nThe numbers are longer then average  :");
        printNumbersLongerThenAverage(searchOfNumbersAverageLength(numbersArray), numbersArray);

        printMessage("\nThe numbers are shorter then average  :");
        printNumbersShortestThenAverage(searchOfNumbersAverageLength(numbersArray), numbersArray);
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

    private static int searchOfNumbersAverageLength(int[] array) {
        int sum = 0;
        for (int each : array) {
            sum = sum + counterOfLength(each);
        }
        System.out.println(sum / array.length);
        return sum / array.length;
    }

    private static int counterOfLength(int number) {
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    private static void printNumbersLongerThenAverage(int average, int[] array) {
        for (int each : array) {
            if (counterOfLength(each) >= average)
                printMessage(String.format("%d ", each));
        }
    }

    private static void printNumbersShortestThenAverage(int average, int[] array) {
        for (int each : array) {
            if (counterOfLength(each) < average)
                printMessage(String.format("%d ", each));
        }
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
