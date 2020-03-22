package com.company;

/**
 * @PackageName:com.company
 * @ClassName:ConvertBST_538
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/11 16:17
 */
public class ConvertBST_538 {
    static int tmp = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += tmp;
        tmp = root.val;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);

        convertBST(root1);
        printTree(root1);
    }

    public static void printTree(TreeNode head) {
        if (head == null) {
            return;
        }
        printTree(head.left);
        System.out.print(head.val + " ");
        printTree(head.right);
    }
}
