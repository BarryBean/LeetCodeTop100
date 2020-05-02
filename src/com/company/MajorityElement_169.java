package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MajorityElement_169
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/11 17:08
 */
public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                tmp = nums[i];
                count++;
            } else {
                count = tmp == nums[i] ? count + 1 : count - 1;
            }
        }
        return tmp;
    }
}
