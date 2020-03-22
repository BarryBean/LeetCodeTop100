package com.company;

/**
 * @PackageName:com.company
 * @ClassName:PathSum_437
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/21 23:13
 */
public class PathSum_437 {
    /**
     * 最容易的写法，但最坏情况O(n^2)
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        process(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private int count;

    public void process(TreeNode root, int sum, int cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (cur == sum) {
            count++;
        }
        process(root.left, sum, cur);
        process(root.right, sum, cur);
        cur -= root.val;
    }

    /**
     * 用数组存储当前节点为终点的路径和
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root, int sum) {
        return process(root, sum, new int[1000], 0);
    }

    private int process(TreeNode root, int sum, int[] array, int p) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = process(root.left, sum, array, p + 1);
        int n2 = process(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }

}
