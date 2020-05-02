package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackageName:com.company
 * @ClassName:IsSymmetric_101
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/9 14:44
 */
public class IsSymmetric_101 {

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public static boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }

}
