package com.company;

import java.util.*;

/**
 * @PackageName:com.company
 * @ClassName:Serialize_297
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/28 17:07
 */
public class Serialize_297 {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        StringBuffer res = new StringBuffer(root.val + "_");
        res.append(serialize(root.left));
        res.append(serialize(root.right));
        return res.toString();
    }


    public TreeNode deserialize(String data) {
        String[] str = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            queue.offer(str[i]);
        }
        return process(queue);
    }

    private TreeNode process(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = process(queue);
        node.right = process(queue);
        return node;
    }

    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < nums.length; i++) {
            int n2 = nums[i2] * 2, n3 = nums[i3] * 3, n5 = nums[i5] * 5;
            nums[i] = Math.min(n2, Math.min(n3, n5));
            if (nums[i] == n2) {
                i2++;
            }
            if (nums[i] == n3) {
                i3++;
            }
            if (nums[i] == n5) {
                i5++;
            }
        }
        return nums[n - 1];

    }


}
