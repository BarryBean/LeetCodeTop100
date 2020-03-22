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

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode tmp = merge(root1, root2);
        printTree(tmp);
    }

    public static void printTree(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        printTree(head.left);
        printTree(head.right);
    }
}
