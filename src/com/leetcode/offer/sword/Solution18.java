package com.leetcode.offer.sword;

import com.leetcode.struct.ListNode;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
                curr = pre.next;
                break;
            }else{
                pre = curr;
                curr = curr.next;
            }
        }
        return newHead.next;
    }    
}