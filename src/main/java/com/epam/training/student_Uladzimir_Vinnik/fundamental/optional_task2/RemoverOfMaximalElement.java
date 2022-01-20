package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в
 * интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
 * Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие.
 */
public class RemoverOfMaximalElement {

    private static void run() throws IOException {
        printMessage("Enter size of matrix...:");

        String stringMatrixSize = getStringFromConsole();

        while (!checkForValidityForMatrixSize(stringMatrixSize)) {
            printMessage("try again...:");
            stringMatrixSize = getStringFromConsole();
        }

        printMessage("Set the values of matrix elements in the range\n" +
                " of values from -M to M    M=");
        String stringBoundaryOfRang = getStringFromConsole();

        while (!checkForValidityForBoundary(stringBoundaryOfRang)) {
            printMessage("try again...:");
            stringBoundaryOfRang = getStringFromConsole();
        }

        int[][] matrix = createMatrix(Integer.parseInt(stringMatrixSize),
                Integer.parseInt(stringBoundaryOfRang));

        printMatrix(matrix);

        int maxElement = getMaximalElementInMatrix(matrix);

        printMessage(" Matrix after removing maximal element\n");
        printMatrix(getMatrixWithoutMaxElement(matrix,maxElement));

    }

    private static void printMessage(String message) {
        System.out.print(message);
    }

    private static String getStringFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    private static boolean checkForValidityForBoundary(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return (number > 0);
    }

    private static boolean checkForValidityForMatrixSize(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return (number > 0);
    }

    private static int[][] createMatrix(int size, int boundaryOfRange) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = createNumber(boundaryOfRange);
            }
        }

        return matrix;
    }

    private static int createNumber(int boundary) {
        Random random = new Random();
        return random.nextInt((boundary) * 2) - boundary;
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                printMessage(String.format("%d   ", matrix[j][i]));
            }
            printMessage("\n\n");
        }

    }

    private static int getMaximalElementInMatrix(int[][] matrix) {
        int maxElement = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (maxElement < matrix[j][i]) {
                    maxElement = matrix[j][i];
                }
            }

        }
        return maxElement;
    }

    private static int[][] getRebuildingMatrix(int[][] matrix, int coordinateJ, int coordinateI) {
        int[][] newMatrix = new int[matrix.length - 1][matrix.length - 1];
        int newI;
        int newJ = 0;

        for (int i = 0; i < matrix.length; i++) {
            newI = 0;

            if (i == coordinateI) {
                continue;
            }

            for (int j = 0; j < matrix.length; j++) {
                if (j == coordinateJ){
                    continue;
                }

                newMatrix[newI][newJ] = matrix[j][i];
                newI++;
            }
            newJ++;
        }
        return newMatrix;
    }

    private static int[][] getMatrixWithoutMaxElement(int[][] matrix, int maxElement){

        while (isContainsInMatrix(matrix,maxElement)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (maxElement == matrix[j][i]) {
                        matrix = getRebuildingMatrix(matrix, j, i);
                        break;
                    }
                }
            }
        }
        return matrix;
    }

    private static boolean isContainsInMatrix(int[][] matrix, int maxElement){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (maxElement == matrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
