package com.company;

/**
 * @author bys
 * @date 2019-11-25 19:09
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        //两个链表都不为空时，谁小就指向谁
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        //其中一个为空时，直接把另一条不为空的链表连上结果链表
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return dummy.next;
    }
}
