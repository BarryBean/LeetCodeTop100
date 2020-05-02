package com.company;

import java.util.Arrays;

/**
 * @PackageName:com.company
 * @ClassName:UniquePaths_62
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/4 11:04
 */
public class UniquePaths_62 {
    /**
     * 最基础的动规，空间复杂度O(m*n)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 空间复杂度O(N)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}

