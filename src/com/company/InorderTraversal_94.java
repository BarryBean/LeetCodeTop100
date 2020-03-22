package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @PackageName:com.company
 * @ClassName:InorderTraversal_94
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/12 12:43
 */
public class InorderTraversal_94 {
    /**
     * 迭代解法，用栈辅助
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new LinkedList<>();
        if(root!=null){
            Stack<TreeNode> stack =new Stack<>();
            while (!stack.isEmpty() || root!=null){
                if(root!=null){
                    stack.push(root);
                    root=root.left;
                }else {
                    root=stack.pop();
                    list.add(root.val);
                    root=root.right;
                }
            }
        }
        return list;
    }

    List<Integer> list =new LinkedList<>();
    public List<Integer> inorder(TreeNode root){
        while (root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
        return list;
    }


}
