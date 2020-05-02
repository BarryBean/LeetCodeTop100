package com.company;

/**
 * @PackageName:com.company
 * @ClassName:ConvertBST_538
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/11 16:17
 */
public class ConvertBST_538 {
    int tmp = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += tmp;
        tmp = root.val;
        convertBST(root.left);
        return root;
    }
}
