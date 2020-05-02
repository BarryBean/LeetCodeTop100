package com.company;

/**
 * @PackageName:com.company
 * @ClassName:MergeKLists_23
 * @Description
 * @Author: yushengbi
 * @Date:2020/4/30 21:27
 */
public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        ListNode l = mergeSort(lists, left, mid);
        ListNode r = mergeSort(lists, mid + 1, right);
        return merge(l, r);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p = left, q = right;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }
        return dummy.next;
    }
}
