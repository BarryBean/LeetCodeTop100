package com.company;

/**
 * @PackageName:com.company
 * @ClassName:TreeToDoublyList_40
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/20 10:30
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
