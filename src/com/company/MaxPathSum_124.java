package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MaxPathSum_124
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/28 11:06
 */
public class MaxPathSum_124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root);
        return max;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //和 0 比较，非常巧妙实现了
        //左+根，根，右+根的比较
        int left = Math.max(0, process(root.left));
        int right = Math.max(0, process(root.right));
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }

}
