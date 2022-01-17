package com.epam.training.student_Uladzimir_Vinnik.fundamental.optional_task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Ввести с консоли n - размерность матрицы a [n] [n].
 * Задать значения элементов матрицы в интервале значений от -M до M
 * с помощью генератора случайных чисел (класс Random).
 * Упорядочить строки (столбцы) матрицы в порядке возрастания значений
 * элементов k-го столбца (строки). *
 */
public class MatrixSorter {


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

        printMessage("Sorting by column.....\n");
        printMessage("\n");
        printMatrix(sortColumn(matrix));

        printMessage("\n");
        printMessage("Sorting by line.....\n");
        printMessage("\n");
        printMatrix(sortLine(matrix));
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

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[j][i] = createNumber(boundaryOfRange);
            }
        }

        return matrix;
    }

    private static int createNumber(int boundary) {
        Random random = new Random();
        return random.nextInt((boundary+1) * 2) - boundary;
    }

    private static void printMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                printMessage(String.format("%d   ",matrix[j][i]));
            }
            printMessage("\n\n");
        }

    }

    private static int[][] getCloneMatrix(int[][] matrix){
        int[][] clone = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                clone[j][i] = matrix[j][i];
            }
        }
        return clone;
    }

    private static int[][] sortColumn(int[][] matrix){
        int[][] sortingMatrix = getCloneMatrix(matrix);

        for (int i = 0; i <sortingMatrix.length; i++){

            for(int k = 0; k <= sortingMatrix.length; k++){
                for(int j = 0; j < sortingMatrix.length-1; j++){

                    if (sortingMatrix[i][j] > sortingMatrix[i][j+1]){

                        sortingMatrix[i][j] = sortingMatrix[i][j] + sortingMatrix[i][j+1];
                        sortingMatrix[i][j+1] = sortingMatrix[i][j] - sortingMatrix[i][j+1];
                        sortingMatrix[i][j] = sortingMatrix[i][j] - sortingMatrix[i][j+1];
                    }
                }
            }
        }
        return sortingMatrix;
    }

    private static int[][] sortLine(int[][] matrix){
        int[][] sortingMatrix = getCloneMatrix(matrix);

        for (int j = 0; j < sortingMatrix.length; j++){

            for(int k = 0; k <= sortingMatrix.length; k++){
                for(int i = 0; i < sortingMatrix.length-1; i++){

                    if (sortingMatrix[i][j] > sortingMatrix[i+1][j]){

                        sortingMatrix[i][j] = sortingMatrix[i][j] + sortingMatrix[i+1][j];
                        sortingMatrix[i+1][j] = sortingMatrix[i][j] - sortingMatrix[i+1][j];
                        sortingMatrix[i][j] = sortingMatrix[i][j] - sortingMatrix[i+1][j];
                    }
                }
            }
        }
        return sortingMatrix;
    }


    public static void main(String[] args) throws IOException {
        run();

    }
}
