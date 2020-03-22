package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName:com.company
 * @ClassName:LevelOrder_102
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/12 11:04
 */
public class LevelOrder_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    continue;
                }
                list.add(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
            if(list.size()==0){
                continue;
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.left.left = new TreeNode(16);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(5);

        List<List<Integer>> lists = levelOrder(root1);
        System.out.println(lists);
    }
}
