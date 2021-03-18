package matrixutility;


import matrixutility.exceptions.MatrixDimensionInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    private MatrixUtils matrixUtils;

    @BeforeEach
    void setUpMatrix() {
        matrixUtils = new MatrixUtilsImpl();
    }

    @Test
    void shouldThrowExceptionWhenTwoMatricesAreOfDifferentDimensionsWhileAdding() {
        int[][] matrix1 = {{1, 3, 1}, {1, 0, 0}};
        int[][] matrix2 = {{0, 5}, {7, 5}};
        Assertions.assertThrows(MatrixDimensionInvalidException.class, () -> matrixUtils.addMatrices(matrix1, matrix2));
    }

    @Test
    void whenTwoMatricesAreGivenAndAddedShouldBeEqualToResultantMatrix() {
        int[][] matrix1 = {{1, 3, 1}, {1, 0, 0}};
        int[][] matrix2 = {{0, 0, 5}, {7, 5, 0}};
        int[][] resultant = {{1, 3, 6}, {8, 5, 0}};
        Assertions.assertArrayEquals(resultant, matrixUtils.addMatrices(matrix1, matrix2));
    }

    @Test
    void whenTwoMatricesAreGivenAndScalarMultipliedShouldBeEqualToResultantMatrix() {
        int number = 2;
        int[][] matrix2 = {{1, 8, -3}, {4, -2, 5}};
        int[][] resultant = {{2, 16, -6}, {8, -4, 10}};
        Assertions.assertArrayEquals(resultant, matrixUtils.scalarMultiplyMatrices(number, matrix2));
    }

    @Test
    void whenMatrixIsTransposedShouldBeEqualToResultantMatrix() {
        int[][] matrix = {{1, 2, 3}, {0, -6, 7}};
        int[][] resultant = {{1, 0}, {2, -6}, {3, 7}};
        Assertions.assertArrayEquals(resultant, matrixUtils.transportMatrix(matrix));
    }

    @Test
    void shouldThrowExceptionWhenTwoMatricesAreOfInvalidDimensionsWhileMultiplying() {
        int[][] matrix1 = {{1, 3, 1}, {1, 0, 0}};
        int[][] matrix2 = {{0, 5}, {7, 5}};
        Assertions.assertThrows(MatrixDimensionInvalidException.class, () -> matrixUtils.multiplyMatrices(matrix1, matrix2));
    }

    @Test
    void whenTwoMatricesAreGivenAndMultipliedShouldBeEqualToResultantMatrix() {
        int[][] matrix1 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] matrix2 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] resultant = {{6, 6, 6}, {12, 12, 12}, {18, 18, 18}};
        Assertions.assertArrayEquals(resultant, matrixUtils.multiplyMatrices(matrix1, matrix2));
    }

    @Test
    void subMatrixOfMatrixShouldBeEqualToResultantMatrix() {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int rowToDelete = 3;
        int columnToDelete = 2;
        int[][] resultant = {{1, 3, 4}, {5, 7, 8}};
        Assertions.assertArrayEquals(resultant, matrixUtils.getSubMatrix(matrix1, rowToDelete, columnToDelete));
    }

    @Test
    void shouldThrowExceptionWhenInvalidDimensionsAreProvidedWhileFindingSubMatrix() {
        int[][] matrix1 = {{1, 3, 1}, {1, 0, 0}};
        int rowToDelete = 5;
        int columnToDelete = 2;
        Assertions.assertThrows(MatrixDimensionInvalidException.class, () -> matrixUtils.getSubMatrix(matrix1, rowToDelete, columnToDelete));
    }

    @Test
    void shouldThrowExceptionWhenInvalidDimensionsAreProvidedWhileFindingDiagonalMatrix() {
        int[][] matrix1 = {{1, 3, 1}, {1, 0, 0}};
        Assertions.assertThrows(MatrixDimensionInvalidException.class, () -> matrixUtils.getDiagonalMatrix(matrix1));
    }

    @Test
    void whenConvertedToDiagonalMatrixShouldBeEqualToResultantMatrix() {
        int[][] matrix = {{1, 2, 3}, {0, -6, 7}, {2, 2, 2}};
        int[][] resultant = {{1, 0, 0}, {0, -6, 0}, {0, 0, 2}};
        Assertions.assertArrayEquals(resultant, matrixUtils.getDiagonalMatrix(matrix));
    }

    @Test
    void whenConvertedToUpperTriangularMatrixShouldBeEqualToResultantMatrix() {
        int[][] matrix = {{1, 2, 3}, {1, -6, 7}, {2, 2, 2}};
        int[][] resultant = {{1, 2, 3}, {0, -6, 7}, {0, 0, 2}};
        Assertions.assertArrayEquals(resultant, matrixUtils.getTriangularMatrix(matrix, true));
    }

    @Test
    void whenConvertedToLowerTriangularMatrixShouldBeEqualToResultantMatrix() {
        int[][] matrix = {{1, 2, 3}, {1, -6, 7}, {2, 2, 2}};
        int[][] resultant = {{1, 0, 0}, {1, -6, 0}, {2, 2, 2}};
        Assertions.assertArrayEquals(resultant, matrixUtils.getTriangularMatrix(matrix, false));
    }

    @Test
    void determinantMatrixShouldBeEqualToResultantMatrix() {
        double[][] matrix = {{16, 42, 3}, {4, 5, 6}, {7, 8, 19}};
        double resultant = -685;
        Assertions.assertEquals(resultant, matrixUtils.getDeterminantOfMatrix(matrix));
    }

}
