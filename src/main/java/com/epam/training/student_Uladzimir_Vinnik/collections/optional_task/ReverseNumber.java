package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


/**
 * Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
 */
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

    private static ArrayDeque<Integer> createDeque(String number) {
        ArrayDeque<Integer> stek = new ArrayDeque<>();
       for (String letter : number.split("")){
            stek.push(Integer.valueOf(letter));
       }
        return stek;
    }

    private static void printReversDeque(ArrayDeque<Integer> deque) {
        while (!deque.isEmpty()){
            System.out.print(deque.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        printReversDeque(createDeque(getNumberFromConsole()));
    }
}
