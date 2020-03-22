package com.company;

public class TreeToDoublyList_40 {
    public static Node treeToDoublyList(Node root) {
        Node head = new Node(0);
        if (root == null) {
            return head;
        }
        process(root);
        Node first = root, end = root;
        while (end.right != null) {
            end = end.right;
        }
        while (first.left != null) {
            first = first.left;
        }

        end.right = first;
        first.left = end;
        head.right = first;

        return head;
    }

    static Node start = null;
    static Node pre = null;

    public static void process(Node root) {
        if (root == null) {
            return;
        }
        process(root.left);
        if (pre == null) {
            pre = root;
            start = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        process(root.right);
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        //ax+by=z 找xy的最大公约数
        //辗转相除法
        //先把x设为较大值
        int tmp = x;
        x = x > y ? x : y;
        y = tmp == x ? y : tmp;
        //直到没有余数
        while (tmp != 0) {
            tmp = x % y;
            x = y;
            y = tmp;
        }
        if (y == 1 || tmp == 0) {
            return false;
        }
        //检测最大公约数是否是z的倍数
        if (tmp % z == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        treeToDoublyList(root);

    }
}
