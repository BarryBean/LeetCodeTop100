package com.company;

/**
 * @PackageName:com.company
 * @ClassName:LowestCommonAncestor_236
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/10 10:58
 */
public class LowestCommonAncestor_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
