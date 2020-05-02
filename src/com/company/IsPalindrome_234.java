package com.company;

import java.util.ArrayList;

/**
 * @PackageName:com.company
 * @ClassName:IsPalindrome_234
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/10 14:50
 */

public class IsPalindrome_234 {
    /**
     * 用数组实现，空间复杂度O(N)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!arrayList.get(i).equals(arrayList.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 快慢指针，空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next, pre = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = null;
        slow = head;
        while (slow != null && pre != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

}
