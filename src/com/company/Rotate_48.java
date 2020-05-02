package com.company;

/**
 * @author bys
 * @date 2019-11-29 19:05
 */
public class Rotate_48 {
    public void rotate(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            process(matrix, top++, left++, bottom--, right--);
        }
    }

    private void process(int[][] matrix, int top, int left, int bottom, int right) {
        int time = bottom - top;
        int tmp = 0;
        for (int i = 0; i < time; i++) {
            tmp = matrix[top][left + i];
            matrix[top][left + i] = matrix[bottom - i][left];
            matrix[bottom - i][left] = matrix[bottom][right - i];
            matrix[bottom][right - i] = matrix[top + i][right];
            matrix[top + i][right] = tmp;
        }
    }
}
