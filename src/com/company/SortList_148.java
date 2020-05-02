package com.company;

/**
 * @PackageName:com.company
 * @ClassName:SortList_148
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/1 11:33
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }
}
