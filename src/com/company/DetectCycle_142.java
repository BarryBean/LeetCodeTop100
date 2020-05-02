package com.company;

/**
 * @PackageName:com.company
 * @ClassName:DetectCycle_142
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/1 11:25
 */
public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

