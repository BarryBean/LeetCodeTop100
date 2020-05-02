package com.company;

/**
 * @PackageName:com.company
 * @ClassName:ClimbStairs
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/7 21:49
 */
public class ClimbStairs_70 {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int one = 0, two = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
