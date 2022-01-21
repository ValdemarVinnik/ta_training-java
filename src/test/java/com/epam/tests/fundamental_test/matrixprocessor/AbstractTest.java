package com.epam.tests.fundamental_test.matrixprocessor;


import com.epam.training.student_Uladzimir_Vinnik.fundamental.matrix_processor.IMatrixProcessor;
import com.epam.training.student_Uladzimir_Vinnik.fundamental.matrix_processor.impl.MatrixProcessor;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

    protected IMatrixProcessor testClass;

    @BeforeEach
    void setUp() {
        testClass = new MatrixProcessor();
    }

    protected String formMessage(double[][] actualMatrix, double[][] expectedMatrix) {
        return String.format("Wrong result of method \nactualMatrix : \n%s \nexpectedMatrix \n%s)",
                printMatrix(actualMatrix), printMatrix(expectedMatrix));
    }

    protected String formMessage(double actualDeterminant, double expectedDeterminant) {
        return String.format("Wrong result of method \nactualDeterminant : \n%s \nexpectedDeterminant \n%s)",
                actualDeterminant, expectedDeterminant);
    }

    private String printMatrix(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                sb.append(String.format("%s \t", aDouble));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
