package com.company;

/**
 * @PackageName:com.company
 * @ClassName:GetIntersectionNode_160
 * @Description
 * @Author: yushengbi
 * @Date:2020/2/11 16:46
 */
public class GetIntersectionNode_160 {
    /**
     * 题目假设链表无环
     * 先判断是否相交
     * 根据两链表的len差距，知道较长的链表
     * 让长的链表先走len
     * 之后两条一起走，相交点就是所求
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        int len = 0;
        while (curA != null) {
            len++;
            curA = curA.next;
        }
        while (curB != null) {
            len--;
            curB = curB.next;
        }
        if (curA != curB) {
            return null;
        }
        //两链表相交
        //A放长，B放短
        curA = len > 0 ? headA : headB;
        curB = curA == headA ? headB : headA;
        len = Math.abs(len);
        //长的先走
        while (len-- > 0) {
            curA = curA.next;
        }
        //同时走
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
