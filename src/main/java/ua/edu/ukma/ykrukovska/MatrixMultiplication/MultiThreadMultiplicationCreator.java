package ua.edu.ukma.ykrukovska.MatrixMultiplication;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadMultiplicationCreator {

    public static int findAmountOfParts(int[][] matrix2) {
        int matrixSize = matrix2.length;
        int result = 0;
        if (matrixSize % 4 == 0) {
            result = 4;
        } else if (matrixSize % 3 == 0) {
            result = 3;
        } else if (matrixSize % 2 == 0) {
            result = 2;
        } else {
            result = 1;
        }

        return result;
    }

    public static void multiply(int[][] matrix1, int[][] matrix2, int[][] result) {
        int parts = findAmountOfParts(matrix2);
        int matrixSize = matrix2.length;
        int colsInPart = matrixSize / parts;

        List<Thread> threads = new ArrayList<>();
        int currentColumn = 0;

        for (int i = 0; i < parts; i++) {
            int[][] tempMatrix2 = new int[matrixSize][colsInPart];

            int endOfCurrentPart = currentColumn + colsInPart;
            for (int j = 0; j < matrixSize; j++) {
                for (int k = currentColumn, l = 0; k < endOfCurrentPart; k++, l++) {
                    tempMatrix2[j][l] = matrix2[j][k];
                }
            }

            MultiplyWorker task = new MultiplyWorker(matrix1, tempMatrix2, result, currentColumn, colsInPart);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            currentColumn += colsInPart;
        }
        waitForThreads(threads);

    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
