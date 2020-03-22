package com.company;

/**
 * @PackageName:com.company
 * @ClassName:Rob_198
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/1 19:54
 */
public class Rob_198 {
    public static int rob(int[] nums) {
        memory = new int[nums.length];
        for (int i = 0; i < memory.length; i++) {
            memory[i]=-1;
        }
        return dp(nums, 0);
    }

    private static int[] memory;

    private static int dp(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if(memory[i]!= -1){
            return memory[i];
        }
        int res = Math.max(
                dp(nums, i + 1),
                dp(nums, i + 2) + nums[i]
        );
        memory[i]=res;
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1};
        System.out.println(rob(num));
    }
}
