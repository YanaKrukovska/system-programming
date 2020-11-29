package ua.edu.ukma.ykrukovska.MatrixMultiplication;

public class MultiplyWorker implements Runnable {

    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int[][] result;
    private final int currentCol;
    private final int colsInPart;

    public MultiplyWorker(int[][] matrix1, int[][] matrix2, int[][] result, int currentCol, int colsInPart) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        this.currentCol = currentCol;
        this.colsInPart = colsInPart;
    }

    @Override
    public void run() {
        int row = matrix1.length;

        int lastCol = currentCol + colsInPart;
        for (int i = 0; i < row; i++) {
            for (int j = currentCol, l = 0; j < lastCol; j++, l++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][l];
                }
            }
        }

    }
}