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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 1, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
