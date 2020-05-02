package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bys
 * @date 2019-11-23 16:35
 */
public class ThreeNum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        //a+b+c=0可以看成是a+b=-c，转换为两数之和
        for (int i = 0; i < nums.length; i++) {
            //最小的元素都大于0，其他没得玩了
            if (nums[i] > 0) {
                break;
            }
            //和前一个元素一样，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }

}
