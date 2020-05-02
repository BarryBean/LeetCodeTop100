package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MergeTrees_617
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/10 15:36
 */
public class MergeTrees_617 {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        //return merge(t1, t2);
        return t1;
    }

    public static TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        root.left = merge(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = merge(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }
}
