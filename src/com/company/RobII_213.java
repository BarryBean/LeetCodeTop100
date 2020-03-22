package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:Rob_213
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/4 16:55
 */
public class RobII_213 {
    public int rob(int[] nums) {
        return 0;
    }

    public static int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int[][] matrix = new int[m][n];
        return process(m, n, 0, 0, k, matrix);
    }

    public static int process(int m, int n, int i, int j, int k, int[][] matrix) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 1 || bitSum(i, j) > k) {
            return 0;
        }
        matrix[i][j] = 1;
        return 1 + process(m, n, i - 1, j, k, matrix) + process(m, n, i + 1, j, k, matrix)
                + process(m, n, i, j - 1, k, matrix) + process(m, n, i, j + 1, k, matrix);
    }

    public static int bitSum(int a, int b) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        while (b != 0) {
            sum += b % 10;
            b /= 10;
        }
        return sum;
    }

    public static void main(String[]  args) {
        System.out.println(movingCount(2, 3, 1));
    }
}