package com.epam.training.student_Uladzimir_Vinnik.fundamental.main_task;

public class SumAndProductsArguments {

    private static boolean checkForValidity(String[] args) {
        try {
            for (String each : args) {
                Integer.parseInt(each);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static int getSumArguments(String[] args) {
        int sum = 0;

        for (String each : args) {
            sum = sum + Integer.parseInt(each);
        }
        return sum;
    }

    private static int getProductArguments(String[] args) {
        int product = 1;

        for (String each : args) {
            product = product * Integer.parseInt(each);
        }
        return product;
    }

    public static void main(String[] args) {

        if (args.length > 0) {

            if (!checkForValidity(args)) {
                printMessage("Malformed arguments");
                return;
            }

            printMessage(String.format("Sum of arguments = %d", getSumArguments(args)));
            printMessage(String.format("Product of arguments = %d", getProductArguments(args)));
        }
    }
}
