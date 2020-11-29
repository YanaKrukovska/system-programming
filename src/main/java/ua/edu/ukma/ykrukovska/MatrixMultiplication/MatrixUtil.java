package ua.edu.ukma.ykrukovska.MatrixMultiplication;

import java.util.Random;

public class MatrixUtil {

    public static int[][] generateMatrix(int rows, int columns) {

        int[][] result = new int[rows][columns];

        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = random.nextInt();
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        int columns = matrix[0].length;

        for (int[] ints : matrix) {
            for (int i = 0; i < columns; i++) {
                System.out.print(ints[i] + "  ");
            }
            System.out.println();
        }
    }

}