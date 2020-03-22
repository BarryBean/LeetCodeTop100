package com.company;

/**
 * @PackageName:com.company
 * @ClassName:SingleNumber_136
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/1 19:36
 */
public class SingleNumber_136 {

    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
