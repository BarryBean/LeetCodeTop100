package com.company;

import java.util.Arrays;

/**
 * @PackageName:com.company
 * @ClassName:LengthOfLIS_300
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/1 21:00
 */
public class LengthOfLIS_300 {
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
