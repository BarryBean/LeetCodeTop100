package com.company;

/**
 * @PackageName:com.company
 * @ClassName:ProductExceptSelf_238
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/3 10:00
 */
public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2, j = 1; i >= 0; i--) {
            j *= nums[i + 1];
            ret[i] *= j;
        }
        return ret;
    }
}
