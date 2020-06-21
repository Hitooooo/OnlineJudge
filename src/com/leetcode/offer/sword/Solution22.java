package com.leetcode.offer.sword;

import com.leetcode.struct.ListNode;

import org.junit.Test;

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k < 1 || head == null) {
            return null;
        }
        ListNode node = head;
        while(k > 1 && node != null){
           node = node.next; 
           k--;
        }
        if(k > 1){
            return null;
        }
        while(node != null && node.next != null){
            head = head.next;
            node = node.next;
        }
        return head;
    }

    @Test
    public void test() {
        
    }
}