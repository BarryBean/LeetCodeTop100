package com.company;

/**
 * @PackageName:com.company
 * @ClassName:DiameterOfBinaryTree_543
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/12 14:00
 */
public class DiameterOfBinaryTree_543 {
    private int max = Integer.MIN_VALUE;

    /**
     * 对每一个点都要遍历
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return max;
    }

    public int getDepth(TreeNode root) {
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
}
