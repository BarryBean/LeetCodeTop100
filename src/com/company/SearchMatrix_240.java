package com.company;

/**
 * @PackageName:com.company
 * @ClassName:SearchMatrix_240
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/24 11:06
 */
public class SearchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
