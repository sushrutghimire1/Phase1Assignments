package matrixutility;

public class MatrixApplication {
    private MatrixUtils matrixUtils;

    public void setMatrixUtils(MatrixUtils matrixUtils) {
        this.matrixUtils = matrixUtils;
    }

    public int[][] scalarMultiplyMatrices(int number, int[][] matrix) {
        return matrixUtils.scalarMultiplyMatrices(number, matrix);
    }

    public int[][] transportMatrix(int[][] matrix) {
        return matrixUtils.transportMatrix(matrix);
    }

    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        return matrixUtils.addMatrices(matrix1, matrix2);
    }

    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        return matrixUtils.multiplyMatrices(matrix1, matrix2);
    }

    public int[][] getSubMatrix(int[][] matrix, int rowToDelete, int columnToDelete) {
        return matrixUtils.getSubMatrix(matrix, rowToDelete, columnToDelete);
    }

    public int[][] getDiagonalMatrix(int[][] matrix) {
        return matrixUtils.getDiagonalMatrix(matrix);
    }

    public int[][] getTriangularMatrix(int[][] matrix, boolean isUpper) {
        return matrixUtils.getTriangularMatrix(matrix, isUpper);
    }

    public double getDeterminantOfMatrix(double[][] matrix) {
        return matrixUtils.getDeterminantOfMatrix(matrix);
    }
}

