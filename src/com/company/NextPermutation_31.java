package com.company;

import java.util.Arrays;

/**
 * @author bys
 * @date 2019-11-26 19:45
 */
public class NextPermutation_31 {
    // 计算字典序算法
    // 1.从右往左，找出第一个左边小于右边的数，记为list[a]
    // 2.重新从右往左，找出第一个大于list[a]的数，设为list[b]
    // 3.交换list[a],list[b]
    // 4.将list[a]后面的数，从小到大排序

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int a = 0, b = 0, tmp = 0,flag=0;

        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                a = i - 1;
                flag=1;
                break;
            }
        }

        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[a]) {
                b = i;
                break;
            }
        }

        if(flag==0){
            Arrays.sort(nums);
        }else {
            tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
            //sort函数是左闭右开区间
            Arrays.sort(nums, a+1, length);
        }

    }
}
