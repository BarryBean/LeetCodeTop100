package com.company;

/**
 * @PackageName:com.company
 * @ClassName:CanJump_55
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/26 9:58
 */
public class CanJump_55 {
    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
