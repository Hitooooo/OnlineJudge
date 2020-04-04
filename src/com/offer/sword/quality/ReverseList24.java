package com.offer.sword.quality;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。头插法。
 * 
 * @author hitomeng
 * @date 2020-04-04 23:00:46
 */
public class ReverseList24{

    public ListNode reverseRec(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 记录需要反转的第一个结点，也就是反转后的最后一个结点
        ListNode next = head.next;
        ListNode newHead = reverseRec(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = null;
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            if(next == null){
               newHead = current;
            }
            current.next = pre;
            pre = current;
            current = next;
            
        }
        return newHead;
    }

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = reverseRec(n1);
        System.out.println(head.toString());
    }
}