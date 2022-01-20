package com.epam.training.student_Uladzimir_Vinnik.fundamental.matrix_processor.impl;


import com.epam.training.student_Uladzimir_Vinnik.fundamental.matrix_processor.IMatrixProcessor;
import com.epam.training.student_Uladzimir_Vinnik.fundamental.matrix_processor.exception.MatrixProcessorException;
import org.apache.commons.math3.util.Precision;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 * <p>
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 * <p>
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 */
public class MatrixProcessor implements IMatrixProcessor {

    /**
     * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
     * Ex.:
     * |1 2|			|1 3 5|
     * |3 4|   ====>	|2 4 6|
     * |5 6|
     *
     * @param matrix - matrix for transposition
     * @return the transposed matrix
     */
    @Override
    public double[][] transpose(double[][] matrix) {
        if (matrix == null ){
            throw new MatrixProcessorException("Matrix is null");
        }
        double[][] newMatrix = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    /**
     * The method flips the matrix clockwise.
     * Ex.:
     * * |1 2|			|5 3 1|
     * * |3 4|   ====>	|6 4 2|
     * * |5 6|
     *
     * @param matrix - rotation matrix
     * @return rotated matrix
     */
    @Override
    public double[][] turnClockwise(double[][] matrix) {
        if (matrix == null){
            throw new MatrixProcessorException("Matrix is null");
        }
        if (matrix.length == 0) {
            throw new MatrixProcessorException("Matrix length is 0");
        }

        if (matrix.length >= 10 || matrix[0].length >= 10) {
            throw new MatrixProcessorException("Matrix is wrong");
        }

        double[][] newMatrix = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix[matrix.length - (j + 1)][i];
            }
        }
        return newMatrix;
    }

    /**
     * This method multiplies matrix firstMatrix by matrix secondMatrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
     *
     * @param firstMatrix  - first matrix to multiply
     * @param secondMatrix - second matrix to multiply
     * @return result matrix
     */
    @Override
    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix == null || secondMatrix == null){
            throw new MatrixProcessorException("Matrix is null");
        }
        if (firstMatrix.length == 0 || secondMatrix.length == 0) {
            throw new MatrixProcessorException("Matrix length is 0");
        }

        if (firstMatrix.length >= 10 || firstMatrix[0].length >= 10 ||
                secondMatrix.length >= 10 || secondMatrix[0].length >= 10) {
            throw new MatrixProcessorException("Matrix is wrong");
        }

        if (firstMatrix[0].length != secondMatrix.length) {
            throw new MatrixProcessorException("Matrices are wrong...");
        }

        double[][] newMatrix = new double[firstMatrix[0].length][secondMatrix.length];
        double[][] secondTransposedMatrix = transpose(secondMatrix);

        for (int i = 0; i < newMatrix[0].length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                double result = 0.0;

                for (int k = 0; k < firstMatrix.length; k++) {
                    result += firstMatrix[i][k] * secondTransposedMatrix[j][k];
                }
                newMatrix[i][j] = Precision.round(result,3);
            }
        }
        return newMatrix;
    }

    /**
     * This method returns the inverse of the matrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Invertible_matrix}
     *
     * @param matrix - input matrix
     * @return inverse matrix for input matrix
     */
    @Override
    public double[][] getInverseMatrix(double[][] matrix) {
        if (matrix == null){
            throw new MatrixProcessorException("Matrix is null");
        }

        if (matrix.length < 2) {
            throw new MatrixProcessorException("Matrix is wrong");
        }

        if (matrix.length != matrix[0].length) {
            throw new MatrixProcessorException("Matrix isn't square");
        }

        double determinant = getMatrixDeterminant(matrix);
        if (determinant == 0) {
            throw new MatrixProcessorException("This matrix hasn't got inverse matrix");
        }
        double[][] inverseMatrix = new double[matrix.length][matrix.length];

        for (int i = 0; i < inverseMatrix.length; i++) {
            for (int j = 0; j < inverseMatrix.length; j++) {

                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    inverseMatrix[i][j] = getMatrixDeterminant(getMinor(matrix, i, j));
                } else {
                    inverseMatrix[i][j] = -getMatrixDeterminant(getMinor(matrix, i, j));
                }
            }
        }

        for (int i = 0; i < inverseMatrix.length; i++) {
            for (int j = 0; j < inverseMatrix.length; j++) {
                inverseMatrix[i][j] = Precision.round(inverseMatrix[i][j] /determinant,3);
            }
        }
        return transpose(inverseMatrix);
    }

    /**
     * This method returns the determinant of the matrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Determinant}
     *
     * @param matrix - input matrix
     * @return determinant of input matrix
     */
    @Override
    public double getMatrixDeterminant(double[][] matrix) {
        if (matrix == null){
            throw new MatrixProcessorException("Matrix is null");
        }

        if (matrix.length == 0) {
            throw new MatrixProcessorException("Matrix length is 0");
        }

        if (matrix.length != matrix[0].length) {
            throw new MatrixProcessorException("Matrix isn't square");
        }

        if (matrix.length == 1) {
            return Precision.round(matrix[0][0], 3);
        }

        double determinant = 0;

        for (int i = 0; i < matrix[0].length; i++) {

            if (i % 2 == 0) {
                determinant += matrix[0][i] * getMatrixDeterminant(getMinor(matrix,0, i));
            } else {
                determinant += -matrix[0][i] * getMatrixDeterminant(getMinor(matrix,0, i));
            }
        }
        return Precision.round(determinant, 3);
    }

    private double[][] getMinor(double[][] matrix, int row, int column) {
        double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
        int newI;
        int newJ = 0;

        for (int i = 0; i < matrix.length; i++) {
            newI = 0;

            if (i == row) {
                continue;
            }

            for (int j = 0; j < matrix.length; j++) {
                if (j == column) {
                    continue;
                }

                newMatrix[newI][newJ] = matrix[i][j];
                newI++;
            }
            newJ++;
        }
        return newMatrix;
    }

    public void printMatrix(double[][] matrix) {

        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print((String.format("%s \t", aDouble)));
            }
            System.out.print("\n");
        }
    }


}
