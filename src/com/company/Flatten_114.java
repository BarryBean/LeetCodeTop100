package com.company;

/**
 * @PackageName:com.company
 * @ClassName:flatten_114
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/28 23:12
 */
public class Flatten_114 {
    /**
     * 非递归解法
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    /**
     * 递归解法，后序遍历
     */
    private TreeNode pre = null;

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.right);
        flatten1(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
