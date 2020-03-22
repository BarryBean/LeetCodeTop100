package com.company;

public class InvertTree_226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        printTree(root);
        System.out.println("-----------");
        TreeNode node = invertTree(root);
        printTree(node);
    }

    public static void printTree(TreeNode root) {
        if(root==null){
            return;
        }
            System.out.println(root.val+"");
            printTree(root.left);
            printTree(root.right);
    }
}
