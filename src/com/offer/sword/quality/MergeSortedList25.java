package com.offer.sword.quality;

import com.leetcode.struct.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * @author hitomeng
 * @date 2020-04-04 23:56:35
 */
public class MergeSortedList25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 != null){
            head.next = list1;
        }else if(list2 != null){
            head.next = list2;
        }
        return res.next;
    }
}