package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:Permute_46
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/13 16:03
 */
public class Permute_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        process(nums, 0, lists, new ArrayList<Integer>());
        return lists;
    }

    public static void process(int[] nums, int i, List<List<Integer>> lists, List<Integer> list) {
        if (i == nums.length) {
            for (int num : nums) {
                list.add(num);
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            process(nums, i + 1, lists, list);
            swap(nums, i, j);
        }
    }


    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
