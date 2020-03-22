package com.company;

/**
 * @author bys
 * @date 2019-11-28 18:58
 */
public class SearchRange_34 {
    /**
     * 二分查找目标值在数组中的开始和结束位置
     * 具体二分算法详解见有道云笔记文件夹：算法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=leftBound(nums,target);
        result[1]=rightBound(nums,target);
        return result;
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        //target比所有元素都大，返回-1
        if(left==nums.length){
            return -1;
        }
        //再做一次检测
        return nums[left]==target?left:-1;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }
        }
        //target比所有元素都小，返回-1
        if(right==0){
            return -1;
        }
        return nums[right-1]==target?right-1:-1;
    }
}

