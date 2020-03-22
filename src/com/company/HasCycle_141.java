package com.company;

/**
 * @PackageName:com.company
 * @ClassName:HasCycle_141
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/13 20:42
 */
public class HasCycle_141 {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        System.out.println(hasCycle(node));
    }
}
