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
        if (head == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //将后半部分逆转
        fast = slow.next;
        ListNode tmp = null;
        slow.next = null;
        while (fast != null) {
            tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        //逆转后同时从左和右进行判断
        //此时slow指向最后一个结点，fast为null
        fast = head;
        tmp = slow;
        boolean isPalind = true;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                isPalind = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        //将后半部分恢复正常
        slow = tmp.next;
        tmp.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = tmp;
            tmp = slow;
            slow = fast;
        }
        return isPalind;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        //node.next = new ListNode(2);
        //node.next.next = new ListNode(3);
        //node.next.next.next = new ListNode(2);
        //node.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome1(node));
    }
}
