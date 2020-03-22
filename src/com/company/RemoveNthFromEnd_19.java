package com.company;

/**
 * @author bys
 * @date 2019-11-24 20:46
 */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //指针问题需要先设置一个头节点，方便后续操作
        ListNode pre = new ListNode(0);
        pre.next=head;
        //快慢指针
        ListNode slow=pre;
        ListNode fast=pre;

        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;

        return pre.next;
    }
}
