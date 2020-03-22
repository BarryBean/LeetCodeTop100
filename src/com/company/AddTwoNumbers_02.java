package com.company;

import java.util.ArrayList;

public class AddTwoNumbers_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置头节点，得出的答案是 0xxxxxx
        ListNode head = new ListNode(0);
        ListNode p1 = l1, q2 = l2, curr = head;
        //进位，两个个位数相加溢出则carry加1
        int carry = 0;
        //||是为了出现一个比一个位数多，空的一方就取0
        while (p1 != null || q2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (q2 != null) ? q2.val : 0;
            //sum最大值为1+9+9=19，故carry取0或1
            int sum = x + y + carry;
            //溢出的十位由carry承担
            carry = sum / 10;
            //个位保存在curr.next中
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (q2 != null) {
                q2 = q2.next;
            }
        }
        //处理可能最后一位的进位情况
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}
