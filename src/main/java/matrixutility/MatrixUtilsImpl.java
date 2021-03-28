package matrixutility;


import matrixutility.exceptions.MatrixDimensionInvalidException;

public class MatrixUtilsImpl implements MatrixUtils {
    @Override
    public int[][] scalarMultiplyMatrices(int number, int[][] matrix) {
        int[][] resultantMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultantMatrix[i][j] = number * matrix[i][j];
            }
        }
        return resultantMatrix;
    }

    @Override
    public int[][] transportMatrix(int[][] matrix) {
        int[][] resultantMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultantMatrix[j][i] = matrix[i][j];
            }
        }
        return resultantMatrix;
    }

    @Override
    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2[0].length || matrix1.length != matrix2.length)
            throw new MatrixDimensionInvalidException();
        int[][] resultantMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                resultantMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultantMatrix;
    }

    @Override
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length)
            throw new MatrixDimensionInvalidException();
        int[][] resultantMatrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                resultantMatrix[i][j] = 0;
                for (int k = 0; k < matrix2.length; k++) {
                    resultantMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultantMatrix;
    }

    @Override
    public int[][] getSubMatrix(int[][] matrix, int rowToDelete, int columnToDelete) {
        if (rowToDelete > matrix.length || columnToDelete > matrix[0].length || rowToDelete < 0 || columnToDelete < 0)
            throw new MatrixDimensionInvalidException();
        int[][] resultantMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        int row = -1, column;
        for (int i = 0; i < matrix.length; i++) {
            row++;
            column = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != rowToDelete - 1 && j != columnToDelete - 1) {
                    resultantMatrix[row][column++] = matrix[i][j];
                }
            }
        }
        return resultantMatrix;
    }

    @Override
    public int[][] getDiagonalMatrix(int[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new MatrixDimensionInvalidException();
        int[][] resultantMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j)
                    resultantMatrix[i][j] = matrix[i][j];
                else resultantMatrix[i][j] = 0;
            }
        }
        return resultantMatrix;

    }

    @Override
    public int[][] getTriangularMatrix(int[][] matrix, boolean isUpper) {
        if (matrix.length != matrix[0].length)
            throw new MatrixDimensionInvalidException();
        int[][] resultantMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isUpper) {
                    if (i <= j)
                        resultantMatrix[i][j] = matrix[i][j];
                    else resultantMatrix[i][j] = 0;
                } else {
                    if (i >= j)
                        resultantMatrix[i][j] = matrix[i][j];
                    else resultantMatrix[i][j] = 0;
                }
            }
        }
        return resultantMatrix;
    }

    @Override
    public double getDeterminantOfMatrix(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new MatrixDimensionInvalidException();
        double[][] temp;
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return result;
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return result;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temp = new double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow(-1, i) * getDeterminantOfMatrix(temp);
        }
        return result;
    }
}
