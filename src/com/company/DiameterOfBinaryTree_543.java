package com.company;

/**
 * @PackageName:com.company
 * @ClassName:DiameterOfBinaryTree_543
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/12 14:00
 */
public class DiameterOfBinaryTree_543 {
    private static int max = Integer.MIN_VALUE;

    /**
     * 对每一个点都要遍历
     *
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return max;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth1 = getDepth(root.left);
        int depth2 = getDepth(root.right);
        if (depth1 + depth2 > max) {
            max = depth1 + depth2;
        }
        return Math.max(depth1, depth2) + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.left.left = new TreeNode(16);
        root1.left.left.right = new TreeNode(6);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root1));
    }
}
