package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MaxProfit_121
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/1 20:45
 */
public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int n = prices.length;
        //天数 状态(持有/未持有)
/*        int[][] dp=new int[n][2];
        for (int i = 0; i < n; i++) {
            if(i-1==-1){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            //第i天没有股票=i-1天卖了或者i-1也没有
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //第i天有股票=i-1天买了或者i-1天没有今天刚买
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];*/
        //相当于用一个变量存储前一天状态
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
