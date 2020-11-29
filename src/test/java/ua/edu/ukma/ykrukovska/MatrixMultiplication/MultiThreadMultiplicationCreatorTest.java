package ua.edu.ukma.ykrukovska.MatrixMultiplication;

import org.junit.jupiter.api.Test;

class MultiThreadMultiplicationCreatorTest {

    @Test
    public void multiply3x3Matrix() {
        int[][] matrix1 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] matrix2 = {{3, 3, 3}, {2, 2, 2}, {1, 1, 1}};
        int[][] result = new int[3][3];
        MultiThreadMultiplicationCreator.multiply(matrix1, matrix2, result);
        MatrixUtil.printMatrix(result);
    }

    @Test
    public void multiply8x8Matrix() {
        int[][] matrix1 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        int[][] matrix2 = {{8, 8, 8, 8}, {7, 7, 7, 7}, {6, 6, 6, 6}, {5, 5, 5, 5}};
        int[][] result = new int[4][4];
        MultiThreadMultiplicationCreator.multiply(matrix1, matrix2, result);
        MatrixUtil.printMatrix(result);
    }

    @Test
    public void multiply8x8MatrixDifferentParams() {
        int[][] matrix1 = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        int[][] matrix2 = {{4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}, {16, 17, 18, 19}};
        int[][] result = new int[4][4];
        MultiThreadMultiplicationCreator.multiply(matrix1, matrix2, result);
        MatrixUtil.printMatrix(result);
    }
}