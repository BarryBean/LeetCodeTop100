package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MaxProduct_152
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/1 11:40
 */
public class MaxProduct_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
