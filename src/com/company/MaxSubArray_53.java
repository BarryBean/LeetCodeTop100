package com.company;

/**
 * @author bys
 * @date 2019-11-29 19:58
 */
public class MaxSubArray_53 {
    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (int i : nums) {
            //当sum为正时对结果有增益作用，则保留并加上当前的i
            //当sum为负时对结果无增益作用，则舍弃并从当前的i重新计sum
            sum = sum < 0 ? i : sum + i;
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 动规
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        int[] dp = new int[n + 1];
        int max = nums[0];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(nums[i], dp[i] + nums[i]);
            max = Math.max(dp[i + 1], max);
        }
        return max;
    }
}
