package com.company;

import java.util.*;

/**
 * @PackageName:com.company
 * @ClassName:LongestPalindrome_5
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/12 11:32
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = strVaild(s, i, i);
            String s2 = strVaild(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //从中间往外走
    public static String strVaild(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(reversePairs(nums));
    }


    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int result = 0;
        int i = 0, p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            //并入时计算
            result += nums[p1] > nums[p2] ? (mid - p1 + 1) : 0;
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[left + j] = help[j];
        }
        return result;
    }
}
