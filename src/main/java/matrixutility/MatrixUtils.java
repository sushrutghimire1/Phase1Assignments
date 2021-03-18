package matrixutility;

public interface MatrixUtils {
    int[][] scalarMultiplyMatrices(int number, int[][] matrix);

    int[][] transportMatrix(int[][] matrix);

    int[][] addMatrices(int[][] matrix1, int[][] matrix2);

    int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2);

    int[][] getSubMatrix(int[][] matrix, int rowToDelete, int columnToDelete);

    int[][] getDiagonalMatrix(int[][] matrix);

    int[][] getTriangularMatrix(int[][] matrix, boolean isUpper);

    double getDeterminantOfMatrix(double[][] matrix);
}
