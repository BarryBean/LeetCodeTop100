package com.company;

import java.util.Arrays;

/**
 * @PackageName:com.company
 * @ClassName:NumSquares_279
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/1 20:15
 */
public class NumSquares_279 {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
