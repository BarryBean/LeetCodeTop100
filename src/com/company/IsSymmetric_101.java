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
     * 非递归，用数组方法
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<TreeNode> arrayList1 = levelPrint(root, 0);
        ArrayList<TreeNode> arrayList2 = levelPrint(root, 1);
        if (arrayList1.size() != arrayList2.size()) {
            return false;
        }
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i) != arrayList2.get(i)) {
                return false;
            }
        }
        return true;
    }

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

    public static ArrayList<TreeNode> levelPrint(TreeNode root, int flag) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                arrayList.add(node);
                if (flag == 0) {
                    queue.add(root.left);
                    queue.add(root.right);
                } else if (flag == 1) {
                    queue.add(root.right);
                    queue.add(root.left);
                }
            }
        }
        return arrayList;
    }
}
