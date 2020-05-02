package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MaxDepth_104
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/9 17:43
 */
public class MaxDepth_104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

}
