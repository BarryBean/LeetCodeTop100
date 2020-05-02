package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MaximalSquare_221
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/24 11:38
 */
public class MaximalSquare_221 {
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
