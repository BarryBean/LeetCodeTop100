package com.company;

/**
 * @PackageName:com.company
 * @ClassName:ReverseList_206
 * @Description
 * @Author: yushengbi
 * @Date:2020/5/1 13:21
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
