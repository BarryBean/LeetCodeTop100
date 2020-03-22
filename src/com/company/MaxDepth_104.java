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
        return 1+( leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(11);
        System.out.println(maxDepth(root));

    }
}
