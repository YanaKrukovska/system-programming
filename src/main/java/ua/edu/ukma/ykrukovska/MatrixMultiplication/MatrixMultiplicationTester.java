package ua.edu.ukma.ykrukovska.MatrixMultiplication;

import java.util.Date;

public class MatrixMultiplicationTester {

    public static final int MATRIX_SIZE = 2000;

    public static void main(String[] args) {

        Date start1 = new Date();

        int[][] matrix1 = MatrixUtil.generateMatrix(MATRIX_SIZE, MATRIX_SIZE);
        int[][] matrix2 = MatrixUtil.generateMatrix(MATRIX_SIZE, MATRIX_SIZE);

        int[][] result1 = MatrixMultiplication.multiply(matrix1, matrix2);

        Date end1 = new Date();
        System.out.println("Regular multiplication, time taken in seconds: " + ((end1.getTime() - start1.getTime()) / 1000) + "\n");


        Date start2 = new Date();

        int[][] result2 = new int[MATRIX_SIZE][MATRIX_SIZE];
        MultiThreadMultiplicationCreator.multiply(matrix1, matrix2, result2);

        Date end2 = new Date();
        System.out.println("Multi thread multiplication, time taken in seconds: " + ((end2.getTime() - start2.getTime()) / 1000));
    }
}
