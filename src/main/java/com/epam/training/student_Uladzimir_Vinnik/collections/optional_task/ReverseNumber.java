package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReverseNumber {

    private static String getNumberFromConsole() throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String number;
            do {
                System.out.println("Insert the number...");
                number = bufferedReader.readLine();
            } while (!isANumber(number));
            return number;
        }
    }

    private static boolean isANumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static ArrayDeque<String> createDeque(String number) {

        return number.lines().collect(Collectors.toCollection(ArrayDeque::new));
    }

    private  static void printReversDeque(ArrayDeque<String> deque){
        deque.stream().forEach(System.out::print);
    }

    public static void main(String[] args) throws IOException {
        printReversDeque(createDeque(getNumberFromConsole()));
    }
}
