package com.company;

import java.util.Arrays;

/**
 * @author bys
 * @date 2019-11-26 21:12
 */
public class Search_33 {
    public int search(int[] nums, int target) {
        //要求算法复杂度为log(n)
        //普通遍历找到偏移量复杂度为o(n)
        //所以本题用二分查找
        //第一类：start<=mid，前半部分有序
        // 继而判断start<=target<mid，则在前半部分找，否则后半部分找
        //第二类：start>mid，后半部分有序
        // 继而判断mid<target<=end，则在后半部分找，否则前半部分找
        if(nums == null || nums.length==0){
            return -1;
        }
        int start=0,end=nums.length-1,mid=0;
        while (start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            //前半部分有序
            if(nums[start]<=nums[mid]){
                if(target>=nums[start] && target<nums[mid]){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else {
                //后半部分有序
                if(target<=nums[end] && target>nums[mid]){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找返回查找值在数组中的索引
     *
     * @param nums
     * @param target
     * @return
     */
    public int BinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        //查找不到返回-1
        return -1;
    }
}
