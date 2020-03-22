package com.company;

import java.util.ArrayList;

/**
 * @PackageName:com.company
 * @ClassName:FindDuplicate_287
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/3 10:43
 */
public class FindDuplicate_287 {
    public static int findDuplicate(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    ret = nums[i];
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        return ret;
    }

    /**
     * 一个意思
     *
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        int ret = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                //eg. 3,1,2=>swap(nums,0,3-1)
                if (nums[nums[i] - 1] == nums[i]) {
                    ret = nums[i];
                    break;
                }
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
                continue;
            }
        }
        return ret;
    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[b] ^ nums[a];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(findDuplicate(nums));
        int[] nums1 = {2, 1, 2};
        System.out.println(findDuplicate1(nums1));
    }


}
