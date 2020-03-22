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

    public static void main(String[] args) {
        int[] nums = {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};
        //int[] nums={2,2,1,1,1,2,2};
        //int[] nums={2,1,2,1,2,1};
        //int[] nums = {6, 5, 5};
        System.out.println(majorityElement(nums));
    }
}
