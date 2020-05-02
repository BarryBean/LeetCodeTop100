package com.company;

import java.util.Stack;

/**
 * @PackageName:com.company
 * @ClassName:IsValidBST_98
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/28 20:27
 */
public class IsValidBST_98 {

    static TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    static boolean flag = true;

    /**
     * 递归遍历
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        process(root);
        return flag;
    }


    public static void process(TreeNode root) {
        if (root != null) {
            process(root.left);
            flag = preNode.val > root.val ? false : true;
            if (!flag) {
                return;
            }
            preNode = root;
            process(root.right);
        }
    }


    /**
     * 非递归中序遍历判断BST
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long preData = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= preData) {
                    return false;
                } else {
                    preData = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }
}
