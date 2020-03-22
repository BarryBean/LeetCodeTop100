package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.company
 * @ClassName:Trap_42
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/8 10:33
 */
public class Trap_42 {
    /**
     * 备忘录解法
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int sum = 0;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = height[0];
        rMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            int dis = Math.min(lMax[i], rMax[i]) - height[i];
            sum = dis > 0 ? sum + dis : sum;
        }
        return sum;
    }

    /**
     * 双指针解法
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int sum = 0;
        int left = 0, right = n - 1;
        int l_max = height[left], r_max = height[right];

        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if (l_max < r_max) {
                sum += l_max - height[left];
                left++;
            } else {
                sum += r_max - height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

    }

    public static int[] spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int[] ret = new int[(bottom + 1) * (right + 1)];
        int index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ret[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                ret[index++] = matrix[i][right];
            }
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ret[index++] = matrix[bottom][i];
                }
            }
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    ret[index++] = matrix[i][left];
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return ret;
    }
}
