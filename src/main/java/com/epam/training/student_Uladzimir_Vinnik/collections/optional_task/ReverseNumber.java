package com.epam.training.student_Uladzimir_Vinnik.collections.optional_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Stack;


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

    private static Stack<Integer> createDeque(String number) {
        Stack<Integer> stack = new Stack<>();
       for (String letter : number.split("")){
            stack.push(Integer.valueOf(letter));
       }
        return stack;
    }

    private static void printReversDeque(Stack<Integer> stack) {
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        printReversDeque(createDeque(getNumberFromConsole()));
    }
}
