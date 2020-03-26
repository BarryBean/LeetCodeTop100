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
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(process(nums, 0, n - 2), process(nums, 1, n - 1));
    }


    public int process(int[] nums, int start, int end) {
        int n = nums.length;
        //记录dp[i+1]和dp[i+2]
        int one = 0, two = 0;
        //dp[i]
        int cur = 0;
        for (int i = end; i >= start; i--) {
            cur = Math.max(one, nums[i] + two);
            two = one;
            one = cur;
        }
        return cur;
    }
}