package com.company;

/**
 * @PackageName:com.company
 * @ClassName:NumTrees_96
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/28 19:47
 */
public class NumTrees_96 {
    private static int sum = 0;

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
