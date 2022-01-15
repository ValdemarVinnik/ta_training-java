package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Найти число, в котором количество различных цифр минимально.
 * Если таких чисел несколько, найти первое из них.
 */
public class SearcherOfMinimalDifferentDigitsInNumbers {

    public static void run() throws IOException {
        printMessage("How many digits do you want to enter? :");

        String stringNumber = getStringFromConsole();

        while (!checkForValidity(stringNumber)) {
            printMessage("try again...:");
            stringNumber = getStringFromConsole();
        }

        int[] numbersArray = collectNumbers(Integer.parseInt(stringNumber));

        printMessage("\nA number with a minimum number of distinct digits  :");
        String resultMessage = String.valueOf(getNumberWithMinimalDifferentDigits(numbersArray,getMinimalDifferentDigits(numbersArray)));
        printMessage(resultMessage);

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

    private static int countOfDifferentDigits(int number) {
        int numberForCheck;
        int counterOfDifferent = 0;

        for (int i = 0; i < 10; i++) {

            numberForCheck = number;

            while (numberForCheck > 0) {

                if (i == numberForCheck % 10) {
                    counterOfDifferent++;
                    break;
                }
                numberForCheck = numberForCheck / 10;
            }

        }
        return counterOfDifferent;
    }

    private static int getMinimalDifferentDigits(int[] array) {
        int minimalDifferentDigits = countOfDifferentDigits(array[0]);

        for (int each : array) {
            if (minimalDifferentDigits > countOfDifferentDigits(each)) {
                minimalDifferentDigits = countOfDifferentDigits(each);
            }

        }
        return minimalDifferentDigits;
    }

    private static int getNumberWithMinimalDifferentDigits(int[] array, int minimal){
        for (int each: array){
            if (countOfDifferentDigits(each) == minimal){
                return each;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        run();
    }

}
