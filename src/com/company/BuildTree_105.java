package com.company;

import java.util.Arrays;

/**
 * @PackageName:com.company
 * @ClassName:BuildTree_105
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/28 21:42
 */
public class BuildTree_105 {
    /**
     * 取巧，用了Arrays.copyOfRange，每次内部都在做创建赋值的操作
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null | inorder == null | preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return node;
    }

    /**
     * 纯粹通过限定前序和后序边界做，不用额外的空间
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null | inorder == null | preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode process(int[] preorder, int prebegin, int preend, int[] inorder, int inbegin, int inend) {
        if (prebegin > preend) {
            return null;
        }
        int mid = inbegin;
        //找到中序中的root序号
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == preorder[prebegin]) {
                mid = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[prebegin]);
        root.left = process(preorder, prebegin + 1, prebegin + mid - inbegin, inorder, inbegin, mid - 1);
        root.right = process(preorder, prebegin + mid - inbegin + 1, preend, inorder, mid + 1, inend);
        return root;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2};
        int[] in = {2, 1};
        TreeNode node = buildTree2(pre, in);
        System.out.println(node);
    }
}
