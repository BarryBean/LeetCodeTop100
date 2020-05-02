package com.company;

import java.util.Arrays;

/**
 * @PackageName:com.company
 * @ClassName:CoinChange_322
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/21 23:54
 */
public class CoinChange_322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
