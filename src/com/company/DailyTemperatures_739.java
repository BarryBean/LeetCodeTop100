package com.company;

import java.util.Stack;

/**
 * @PackageName:com.company
 * @ClassName:DailyTemperatures_739
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/2 13:23
 */
public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int[] nums = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (stack.size() != 0 && T[stack.peek()] < T[i]) {
                int pop = stack.pop();
                nums[pop] = i - pop;
            }
            stack.push(i);
        }
        return nums;
    }
}
