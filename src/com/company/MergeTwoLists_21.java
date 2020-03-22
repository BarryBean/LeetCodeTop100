package com.company;

/**
 * @author bys
 * @date 2019-11-25 19:09
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 合并两个有序链表为一个有序链表
        // resultList作为结果链表中的指针
        // pre用作结果链表的头节点，便于最后返回
        ListNode resultList=new ListNode(0);
        ListNode pre=resultList;
        ListNode p1=l1,p2=l2;
        //两个链表都不为空时，谁小就指向谁
        while (p1!=null && p2!=null){
            if(p1.val<=p2.val){
                resultList.next=p1;
                p1=p1.next;
                resultList=resultList.next;
            }else {
                resultList.next=p2;
                p2=p2.next;
                resultList=resultList.next;
            }
        }
        //其中一个为空时，直接把另一条不为空的链表连上结果链表
        while (p1!=null){
            resultList.next=p1;
            p1=p1.next;
            resultList=resultList.next;
        }
        while (p2!=null){
            resultList.next=p2;
            p2=p2.next;
            resultList=resultList.next;
        }
        return pre.next;
    }
}
