package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MoveZeroes_283
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/10 17:01
 */
public class MoveZeroes_283 {
    /**
     * 嵌套循环时间长
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 最佳方法
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    public static void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[b] ^ nums[a];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
