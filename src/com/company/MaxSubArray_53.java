package com.company;

/**
 * @author bys
 * @date 2019-11-29 19:58
 */
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }

        int max=Integer.MIN_VALUE,sum=0;
        for(int i :nums){
            //当sum为正时对结果有增益作用，则保留并加上当前的i
            //当sum为负时对结果无增益作用，则舍弃并从当前的i重新计sum
            sum=sum<0?i:sum+i;
            max=sum>max?sum:max;
        }
        return max;
    }
}
