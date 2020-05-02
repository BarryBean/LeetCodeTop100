package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName:com.company
 * @ClassName:SortColors_75
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/3 9:29
 */
public class SortColors_75 {
    public static void sortColors(int[] nums) {
        int less = -1, more = nums.length;
        int cur = 0;
        while (cur < more) {
            //我们知道1放中间，所以以1作为分界数
            if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] > 1) {
                more--;
                swap(nums, more, cur);
            } else if (nums[cur] < 1) {
                less++;
                swap(nums, less, cur);
                cur++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[b] ^ nums[a];
        nums[a] = nums[a] ^ nums[b];
//        int tmp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = tmp;
    }
}
