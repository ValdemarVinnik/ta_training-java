package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Найти количество чисел, содержащих только четные цифры,
 * а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
 * ***/
public class FinderWithAnEvenDigitsInTheNumber {

    public static void run() throws IOException {
        printMessage("How many digits do you want to enter? :");

        String stringNumber = getStringFromConsole();

        while (!checkForValidity(stringNumber)) {
            printMessage("try again...:");
            stringNumber = getStringFromConsole();
        }

        int[] numbersArray = collectNumbers(Integer.parseInt(stringNumber));

        printMessage("\nCount of numbers with even digits  :");
        printMessage(String.valueOf(getCountOfNumbersWithEvenDigits(numbersArray)));

        printMessage("\nCount of numbers with same count even and odd  :");
        printMessage(String.valueOf(getCountOfNumbersWithSameCountEvenAndOdd(numbersArray)));

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

    private static int getCountOfNumbersWithEvenDigits(int[] array) {
        int countOfNumbers = 0;
        for (int each : array) {
            if (containOnlyEvenNumbers(each)) {
                countOfNumbers++;
            }
        }
        return countOfNumbers;
    }

    private static int getCountOfNumbersWithSameCountEvenAndOdd(int[] array) {
        int countOfNumbers = 0;
        for (int each : array) {
            if (containsTheSameCountEvenAndOdd(each)) {
                countOfNumbers++;
            }
        }
        return countOfNumbers;
    }


    private static boolean containOnlyEvenNumbers(int number) {

        while (number > 0) {
            if ((number % 10) % 2 != 0) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    private static boolean containsTheSameCountEvenAndOdd(int number) {
        int countEven = 0;
        int countOdd = 0;

        while (number > 0) {
            if ((number % 10) % 2 != 0) {
                countEven++;
            } else {
                countOdd++;
            }
            number = number / 10;
        }
        return (countEven == countOdd);
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
