package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:FindDisappearedNumbers_448
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/10 20:03
 */
public class FindDisappearedNumbers_448 {
    /**
     * 思路相似，但标准答案比这个更简便
     * 直接将元素置反，不用交换元素值节省时间
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != (i + 1)) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[b] ^ nums[a];
        nums[a] = nums[a] ^ nums[b];
    }

    /**
     * 标准答案直接将元素值置反，最后统计正值便可
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]) - 1;
            if (nums[tmp] > 0) {
                nums[tmp] = -nums[tmp];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        for (int tmp : list) {
            System.out.print(tmp + " ");
        }
    }
}
